package com.outsystems.plugins.osbackgroundtask

import android.util.Log
import com.outsystems.plugins.oscordova.CordovaImplementation
import org.apache.cordova.CallbackContext
import org.apache.cordova.CordovaPlugin
import org.json.JSONArray
import org.json.JSONException

/**
 * This class echoes a string called from JavaScript.
 */
class OSBackgroundTask : CordovaImplementation() {
    override var callbackContext: CallbackContext? = null

    override fun areGooglePlayServicesAvailable(): Boolean {
        return true
    }

    override fun onRequestPermissionResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {

    }

    @Throws(JSONException::class)
    override fun execute(
        action: String,
        args: JSONArray,
        callbackContext: CallbackContext
    ): Boolean {
        Log.d(OSBackgroundTask::class.java.simpleName, "execute OSBackgroundTask Tico")
        this.callbackContext = callbackContext
        if (action == "coolMethod") {
            val message = args.getString(0)
            coolMethod(message, callbackContext)
            return true
        }
        return false
    }


    private fun coolMethod(message: String?, callbackContext: CallbackContext) {
        if (message != null && message.length > 0) {
            callbackContext.success(message)
        } else {
            callbackContext.error("Expected one non-empty string argument.")
        }
    }
}