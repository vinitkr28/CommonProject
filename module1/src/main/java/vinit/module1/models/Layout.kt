package vinit.module1.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import org.jetbrains.annotations.NotNull

@Entity(tableName = "layout_table", primaryKeys = ["RegionID", "ID"])
data class Layout(
    @NonNull
    @ColumnInfo(name = "RegionID")
    var regionId: Int,

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

    @ColumnInfo(name = "Reference1X")
    val reference1X: Float? = null,

    @ColumnInfo(name = "Reference1Y")
    val reference1Y: Float? = null,

    @ColumnInfo(name = "Reference2X")
    val reference2X: Float? = null,

    @ColumnInfo(name = "Reference2Y")
    val reference2Y: Float? = null,

    @ColumnInfo(name = "Reference3X")
    val reference3X: Float? = null,

    @ColumnInfo(name = "Reference3Y")
    val reference3Y: Float? = null,

    @ColumnInfo(name = "Layout", typeAffinity = ColumnInfo.BLOB)
    val layout: ByteArray? = null
) /*{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Layout

        if (layout != null) {
            if (other.layout == null) return false
            if (!layout.contentEquals(other.layout)) return false
        } else if (other.layout != null) return false

        return true
    }

    override fun hashCode(): Int {
        return layout?.contentHashCode() ?: 0
    }
}*/

/*CREATE TABLE layout_table (
RegionID INTEGER NOT NULL,
ID INTEGER NOT NULL,

CustomerID INTEGER NOT NULL,
VenueID INTEGER NOT NULL,
FloorID INTEGER NOT NULL,

Reference1X INTEGER,
Reference1Y INTEGER,
Reference2X INTEGER,
Reference2Y INTEGER,
Reference3X INTEGER,
Reference3Y INTEGER,
Layout BLOB,
PRIMARY KEY (RegionID, ID))
*/


/*
CREATE TABLE layout_table
(RegionID INTEGER NOT NULL,
ID INTEGER NOT NULL,
CustomerID INTEGER NOT NULL,
VenueID INTEGER NOT NULL,
FloorID INTEGER NOT NULL,
Reference1X INTEGER,
Reference1Y INTEGER,
Reference2X INTEGER,
Reference2Y INTEGER,
Reference3X INTEGER,
Reference3Y INTEGER,
Layout BLOB,
PRIMARY KEY (RegionID, ID))
*/

/*CREATE TABLE `layout_table`
(`RegionID` INTEGER NOT NULL,
`ID` INTEGER NOT NULL,
`CustomerID` INTEGER NOT NULL,
`VenueID` INTEGER NOT NULL,
`FloorID` INTEGER NOT NULL,
`Reference1X` INTEGER,
`Reference1Y` INTEGER,
`Reference2X` INTEGER,
`Reference2Y` INTEGER,
`Reference3X` INTEGER,
`Reference3Y` INTEGER,
`Layout` BLOB,
PRIMARY KEY(`RegionID`, `ID`))*/
