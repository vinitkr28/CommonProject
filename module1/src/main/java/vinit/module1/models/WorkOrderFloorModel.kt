package vinit.module2_kotlin1.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@SuppressWarnings("unused")
data class WorkOrderFloorModel(
    @SerializedName("id")
    @Expose
    val floorId: Int,

    @SerializedName("description")
    @Expose
    val floorDescription: String,

    @SerializedName("customer_Id")
    @Expose
    val customerId: Int,

    @SerializedName("createdAtDateTime")
    @Expose
    val createdAtDateTime: String,

    @SerializedName("updatedDateTime")
    @Expose
    val updatedDateTime: String,

    @SerializedName("referencePointOne")
    @Expose
    val referencePointOne: ReferencePoint? = null,

    @SerializedName("referencePointTwo")
    @Expose
    val referencePointTwo: ReferencePoint? = null,

    @SerializedName("referencePointThree")
    @Expose
    val referencePointThree: ReferencePoint? = null,

    @SerializedName("venue_Id")
    @Expose
    val venueId: Int,

    @SerializedName("floorNumber")
    @Expose
    val floorNumber: Int,

    var floorIsInDb: Boolean = false,

    var floorBelongsToWorkOrder: WorkOrderModel
)

data class ReferencePoint(
    @SerializedName("altitude")
    @Expose
    val altitude: String,

    @SerializedName("latitude")
    @Expose
    val latitude: Double,

    @SerializedName("longitude")
    @Expose
    val longitude: Double
)