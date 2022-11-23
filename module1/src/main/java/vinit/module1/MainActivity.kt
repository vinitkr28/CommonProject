package vinit.module1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vinit.module1.ui.MainFragment
import android.util.Log.d

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        d("MainActivity", "BASE_URL_EU_DEVELOPMENT: ${BuildConfig.BASE_URL_EU_DEVELOPMENT}")
        d("MainActivity", "APPLICATION_ID: ${BuildConfig.APPLICATION_ID}")
        d("MainActivity", "BUILD_TYPE: ${BuildConfig.BUILD_TYPE}")
        d("MainActivity", "VERSION_CODE: ${BuildConfig.VERSION_CODE}")
        d("MainActivity", "VERSION_NAME: ${BuildConfig.VERSION_NAME}")

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}