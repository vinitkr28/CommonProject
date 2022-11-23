package vinit.module1.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomerModel(
    @SerializedName("id")
    val customerId: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("dataRetention")
    val dataRetention: Long,
    @SerializedName("minimumAppIdCount")
    val minimumAppIdCount: Int,
    @SerializedName("updateRing")
    val updateRing: Int,
    @SerializedName("remoteOperationService")
    val remoteOperationService: Boolean,
    @SerializedName("enableGroup")
    val enableGroup: Boolean
) : Parcelable
