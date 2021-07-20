package com.paint.bindingtoolbarfragment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.paint.bindingtoolbarfragment.databinding.ActivityMainBinding

//Docs: https://developer.android.com/guide/playcore/in-app-updates/kotlin-java

//Auto update
//implementation 'com.google.android.play:core:1.10.0'

const val UPDATE_REQUEST_CODE = 8
private const val TAG = "UpdateManager"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = "Test"
        binding.buttonInContainer.text = "In container"
        binding.layout.buttonInLayout.setOnClickListener {
            val intent = Intent(this, WithFragmentActivity::class.java)
            startActivity(intent)
        }

        checkForUpdate(activity = this)
    }

    private fun checkForUpdate(activity: Activity) {
        Log.d(TAG, "checkForUpdate")
        val appUpdateManager = AppUpdateManagerFactory.create(activity.applicationContext)
        appUpdateManager.appUpdateInfo.addOnSuccessListener { appUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            ) {
                appUpdateManager.startUpdateFlowForResult(
                    appUpdateInfo,
                    AppUpdateType.IMMEDIATE,
                    activity,
                    UPDATE_REQUEST_CODE)
            }
        }
    }
}