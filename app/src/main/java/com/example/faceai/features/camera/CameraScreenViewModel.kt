package com.example.faceai.features.camera

import com.example.faceai.core.ui.BaseViewModel
import com.example.faceai.domain.ImageFrame
import com.google.mlkit.vision.face.Face
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraScreenViewModel @Inject constructor() :
    BaseViewModel<CameraScreenEvent, CameraScreenState, CameraScreenEffect>() {

    override fun createInitialState(): CameraScreenState = CameraScreenState()

    override fun handleEvent(event: CameraScreenEvent) {
        when (event) {
            is CameraScreenEvent.Faces -> processFaces(event.frame)
            is CameraScreenEvent.SetMask -> currentState.maskType.value = event.type
        }
    }

    private fun processFaces(frame: ImageFrame) {
        currentState.currentFrame.value = frame
    }

}