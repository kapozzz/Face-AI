package com.example.faceai.features.permissions

import androidx.lifecycle.viewModelScope
import com.example.faceai.core.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PermissionsViewModel @Inject constructor()
    : BaseViewModel<PermissionsEvent, PermissionsState, PermissionsEffect>() {

    override fun createInitialState(): PermissionsState = PermissionsState()

    override fun handleEvent(event: PermissionsEvent) {
        when(event) {
            PermissionsEvent.PermissionsGranted -> permissionsGranted()
        }
    }

    private fun permissionsGranted() {
        setEffect(PermissionsEffect.OpenCamera)
    }

}