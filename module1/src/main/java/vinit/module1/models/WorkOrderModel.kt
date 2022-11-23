package vinit.module2_kotlin1.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import vinit.module1.models.CustomerModel


data class WorkOrderModel(
    @SerializedName("id")
    val workOrderId: String,
    @SerializedName("description")
    val workOrderDescription: String,
    @SerializedName("customer")
    val customer: CustomerModel,
    @SerializedName("venue")
    val venue: Venue,
    @SerializedName("typeFlags")
    val typeFlags: Int,
    @SerializedName("status")
    val status: Int,
    @SerializedName("serviceType")
    val serviceType: Int,
    @SerializedName("updated")
    val updated: Updated
)

data class Venue(
    @SerializedName("id")
    val venueId: Int,
    @SerializedName("description")
    var venueDescription: String,
    @SerializedName("updateRing")
    val updateRing: Int = 0

)

data class Updated(
    @SerializedName("at")
    val updatedAt: String,
    @SerializedName("by")
    val updatedby: JsonObject
)