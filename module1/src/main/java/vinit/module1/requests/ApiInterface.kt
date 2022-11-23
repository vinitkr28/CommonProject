package vinit.module1.requests

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    // Fetch work order
    //BASE URL: BASE_URL_EU_DEVELOPMENT-> https://api.dev.eu.vef.retail.interact-lighting.com/api/
    //https://api.dev.eu.vef.retail.interact-lighting.com/api/workorders/?include=customer,venue
    @GET("workorders/?include=customer,venue")
    fun makeWorkOrdersQuery(@Header("Authorization") token: String): Call<List<String>>

    //    https://api.dev.eu.vef.retail.interact-lighting.com/api/workorders/3fda3bc3-4386-43dc-b669-fd7878b1f618
    @GET("workorders/{workorderID}")
    fun makeWorkOrderQueryById(
        @Header("Authorization") token: String,
        @Path("workorderID")
        workorderID: String
    ): Call<String>

    //https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/floors
    @GET("customers/{customers}/venues/{venues}/floors")
    fun makeWorkOrderFloorsQuery(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: String,
        @Path("venues")
        venues: String
    ): Call<List<String>>

    //https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/floors/55
    @GET("customers/{customers}/venues/{venues}/floors/{floor}")
    fun makeWorkOrderFloorQueryById(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int,
        @Path("floor")
        floor: Int
    ): Call<String>

    //    https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/floors/55/layouts/
    @GET("customers/{customers}/venues/{venues}/floors/{floors}/layouts")
    suspend fun makeWorkOrderFloorLayoutsQuery(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int,
        @Path("floors")
        floors: Int
    ): Response<List<String>>

    //    https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/floors/55/layouts/29/
    @GET("customers/{customers}/venues/{venues}/floors/{floors}/layouts/{layout}")
    suspend fun makeWorkOrderFloorLayoutImageQuery(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int,
        @Path("floors")
        floors: Int,
        @Path("layout")
        layout: Int
    ): Response<String>

    //    https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/floors/55/lights
    @GET("customers/{customers}/venues/{venues}/floors/{floors}/lights")
    suspend fun makeWorkOrderFloorLightsQuery(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int,
        @Path("floors")
        floors: Int
    ): Response<List<String>>

    @GET("customers/{customers}/venues/{venues}/floors/{floors}/blebeacons")
    suspend fun makeWorkOrderFloorBeaconsQuery(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int,
        @Path("floors")
        floors: Int
    ): Response<List<String>>

    //    https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/floors/55/blenextgenbeacons/deviceproperties/[beacon.identifier]
    @PUT("customers/{customers}/venues/{venues}/floors/{floors}/blenextgenbeacons/deviceproperties/{beacon}")
    fun updateBeaconDataToCloud(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int,
        @Path("floors")
        floors: Int,
        @Path("beacon")
        beacon: Int,
        @Body
        body: JSONObject
    ): Call<ResponseBody>


    // https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/floors/55/lights/[light.identifier]
    //https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/floors/55/lights/9876
    @PUT("customers/{customers}/venues/{venues}/floors/{floors}/lights/{lights}")
    fun updateLightDataToCloud(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int,
        @Path("floors")
        floors: Int,
        @Path("lights")
        beacon: Int,
        @Body
        body: JsonObject
    ): Call<ResponseBody>

    @PATCH("workorders/{workorderID}/open")
    fun makeWorkOrderOpenRequest(
        @Header("Authorization") token: String
    ): Call<String>

    @GET("customers/{customers}/venues/{venues}/venuepromotiondifferencestodraft")
    fun makeVenuePromotionDifferencesToDraft(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int
    ): Call<JsonElement>

    @POST("customers/{customers}/venues/{venues}/venuepromotionstodraft")
    fun makeStartVenuePromotionToDraft(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int
    ): Call<ResponseBody>

    //https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/licenses?devLicensesOnly=false
    @GET("customers/{customers}/venues/{venues}/licenses?devLicensesOnly=false")
    fun makeRequestForLicenses(
        @Header("Authorization") token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int
    ): Call<List<String>>

    /*
    Example:-
    https://api.dev.eu.vef.retail.interact-lighting.com/api/customers/1/venues/55/ipmfiles/sasfordownload?licenseid=f372fc05-f83e-4733-9e1f-5207c69367d8&ispreproduction=true
    Body-> { "floorsAndLayouts" : { "55" : "29"}}
    */
    @POST("customers/{customers}/venues/{venues}/ipmfiles/sasfordownload")
    fun makeRequestForIpmUrl(
        @Header("Authorization")
        token: String,
        @Path("customers")
        customers: Int,
        @Path("venues")
        venues: Int,
        @Query("licenseid")
        licenceId: String,
        @Query("ispreproduction")
        isPreProduction: Boolean,
        @Body
        body: JsonObject
    ): Call<String>
}
