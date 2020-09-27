package com.maku.testapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "word_table")
class Locationstuff(
    @ColumnInfo(name = "latitude")
    var latitude: Double,
    @ColumnInfo(name = "longitude")
    var longitude: Double,
){
    fun Locationstuff() {}


    @field: PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

//class Location {
//    var latitude: Double = 0.0
//    var longitude: Double = 0.0
//}

class Location {
    var latitude = 0.0
    var longitude = 0.0
    var speed = 0.0
    override fun toString(): String {
        return "lat:$latitude- lng:$longitude- speed:$speed"
    }
}
//
//fun Locationstuff.text(): String{
//    val x = sessionLocation.toString()
//    return x
//}


