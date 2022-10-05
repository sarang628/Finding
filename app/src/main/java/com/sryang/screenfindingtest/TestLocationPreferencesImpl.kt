package com.sryang.screenfindingtest

import android.content.Context
import android.content.SharedPreferences
import com.sryang.torang_core.data.LocationPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestLocationPreferencesImpl @Inject constructor(@ApplicationContext val context: Context) :
    LocationPreferences {
    override suspend fun isFirstRequestLocationPermission(): Boolean {
        //val b = getPref().getBoolean("isFirstRequestLocationPermission", true)
        return true
    }

    override fun requestLocationPermission() {
        /*getPref().edit()
            .putBoolean("isFirstRequestLocationPermission", false)
            .commit()*/
    }

    fun getPref(): SharedPreferences {
        return context.getSharedPreferences("torang", Context.MODE_PRIVATE)
    }
}