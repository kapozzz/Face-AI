package com.example.faceai.features.permissions

import com.example.faceai.core.ui.UiEffect
import com.example.faceai.core.ui.UiEvent
import com.example.faceai.core.ui.UiState

data class PermissionsState(val isGranted: Boolean = false): UiState

sealed class PermissionsEvent: UiEvent {
    data object PermissionsGranted: PermissionsEvent()
}

sealed class PermissionsEffect: UiEffect {
    data object OpenCamera: PermissionsEffect()
}