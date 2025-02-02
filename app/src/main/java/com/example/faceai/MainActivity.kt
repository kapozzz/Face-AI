package com.example.faceai

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.core.content.ContextCompat
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.example.faceai.features.camera.CameraScreen
import com.example.faceai.features.permissions.PermissionsScreen
import com.example.faceai.features.permissions.PermissionsScreen.Companion.REQUIRED_PERMISSIONS
import com.kapozzz.ui.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val hasPermissions = allPermissionsGranted(this@MainActivity)
                val screen: Screen = if (false) {
                    CameraScreen()
                } else {
                    PermissionsScreen()
                }
                Navigator(screen)
            }
        }
    }

    private fun allPermissionsGranted(context: Context) =
        REQUIRED_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }

}