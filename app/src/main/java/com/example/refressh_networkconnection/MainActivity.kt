package com.example.refressh_networkconnection

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.refressh_networkconnection.utils.NetworkUtil
import kotlinx.android.synthetic.main.activity_main.*
import leakcanary.AppWatcher
import leakcanary.ObjectWatcher

class MainActivity : AppCompatActivity() {

    // Use the 'by viewModels()' Kotlin property delegate
    // from the activity-ktx artifact
    //  private val model: NameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objectWatcher: ObjectWatcher = AppWatcher.objectWatcher
        
        NetworkUtil.getNetworkLiveData(applicationContext)
            .observe(this, androidx.lifecycle.Observer { t ->


                if (t.toString() == "true") {

                    network_background.setBackgroundColor(Color.GREEN);
                    Toast.makeText(applicationContext, "Connected", Toast.LENGTH_SHORT).show()
                } else {
                    network_background.setBackgroundColor(Color.RED);
                    Toast.makeText(applicationContext, "Not Connected", Toast.LENGTH_SHORT).show()
                }
            })

    }

}
