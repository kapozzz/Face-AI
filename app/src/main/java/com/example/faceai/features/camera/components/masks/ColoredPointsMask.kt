package com.example.faceai.features.camera.components.masks

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.faceai.domain.ImageFrame
import com.example.faceai.domain.Sizes
import com.example.faceai.features.camera.components.drawMaskPoints

@Composable
fun ColoredPointsMask(
    imageFrame: ImageFrame,
    screenSizes: Sizes,
    modifier: Modifier = Modifier
) {
    ContourMask(
        imageFrame = imageFrame,
        screenSizes = screenSizes,
        onDraw = { scaledContours ->
            scaledContours.forEach { contour ->
                drawMaskPoints(contour.points, Color.Green)
            }
        },
        modifier = modifier
    )
}