package vinit.module2_kotlin1.models

data class LightModel(
    val id: Int,
    val customer_Id: Int,
    val description: String,
    val floor_Id: Int,
    val venue_Id: Int,
    val lightShape_Id: Int,
    val orientationDegrees: Double,
    val shortName: String,
    val updatedDateTime: String,
    val beaconMountingHeight: Double,
    val beaconId: String,
    val geoLocation: GeoLocation
)

data class GeoLocation(
    val altitude: Double,
    val latitude: Double,
    val longitude: Double
)


/*
data class LayoutModel(
    val id: Int,
    val customer_Id: Int,
    val description: String,
    val floor_Id: Int,
    val venue_Id: Int,
    val pixelReference1: PixelReference,
    val pixelReference2: PixelReference,
    val pixelReference3: PixelReference,
    val fileDataBase64: String? = null
)

data class PixelReference(val x: Int, val y: Int)
*/


