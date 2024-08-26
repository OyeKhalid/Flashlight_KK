package com.example.flashlight

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.flashlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var isFlashlightOn = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]


        binding.flashlightButton.setOnClickListener {
            isFlashlightOn = !isFlashlightOn
            cameraManager.setTorchMode(cameraId, isFlashlightOn)
            updateButtonAppearance(isFlashlightOn)
        }


    }

    private fun updateButtonAppearance(isOn: Boolean) {
        if (isOn) {
            binding.flashlightButton.setImageResource(R.drawable.off)
        } else {
            binding.flashlightButton.setImageResource(R.drawable.on)
        }
    }
}