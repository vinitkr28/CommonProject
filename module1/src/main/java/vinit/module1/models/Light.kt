package vinit.module1.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import org.jetbrains.annotations.NotNull

@Parcelize
@Entity(tableName = "light_table", primaryKeys = ["RegionID", "ID"])
data class Light(

    @NonNull
    @ColumnInfo(name = "RegionID")
    val regionId: Int,

    @NonNull
    @ColumnInfo(name = "ID")
    val id: Int,

    @NonNull
    @ColumnInfo(name = "CustomerID")
    val customerID: Int,

    @NotNull
    @ColumnInfo(name = "VenueID")
    val venueID: Int,

    @NotNull
    @ColumnInfo(name = "FloorID")
    val floorID: Int,

    @NotNull
    @ColumnInfo(name = "ShortName")
    val shortName: String,

    @ColumnInfo(name = "Description")
    val description: String? = null,

    @ColumnInfo(name = "Longitude")
    val longitude: Double? = null,

    @NotNull
    @ColumnInfo(name = "Latitude")
    val latitude: Double? = null,

    @ColumnInfo(name = "Altitude")
    val altitude: Double? = null,

    @ColumnInfo(name = "pixelX")
    var pixelX: Float? = null,

    @ColumnInfo(name = "pixelY")
    var pixelY: Float? = null,

    @ColumnInfo(name = "MountingHeight")
    val mountingHeight: Double? = null,

    @ColumnInfo(name = "ModelID")
    val modelID: Int? = null,

    @ColumnInfo(name = "OrientationDegrees")
    val orientationDegrees: Double? = null,

    @ColumnInfo(name = "CLID")
    var cLID: Long? = null,

    @NotNull
    @ColumnInfo(name = "OriginalCLID")
    var originalCLID: Long? = null,

    @NotNull
    @ColumnInfo(name = "LastModifiedTime")
    val lastModifiedTime: String? = null,

    @NotNull
    @ColumnInfo(name = "IsModified")
    var isModified: Boolean = false
) : Parcelable {
    @Ignore
    @IgnoredOnParcel
    var annotationId: Int = 0
}

/*CREATE TABLE light_table (
RegionID INTEGER NOT NULL,
ID INTEGER NOT NULL,
CustomerID INTEGER NOT NULL,
VenueID INTEGER NOT NULL,
FloorID INTEGER NOT NULL,
ShortName TEXT NOT NULL,
Description TEXT,
Longitude DOUBLE,
Latitude DOUBLE,
Altitude DOUBLE,
pixelX INTEGER,
pixelY INTEGER,
MountingHeight DOUBLE,
ModelID INTEGER,
OrientationDegrees DOUBLE,
CLID INTEGER,
OriginalCLID INTEGER,
LastModifiedTime TEXT,
IsModified BOOL,
PRIMARY KEY (RegionID, ID))
*/
