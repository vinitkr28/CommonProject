package vinit.module1.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class VenueModel(
    @SerializedName("id")
    val venueId: Int,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("timeZoneIdentifier")
    val timeZoneIdentifier: String,
    @SerializedName("address_Line_1")
    val addressLine1: String,
    @SerializedName("address_Line_2")
    val addressLine2: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("state_Province_Region")
    val stateProvinceRegion: String,
    @SerializedName("zip_PostalCode")
    val zipPostalCode: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("contactPerson")
    val contactPerson: String,
    @SerializedName("customer_Id")
    val customerId: Int,
    @SerializedName("description")
    val description: String,
    /*@SerializedName("gpsLocation")
    val gpsLocation: LocationModel,*/
    @SerializedName("format_Id")
    val formatId: Int,
    @SerializedName("updateRing")
    val updateRing: Int,
    @SerializedName("dynaliteSiteId")
    val dynaliteSiteId: String,
    @SerializedName("isInternal")
    val isInternal: Boolean,
    @SerializedName("isIaoSite")
    val isIaoSite: Boolean,
    @SerializedName("groupId")
    val groupId: Int
) : Parcelable

/*
API response example:-
{
    "id": 55,
    "uuid": "1d0b5af6-2f69-4e71-8937-79719f9b0443",
    "timeZoneIdentifier": null,
    "address_Line_1": "High Tech Campus 48",
    "address_Line_2": null,
    "city": "Eindhoven",
    "state_Province_Region": "Noord-Brabant",
    "zip_PostalCode": "5656 AE",
    "country": "NL",
    "contactPerson": "Onno Janssen",
    "customer_Id": 1,
    "description": "Evaluation Kit",
    "gpsLocation": {
    "alt": 18,
    "lat": 51.4122138999903,
    "lon": 5.46134091390845
},
    "format_Id": 2,
    "updateRing": 1,
    "dynaliteSiteId": "93c5d3e0-c4a8-40f4-a31b-08461ba5679f",
    "isInternal": false,
    "isIaoSite": false,
    "groupId": 0
}
*/
