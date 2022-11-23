package com.signify.indoor_navigation.site_enabler.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LicenseModel(
    @SerializedName("id")
    val LicenseId: String,
    /*@SerializedName("customer")
    val customer: CustomerModel,*/
    @SerializedName("customer_Id")
    val customerId: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("developerLicenseSettings")
    val developerLicenceSetting: DeveloperLicenceSetting,
    @SerializedName("disableLogging")
    val disableLogging: Boolean,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("licenseType")
    val licenseType: Int,
    @SerializedName("startDate")
    val startDate: String,
    /*@SerializedName("venues")
    val venues: List<VenueModel>,*/
    @SerializedName("developers")
    val developers: List<String>,
    @SerializedName("analysts")
    val analysts: List<String>
) : Parcelable

@Parcelize
data class DeveloperLicenceSetting(
    @SerializedName("checkLocation")
    val checkLocation: Boolean,
    @SerializedName("venueCacheTimeoutInSeconds")
    val venueCacheTimeoutInSeconds: Long
) : Parcelable


/*
data class Customer(
    val id:Int,
    val uuid:String,
    val description:String,
    val dataRetention:Long,
    val minimumAppIdCount:Int,
    val updateRing:Int,
    val remoteOperationService:Boolean,
    val enableGroup:Boolean
)
*/


/*{
    "id": "cc3e0ae5-3ddd-48cb-93b6-537dc52ed51f",
    "customer": {
    "id": 1,
    "uuid": "c90cf0fe-7f44-e811-80c3-000d3a21c059",
    "description": "Signify NL",
    "dataRetention": 3960,
    "minimumAppIdCount": 1,
    "updateRing": 2,
    "remoteOperationService": true,
    "enableGroup": true
},
    "customer_Id": 1,
    "description": "Adactive - Evaluation Kit Only",
    "developerLicenseSettings": {
    "checkLocation": false,
    "venueCacheTimeoutInSeconds": 1800
},
    "disableLogging": false,
    "endDate": "2099-10-31T23:59:59.999+00:00",
    "licenseType": 2,
    "services": [
    {
        "description": "Location Coded Light",
        "id": 1
    }
    ],
    "startDate": "2016-05-15T00:00:00+00:00",
    "venues": [
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
    ],
    "developers": [],
    "analysts": []
}*/
