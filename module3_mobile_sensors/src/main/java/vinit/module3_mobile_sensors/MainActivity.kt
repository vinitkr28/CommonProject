package vinit.module3_mobile_sensors

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), SensorEventListener {

    private var view1: View? = null
    private var view2: View? = null

    private var sensorManager: SensorManager? = null

    private var proximitySensor: Sensor? = null
    private var gyroscopeSensor: Sensor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view1 = findViewById(R.id.view1)
        view2 = findViewById(R.id.view2)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        proximitySensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        gyroscopeSensor =
            sensorManager!!.getDefaultSensor(Sensor.TYPE_GYROSCOPE)


        // Create a listener
        // Create a listener
        var gyroscopeSensorListener = object : SensorEventListener {
            override fun onSensorChanged(sensorEvent: SensorEvent) {
                // More code goes here
            }

            override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
        }

        // Register the listener

        // Register the listener
        sensorManager!!.registerListener(
            gyroscopeSensorListener,
            gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL
        )


    }

    override fun onResume() {
        super.onResume()
        if (proximitySensor == null) {
            Log.e(TAG, "Proximity sensor not available.")

        } else {
            Log.d(TAG, "Proximity sensor available.(/\\)")
            // Register it, specifying the polling interval in
            // microseconds
            sensorManager?.registerListener(
                this,
                proximitySensor, 2 * 1000 * 1000
            )
        }

        if (sensorManager == null){
            Log.e(TAG, "sensorManager not available.")
        } else {
            sensorManager!!.registerListener(object : SensorEventListener {
                override fun onSensorChanged(sensorEvent: SensorEvent?) {
                    if (sensorEvent != null) {
                        Log.d(TAG, "onSensorChanged2: ${sensorEvent.values.toList()} >>> ${proximitySensor.toString()}")
                        if(sensorEvent.values[0] > 0.5f) { // anticlockwise
                            view2?.setBackgroundColor(Color.BLUE);
                        } else if(sensorEvent.values[0] < -0.5f) { // clockwise
                            view2?.setBackgroundColor(Color.YELLOW)
                        } else if (sensorEvent.values[0] ==0f){
                            view2?.setBackgroundColor(resources.getColor(R.color.purple_200))
                        }
                    }
                }

                override fun onAccuracyChanged(sensor: Sensor?, p1: Int) {
                    Log.d(TAG, "onAccuracyChanged2: ${sensor.toString()}, $p1")
                }
            }, gyroscopeSensor!!, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this);
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        if (sensorEvent != null) {
            Log.d(TAG, "onSensorChanged1: ${sensorEvent.values.toList()} ->> ${proximitySensor.toString()}")
            if(sensorEvent.values[0] < proximitySensor!!.maximumRange) {
                // Detected something nearby
                view1?.setBackgroundColor(Color.RED);
            } else {
                // Nothing is nearby
                view1?.setBackgroundColor(Color.GREEN);
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, p1: Int) {
        Log.d(TAG, "onAccuracyChanged1: ${sensor.toString()}")
    }

}