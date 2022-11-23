package vinit.module2_kotlin1.models

data class BeaconModel(val bleBeaconDto: BeaconDto)

data class BeaconDto(
    val id: Int,
    val customer_Id: Int,
    val venue_Id: Int,
    val floor_Id: Int,
    val shortName: String,
    val description: String,
    val beaconMountingHeight: Double,
    val nativeBeaconPayload: String,
    val bleBeaconModel: Int,
    val typeNumber: String,
    val firmwareRevision: String,
    val hardwareRevision: String,
    val operationMode: Int,
    val txPower: Int,
    val onOff: Boolean,
    val customBeacon1: CustomBeacon,
    val customBeacon2: CustomBeacon,
    val updatePending: Boolean,
    val updatedDateTime: String
)


data class CustomBeacon(
    val id: Int,
    val beaconType: Int,
    val config: CustomBeaconConfig,
    val beaconPayload: String

)

data class CustomBeaconConfig(
    val dataType: Int,
    val manufacturerId: String,
    val uuidType: Int,
    val uuid: String
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


/*
{
    "bleBeaconDto": {
    "nativeBeaconPayload": null,
    "typeNumber": null,
    "firmwareRevision": null,
    "hardwareRevision": null,
    "operationMode": 4,
    "txPower": 0,
    "onOff": true,
    "customBeacon1": {
        "id": 36,
        "beaconType": 2,
        "config": {
        "dataType": 255,
        "manufacturerId": "AEw=",
        "uuidType": 0,
        "uuid": "AAA="
    },
        "beaconPayload": "AhX+8AzJRH8R6IDDAA06IcBZADcAAc4="
    },
    "customBeacon2": {
        "id": 35,
        "beaconType": 1,
        "config": {
        "dataType": 255,
        "manufacturerId": "/v4=",
        "uuidType": 234,
        "uuid": "6uo="
    },
        "beaconPayload": "EjRWeJCrze8SNFZ4kKvN7xI0VniQq80="
    },
    "updatePending": true,
    "id": 159,
    "updatedDateTime": "2021-11-18T11:13:54.4778668+00:00",
    "beaconMountingHeight": 0,
    "customer_Id": 1,
    "description": "asdasd",
    "bleBeaconModel": 5,
    "floor_Id": 55,
    "geoLocation": {
        "altitude": 0,
        "latitude": 31.166851038851465,
        "longitude": 121.39481637608475
    },
    "shortName": "0-btle-0",
    "venue_Id": 55
}
}*/
