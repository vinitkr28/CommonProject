package vinit.module1.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import org.jetbrains.annotations.NotNull

@Parcelize
@Entity(tableName = "floor_table", primaryKeys = ["RegionID", "ID"])
data class Floor(
    @NonNull
    @ColumnInfo(name = "RegionID")
    var regionId: Int,

    @NonNull
    @ColumnInfo(name = "ID")
    var id: Int,

    @ColumnInfo(name = "LastModifiedTime")
    var lastModifiedTime: String? = null,

    @NotNull
    @ColumnInfo(name = "CustomerID")
    var customerID: Int,

    @NotNull
    @ColumnInfo(name = "CustomerName")
    val customerName: String,

    @NotNull
    @ColumnInfo(name = "VenueID")
    var venueID: Int,

    @NotNull
    @ColumnInfo(name = "VenueName")
    val venueName: String,

    @ColumnInfo(name = "FloorNumber")
    var floorNumber: Int,

    @NotNull
    @ColumnInfo(name = "Info")
    var info: String,

    @ColumnInfo(name = "Reference1Latitude")
    var reference1Latitude: Double? = null,

    @ColumnInfo(name = "Reference1Longitude")
    var reference1Longitude: Double? = null,

    @ColumnInfo(name = "Reference2Latitude")
    var reference2Latitude: Double? = null,

    @ColumnInfo(name = "Reference2Longitude")
    var reference2Longitude: Double? = null,

    @ColumnInfo(name = "Reference3Latitude")
    var reference3Latitude: Double? = null,

    @ColumnInfo(name = "Reference3Longitude")
    var reference3Longitude: Double? = null,

    @ColumnInfo(name = "UpdateRing")
    val updateRing: Int,

    @NotNull
    @ColumnInfo(name = "WorkOrderId")
    val workOrderId: String


) : Parcelable

/*
This query is copied from .db file received from existing iOS app

CREATE TABLE floor_table (
RegionID INTEGER NOT NULL,
ID INTEGER NOT NULL,
LastModifiedTime TEXT,
CustomerID INTEGER NOT NULL,
CustomerName TEXT NOT NULL,
VenueID INTEGER NOT NULL,
VenueName TEXT NOT NULL,
FloorNumber INTEGER,
Info TEXT NOT NULL,
Reference1Longitude DOUBLE,
Reference1Latitude DOUBLE,
Reference2Longitude DOUBLE,
Reference2Latitude DOUBLE,
Reference3Longitude DOUBLE,
Reference3Latitude DOUBLE,
UpdateRing INTEGER,
WorkOrderId TEXT NOT NULL,
PRIMARY KEY (RegionID, ID)
)
 */