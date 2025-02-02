package com.example.faceai.features.camera

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.faceai.domain.Sizes
import com.example.faceai.features.camera.components.CameraPreview
import com.example.faceai.features.camera.components.PickMaskTypeButton
import com.example.faceai.features.camera.components.masks.ColoredFillMask
import com.example.faceai.features.camera.components.masks.ColoredPointsMask

class CameraScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = getViewModel<CameraScreenViewModel>()
        val context = LocalContext.current
        val screenWidth = context.resources.displayMetrics.widthPixels
        val screenHeight = context.resources.displayMetrics.heightPixels
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CameraPreview(processFaceContourDetectionResult = { imageFrame ->
                viewModel.setEvent(CameraScreenEvent.Faces(imageFrame))
            })
            when (viewModel.currentState.maskType.value) {
                MaskType.EMPTY -> {
                    // ignore
                }

                MaskType.CONTOUR -> {
                    ColoredPointsMask(
                        imageFrame = viewModel.currentState.currentFrame.value,
                        screenSizes = Sizes(screenHeight, screenWidth)
                    )
                }

                MaskType.FILL_FACE -> {
                    ColoredFillMask(
                        imageFrame = viewModel.currentState.currentFrame.value,
                        screenSizes = Sizes(screenHeight, screenWidth),
                        color = Color.Black
                    )
                }
            }

            PickMaskTypeButton(
                onMaskClickAction = {
                    viewModel.setEvent(CameraScreenEvent.SetMask(it))
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            )

        }
    }

}