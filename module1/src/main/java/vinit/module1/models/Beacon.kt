package vinit.module1.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import org.jetbrains.annotations.NotNull

@Entity(tableName = "bluetooth_beacon_table", primaryKeys = ["RegionID", "ID"])
data class Beacon(
    @ColumnInfo(name = "RegionID")
    val regionId: Int,

    @ColumnInfo(name = "ID")
    val id: Int,

    @ColumnInfo(name = "CustomerID")
    val customerID: Int,

    @ColumnInfo(name = "VenueID")
    val venueID: Int,

    @ColumnInfo(name = "FloorID")
    val floorID: Int,

    @ColumnInfo(name = "ShortName")
    val shortName: String,

    @ColumnInfo(name = "Description")
    val description: String? = null,

    @ColumnInfo(name = "Longitude")
    val longitude: Double? = null,

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

    @ColumnInfo(name = "NativePayload")
    var nativePayload: String? = null,

    @ColumnInfo(name = "ModelID")
    var modelID: Int? = null,

    @ColumnInfo(name = "TypeNumber")
    var typeNumber: String? = null,

    @ColumnInfo(name = "FirmwareRevision")
    var firmwareRevision: String? = null,

    @ColumnInfo(name = "HardwareRevision")
    var hardwareRevision: String? = null,

    @ColumnInfo(name = "OperationMode")
    val operationMode: Int? = null,

    @ColumnInfo(name = "TxPower")
    val txPower: Int? = null,

    @ColumnInfo(name = "OnOff")
    val onOff: Boolean? = null,

    @ColumnInfo(name = "CustomOneID")
    val customOneID: Int? = null,

    @ColumnInfo(name = "CustomOneType")
    val customOneType: Int? = null,

    @ColumnInfo(name = "CustomOneConfigDataType")
    val customOneConfigDataType: Int? = null,

    @ColumnInfo(name = "CustomOneConfigManufacturerId")
    val customOneConfigManufacturerId: String? = null,

    @ColumnInfo(name = "CustomOneConfigUuidType")
    val customOneConfigUuidType: Int? = null,

    @ColumnInfo(name = "CustomOneConfigUuid")
    val customOneConfigUuid: String? = null,

    @ColumnInfo(name = "CustomOnePayload")
    val customOnePayload: String? = null,

    @ColumnInfo(name = "CustomTwoID")
    val customTwoID: Int? = null,

    @ColumnInfo(name = "CustomTwoType")
    val customTwoType: Int? = null,

    @ColumnInfo(name = "CustomTwoConfigDataType")
    val customTwoConfigDataType: Int? = null,

    @ColumnInfo(name = "CustomTwoConfigManufacturerId")
    val customTwoConfigManufacturerId: String? = null,

    @ColumnInfo(name = "CustomTwoConfigUuidType")
    val customTwoConfigUuidType: Int? = null,

    @ColumnInfo(name = "CustomTwoConfigUuid")
    val customTwoConfigUuid: String? = null,

    @ColumnInfo(name = "CustomTwoPayload")
    val customTwoPayload: String? = null,

    @ColumnInfo(name = "UpdatePending")
    var updatePending: Boolean? = null,

    @ColumnInfo(name = "LastModifiedTime")
    val lastModifiedTime: String? = null,

    @ColumnInfo(name = "IsModified")
    var isModified: Boolean = false,

    @ColumnInfo(name = "OriginalNativePayload")
    val originalNativePayload: String? = null,

    @ColumnInfo(name = "OriginalTypeNumber")
    val originalTypeNumber: String? = null,

    @ColumnInfo(name = "OriginalFirmwareRevision")
    val originalFirmwareRevision: String? = null,

    @ColumnInfo(name = "OriginalHardwareRevision")
    val originalHardwareRevision: String? = null,

    @ColumnInfo(name = "OriginalUpdatePending")
    val originalUpdatePending: Boolean? = null
)

/*
CREATE TABLE bluetooth_beacon_table (
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
NativePayload TEXT,
ModelID INTEGER,
TypeNumber TEXT,
FirmwareRevision TEXT,
HardwareRevision TEXT,
OperationMode INTEGER,
TxPower INTEGER,
OnOff BOOL,
CustomOneID INTEGER,
CustomOneType INTEGER,
CustomOneConfigDataType INTEGER,
CustomOneConfigManufacturerId TEXT,
CustomOneConfigUuidType INTEGER,
CustomOneConfigUuid TEXT,
CustomOnePayload TEXT,
CustomTwoID INTEGER,
CustomTwoType INTEGER,
CustomTwoConfigDataType INTEGER,
CustomTwoConfigManufacturerId TEXT,
CustomTwoConfigUuidType INTEGER,
CustomTwoConfigUuid TEXT,
CustomTwoPayload TEXT,
UpdatePending BOOL,
LastModifiedTime TEXT,
IsModified BOOL,
OriginalNativePayload TEXT,
OriginalTypeNumber TEXT,
OriginalFirmwareRevision TEXT,
OriginalHardwareRevision TEXT,
OriginalUpdatePending BOOL,
PRIMARY KEY (RegionID, ID)
)
*/
