package com.maku.testapp.db

import android.location.Location
import androidx.room.TypeConverter
import com.google.gson.Gson

class LocationConverter {
    @TypeConverter
    fun toLocation(locationString: String?): Location? {
        return try {
            Gson().fromJson(locationString, Location::class.java)
        } catch (e: Exception) {
            null
        }
    }

    @TypeConverter
    fun toLocationString(location: Location?): String? {
        return Gson().toJson(location)
    }
}