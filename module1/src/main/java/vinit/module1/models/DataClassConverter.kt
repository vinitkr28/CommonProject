package vinit.module1.models

import android.util.Base64
import android.util.Log
import com.google.gson.JsonObject
import org.json.JSONObject
import vinit.module2_kotlin1.models.*

class DataClassConverter {
    companion object {

        fun prepareLightList(region: Int, listLightModel: List<LightModel>): List<Light> {
//        Log.d(TAG, "prepareLightList: ***************************")

            val lights = mutableListOf<Light>()
            listLightModel.forEach {
//            Log.d(TAG, "prepareLightList::forEach: $it")

                var clid: Long? = null
                if (!it.beaconId.isNullOrEmpty()) {
//                clid = Integer.parseInt(it.beaconId.trim(), 16)
//                clid = it.beaconId.toInt(16)
//                    clid = Long.decode(it.beaconId.trim())
                    clid = java.lang.Long.decode(it.beaconId.trim())
//                    Log.d("DataClassConverter", "beaconId: ${it.beaconId}, cLID: $clid")
                }

                lights.add(
                    Light(
                        region,
                        it.id,
                        it.customer_Id,
                        it.venue_Id,
                        it.floor_Id,
                        it.shortName,
                        it.description,
                        it.geoLocation.longitude,
                        it.geoLocation.latitude,
                        it.geoLocation.altitude,
                        0f,
                        0f,
                        it.beaconMountingHeight,
                        it.lightShape_Id,
                        it.orientationDegrees,
                        clid,
                        clid,
                        it.updatedDateTime,
                        false
                    )
                )
            }
//        Log.d(TAG, "prepareLightList: ###########################")
            return lights
        }

        fun prepareLightGsonForCloud(light: Light): JsonObject {

            /*+ (NSString *)numberToHexString:(NSNumber *)number {
                if (number) {
                    return [NSString stringWithFormat:@"0x%04x", [number unsignedIntValue]];

                }
                return @"";

            }*/

            //https://www.techiedelight.com/convert-int-to-a-hex-string-in-kotlin/#:~:text=A%20simple%20solution%20to%20convert,a%20hexadecimal%20value%20in%20uppercase.

            /*fun main() {
                val intValue = 1000
                val hex = intValue.toString(16)
                println(hex) // 3e8
                println(hex.toUpperCase()) // 3E8
            }*/

            /*fun main() {
                val intValue = 1000
                val hex = Integer.toHexString(intValue)
                println(hex) // 3e8
            }*/

            /*fun main() {
                val longValue = Long.MAX_VALUE
                val hex = longValue.toString(16)
                println(hex) // 7fffffffffffffff
            }*/

            /*fun main() {
                val longValue = Long.MAX_VALUE
                val hex = java.lang.Long.toHexString(longValue)
                println(hex) // 7fffffffffffffff
            }*/

            /*fun main() {
                val intValue = Int.MAX_VALUE
                val hex = String.format("%x", intValue)
                println(hex) // 7fffffff
            }*/

            /*fun main() {
                val intValue = Int.MAX_VALUE
                val hex = String.format("%X", intValue)
                println(hex) // 7FFFFFFF
            }*/

            /*fun main() {
                val longValue = Long.MAX_VALUE
                val hex = String.format("%#X", longValue)
                println(hex) // 0X7FFFFFFFFFFFFFFF
            }*/

            var cLidToHex = ""
            light.cLID?.let {
                cLidToHex = String.format("%#x", light.cLID)
            }
//            Log.d("DataClassConverter", "prepareLightGsonForCloud: cLidToHex $cLidToHex")

            val pixelLocation = JsonObject()
            pixelLocation.addProperty("x", light.pixelX)
            pixelLocation.addProperty("y", light.pixelY)

            val geoLocation = JsonObject()
            geoLocation.addProperty("altitude", light.altitude)
            geoLocation.addProperty("longitude", light.longitude)
            geoLocation.addProperty("latitude", light.latitude)

            val lightJson = JsonObject()
            lightJson.addProperty("id", light.id)
            lightJson.add("pixelLocation", pixelLocation)
            lightJson.addProperty("description", light.description ?: "")
            lightJson.addProperty("shortName", light.shortName)
            lightJson.add("geoLocation", geoLocation)
            lightJson.addProperty("beaconId", cLidToHex)
            lightJson.addProperty("venue_Id", light.venueID)
            lightJson.addProperty("orientationDegrees", light.orientationDegrees)
            lightJson.addProperty("floor_Id", light.floorID)
            lightJson.addProperty("updatedDateTime", light.lastModifiedTime)
            lightJson.addProperty("customer_Id", light.customerID)
            lightJson.addProperty("lightShape_Id", light.modelID)
            lightJson.addProperty("beaconMountingHeight", light.mountingHeight)

            Log.d("DataClassConverter", "prepareLightGsonForCloud: $lightJson")

            return lightJson
        }


        fun prepareBeaconGsonForCloud(beacon: Beacon): JSONObject {

            val pixelLocation = JSONObject()
            pixelLocation.put("x", beacon.pixelX)
            pixelLocation.put("y", beacon.pixelY)

            val geoLocation = JSONObject()
            geoLocation.put("altitude", beacon.pixelX)
            geoLocation.put("longitude", beacon.pixelX)
            geoLocation.put("latitude", beacon.pixelY)

            val beaconJson = JSONObject()
            beaconJson.put("id", beacon.id)
            beaconJson.put("beaconMountingHeight", beacon.mountingHeight)
            beaconJson.put("bleBeaconModel", beacon.modelID)
            beaconJson.put("firmwareRevision", beacon.firmwareRevision)
            beaconJson.put("updatedDateTime", beacon.lastModifiedTime)
            beaconJson.put("updatePending", beacon.updatePending)
            beaconJson.put("typeNumber", beacon.typeNumber)
            beaconJson.put("venue_Id", beacon.venueID)
            beaconJson.put("txPower", beacon.txPower)
            beaconJson.put("hardwareRevision", beacon.hardwareRevision)
            beaconJson.put("pixelLocation", pixelLocation)
            beaconJson.put("geoLocation", geoLocation)
            beaconJson.put("operationMode", beacon.operationMode)
            beaconJson.put("shortName", beacon.shortName)
            beaconJson.put("nativeBeaconPayload", beacon.nativePayload)
            beaconJson.put("onOff", beacon.onOff)
            beaconJson.put("floor_Id", beacon.floorID)
            beaconJson.put("customer_Id", beacon.customerID)
            beaconJson.put("description", beacon.description)
            beaconJson.put(
                "customBeacon1",
                prepareCustomBeaconJson(
                    beacon.customOneID!!,
                    beacon.customOneType!!,
                    beacon.customOneConfigManufacturerId!!,
                    beacon.customOneConfigUuid!!,
                    beacon.customOneConfigUuidType!!,
                    beacon.customOneConfigDataType!!,
                    beacon.customOnePayload!!
                )
            )
            beaconJson.put(
                "customBeacon2",
                prepareCustomBeaconJson(
                    beacon.customTwoID!!,
                    beacon.customTwoType!!,
                    beacon.customTwoConfigManufacturerId!!,
                    beacon.customTwoConfigUuid!!,
                    beacon.customTwoConfigUuidType!!,
                    beacon.customTwoConfigDataType!!,
                    beacon.customTwoPayload!!
                )
            )

            return beaconJson
        }


        private fun prepareCustomBeaconJson(
            customID: Int,
            customBeaconType: Int,
            customConfigManufacturingId: String,
            customConfigUuid: String,
            customConfigUuidType: Int,
            customConfigDataType: Int,
            customBeaconPayload: String
        ): JSONObject {
            val customBeaconJson = JSONObject()
            customBeaconJson.put("id", customID)
            customBeaconJson.put("beaconType", customBeaconType)
            customBeaconJson.put(
                "config",
                prepareCustomBeaconConfigJson(
                    customConfigManufacturingId,
                    customConfigUuid,
                    customConfigUuidType,
                    customConfigDataType
                )
            )
            customBeaconJson.put("beaconPayload", customBeaconPayload)

            return customBeaconJson
        }

        private fun prepareCustomBeaconConfigJson(
            customConfigManufacturingId: String,
            customConfigUuid: String,
            customConfigUuidType: Int,
            customConfigDataType: Int
        ): JSONObject {
            val customBeaconConfigJson = JSONObject()
            customBeaconConfigJson.put("dataType", customConfigDataType)
            customBeaconConfigJson.put("manufacturerId", customConfigManufacturingId)
            customBeaconConfigJson.put("uuidType", customConfigUuidType)
            customBeaconConfigJson.put("uuid", customConfigUuid)

            return customBeaconConfigJson
        }


        fun prepareFloor(
            workOrderFloorModel: WorkOrderFloorModel,
            regionId: Int,
            customerId: Int,
            customerName: String,
            venueId: Int,
            venueName: String,
            updateRing: Int,
            workOrderId: String
        ): Floor {
//            val region = requireArguments().getParcelable<Region>("selected_region")

//            Log.d("DataClassConverter", "prepareFloor: $workOrderFloorModel")

            var referencePointOneLongitude: Double? = null
            var referencePointOneLatitude: Double? = null
            var referencePointTwoLongitude: Double? = null
            var referencePointTwoLatitude: Double? = null
            var referencePointThreeLongitude: Double? = null
            var referencePointThreeLatitude: Double? = null

            workOrderFloorModel.referencePointOne?.let {
                referencePointOneLongitude = it.longitude
                referencePointOneLatitude = it.latitude
            }

            workOrderFloorModel.referencePointTwo?.let {
                referencePointTwoLongitude = it.longitude
                referencePointTwoLatitude = it.latitude
            }

            workOrderFloorModel.referencePointThree?.let {
                referencePointThreeLongitude = it.longitude
                referencePointThreeLatitude = it.latitude
            }

            return Floor(
                regionId,
                workOrderFloorModel.floorId,
                workOrderFloorModel.updatedDateTime,
//                requireArguments().getInt("customer_id"),
                customerId,
//                requireArguments().getString("customer_name", ""),
                customerName,
//                requireArguments().getInt("venue_id"),
                venueId,
//                requireArguments().getString("venue_name", ""),
                venueName,
                workOrderFloorModel.floorNumber,
                workOrderFloorModel.floorDescription,
                referencePointOneLongitude,
                referencePointOneLatitude,
                referencePointTwoLongitude,
                referencePointTwoLatitude,
                referencePointThreeLongitude,
                referencePointThreeLatitude,
//                requireArguments().getInt("update_ring"),
                updateRing,
//                requireArguments().getString("work_order_id", "")
                workOrderId
            )
        }
    }
}