package com.example.faceai.features.camera.components.masks

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.faceai.domain.ImageFrame
import com.example.faceai.domain.Sizes
import com.example.faceai.features.camera.components.drawClearMaskPoints
import com.example.faceai.features.camera.components.drawFillMaskPoints
import com.google.mlkit.vision.face.FaceContour

@Composable
fun ColoredFillMask(
    imageFrame: ImageFrame,
    screenSizes: Sizes,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    ContourMask(
        imageFrame = imageFrame,
        screenSizes = screenSizes,
        onDraw = { scaledContours ->
            scaledContours.forEach { contour ->
                if (contour.faceContourType == FaceContour.FACE) {
                    drawFillMaskPoints(contour.points, color)
                }
                if (contour.faceContourType == FaceContour.RIGHT_EYE) {
                    drawClearMaskPoints(contour.points)
                }
                if (contour.faceContourType == FaceContour.LEFT_EYE) {
                    drawClearMaskPoints(contour.points)
                }
                if (contour.faceContourType == FaceContour.UPPER_LIP_BOTTOM) {
                    drawFillMaskPoints(contour.points, Color.Red)
                }
                if (contour.faceContourType == FaceContour.UPPER_LIP_TOP) {
                    drawFillMaskPoints(contour.points, Color.Red)
                }
                if (contour.faceContourType == FaceContour.LOWER_LIP_TOP) {
                    drawFillMaskPoints(contour.points, Color.Red)
                }
                if (contour.faceContourType == FaceContour.LOWER_LIP_BOTTOM) {
                    drawFillMaskPoints(contour.points, Color.Red)
                }
            }
        },
        modifier = modifier
    )
}

