package com.example.faceai.features.permissions

import com.example.faceai.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
        // save to data store
        setEffect(PermissionsEffect.OpenCamera)
    }

}