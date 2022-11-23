package vinit.module2_kotlin1.models

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

data class PixelReference(val x: Float, val y: Float)
