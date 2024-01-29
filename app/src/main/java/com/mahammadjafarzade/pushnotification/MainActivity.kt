package com.mahammadjafarzade.pushnotification

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        askNotificationPermission()
    }
    val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ granted ->
        if(granted){
            getToken()
        }else{

        }

    }

    fun askNotificationPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
    fun getToken(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener({task ->
            if(task.isSuccessful){
                println(task.result)
            }
        })
    }
}
//fGZTCFvLRRSTAkMIYKfHWC:APA91bGpEHXlLsj7XKQ0y06x_oKH709lgME50uOEXKt0K-oS9Nlx2mS7PuWrieR48P7vchySO0b8f0GMzXI08uKAU9rG_IYc6a1LVp7Y2tr1j2s7V-C5bMiDTppZ-CHAktae2Tln3toa