package com.example.faceai.features.permissions

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.faceai.features.camera.CameraScreen
import com.example.faceai.features.permissions.components.NeedPermissionsItem
import com.kapozzz.ui.AppTheme
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

class PermissionsScreen: Screen {

    @Composable
    override fun Content() {
        val viewModel = getViewModel<PermissionsViewModel>()
        val navigator = LocalNavigator.currentOrThrow
        SubscribeOnEffects(viewModel.effect, navigator)
        Screen(viewModel.currentState, viewModel::setEvent)
    }

    @Composable
    private fun SubscribeOnEffects(effects: SharedFlow<PermissionsEffect>, navigator: Navigator) {
        val lifecycle = LocalLifecycleOwner.current
        LaunchedEffect(true) {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                effects.collectLatest { handleEffect(it, navigator) }
            }
        }
    }

    private fun handleEffect(effect: PermissionsEffect, navigator: Navigator) {
        when(effect) {
            is PermissionsEffect.OpenCamera -> navigator.push(CameraScreen())
        }
    }

    @Composable
    private fun Screen(
        state: PermissionsState,
        setEvent: (PermissionsEvent) -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            val permissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestMultiplePermissions()
            ) { permissions ->
                val allPermissionsGranted = permissions.entries.all { it.value }
                if (allPermissionsGranted) setEvent(PermissionsEvent.PermissionsGranted)
            }

            NeedPermissionsItem(
                onGetPermissionsClickAction = {
                    permissionLauncher.launch(REQUIRED_PERMISSIONS)
                }
            )
        }
    }

    companion object {
        val REQUIRED_PERMISSIONS =
            mutableListOf(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

}