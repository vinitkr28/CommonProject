package vinit.module1.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import vinit.module1.BuildConfig

@Parcelize
data class Region (
    val id: RegionType,
    val regionDesc: String?,
    val clientId: String?,
    val apiUrl: String?,
    val scopes: Array<String>
) : Parcelable

object RegionList{
    fun getAllRegion(): List<Region> {
        val regions = mutableListOf<Region>()

        regions += Region(
            RegionType.EU_PRODUCTION,
            "Global",
            "3e3efc6b-c89c-4218-b9ac-a3dfdf39d3e0",
            BuildConfig.BASE_URL_EU_PRODUCTION,
            arrayOf("api://ddb7939c-f797-4563-bc5c-8862db93d687/user_impersonation")
        )

        regions += Region(
            RegionType.US_PRODUCTION,
            "Americas",
            "fdca53c6-6092-4836-8c53-4ff618c178ac",
            BuildConfig.BASE_URL_US_PRODUCTION,
            arrayOf("api://d250518d-e8ac-4f60-af2c-8ba5fc5fdee3/user_impersonation")
        )

        regions += Region(
            RegionType.CN_PRODUCTION,
            "China",
            "142fa458-9674-4424-aaf4-434031bf75d1",
            BuildConfig.BASE_URL_CN_PRODUCTION,
            arrayOf("api://4b22c46a-e57e-463e-a89a-fe5876edaf40/user_impersonation")
        )

        regions += Region(
            RegionType.EU_STAGING,
            "Global.Staging",
            "9780d9f4-d2bd-47f9-993f-676e7c5f4cde",
            BuildConfig.BASE_URL_EU_STAGING,
            arrayOf("api://026fc673-fd1d-43ce-8462-f3d79bfaab75/user_impersonation")
        )

        regions += Region(
            RegionType.CN_STAGING,
            "China.Staging",
            "7f412230-0246-47c6-83a4-b329c44bc510",
            BuildConfig.BASE_URL_CN_STAGING,
            arrayOf("api://2c51f67d-1329-4b93-bd87-578edaa9cf65/user_impersonation")
        )

        regions += Region(
            RegionType.EU_DEVELOPMENT,
            "Global.Development",
            "e39d91c3-9437-434f-b80a-f84438a35b5d",
            BuildConfig.BASE_URL_EU_DEVELOPMENT,
            arrayOf("api://7617065a-eaf8-48ad-9c8b-a0167160657e/user_impersonation")
        )

        return regions
    }
}

enum class RegionType(val id: Int) {
    EU_DEVELOPMENT(6),
    CN_STAGING(5),
    EU_STAGING(4),
    CN_PRODUCTION(3),
    US_PRODUCTION(2),
    EU_PRODUCTION(1);

    companion object : EnumCompanion<Int, RegionType>(RegionType.values().associateBy(RegionType::id))

}

open class EnumCompanion<T, V>(private val valueMap: Map<T, V>) {
    fun fromInt(type: T) = valueMap[type]
}


