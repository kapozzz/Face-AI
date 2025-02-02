package com.example.faceai.features.camera.components.masks

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.example.faceai.core.ui.copy
import com.example.faceai.domain.ImageFrame
import com.example.faceai.domain.Sizes
import com.example.faceai.features.camera.components.clear
import com.example.faceai.features.camera.components.scaleToCanvas
import com.google.mlkit.vision.face.FaceContour

/* Converts image coordinates to canvas coordinates to draw facial contours */
@Composable
fun ContourMask(
    imageFrame: ImageFrame,
    screenSizes: Sizes,
    onDraw: DrawScope.(scaledContours: List<FaceContour>) -> Unit,
    modifier: Modifier = Modifier,
) {
    Canvas(modifier = modifier.fillMaxSize()) {
        if (imageFrame.faces.isEmpty()) {
            clear()
            return@Canvas
        }
        imageFrame.faces.forEach { face ->
            val scaledContours = face.allContours.map { contour ->
                contour.copy(points = contour.points.map { point ->
                    point.scaleToCanvas(
                        imageFrame.imageSizes,
                        screenSizes
                    )
                })
            }
            onDraw(scaledContours)
        }
    }
}