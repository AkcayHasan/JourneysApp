package com.example.busjourneysapp.util

import android.content.Context
import com.example.busjourneysapp.R

class CustomSharedPref(context: Context) {

    private val sharedPref =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val SESSION_ID = "session_id"
        const val DEVICE_ID = "device_id"
    }

    fun saveSessionId(sessionId: String) {
        val editor = sharedPref.edit()
        editor.putString(SESSION_ID, sessionId)
        editor.apply()
    }

    fun saveDeviceId(deviceId: String) {
        val editor = sharedPref.edit()
        editor.putString(DEVICE_ID, deviceId)
        editor.apply()
    }

    fun fetchSessionId(): String? {
        return sharedPref.getString(SESSION_ID, null)
    }

    fun fetchDeviceId(): String? {
        return sharedPref.getString(DEVICE_ID, null)
    }

    fun deleteIds() {
        val editor = sharedPref.edit()
        editor.remove(SESSION_ID)
        editor.remove(DEVICE_ID)
        editor.apply()
    }


}