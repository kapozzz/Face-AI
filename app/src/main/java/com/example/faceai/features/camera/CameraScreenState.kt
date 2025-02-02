package com.example.faceai.features.camera

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.faceai.R
import com.example.faceai.core.ui.UiEffect
import com.example.faceai.core.ui.UiEvent
import com.example.faceai.core.ui.UiState
import com.example.faceai.domain.ImageFrame

data class CameraScreenState(
    val currentFrame: MutableState<ImageFrame> = mutableStateOf(ImageFrame.EMPTY),
    val maskType: MutableState<MaskType> = mutableStateOf(MaskType.EMPTY)
) : UiState

sealed class CameraScreenEvent : UiEvent {
    data class Faces(val frame: ImageFrame) : CameraScreenEvent()
    data class SetMask(val type: MaskType): CameraScreenEvent()
}

sealed class CameraScreenEffect : UiEffect

enum class MaskType(@StringRes val title: Int) {

    EMPTY(R.string.mask_type_empty),
    CONTOUR(R.string.mask_type_contour),
    FILL_FACE(R.string.mask_type_fill_face)

}