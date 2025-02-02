package com.example.faceai.features.camera.components

import android.graphics.PointF
import android.util.Log
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import com.example.faceai.domain.Sizes
import java.lang.Float.max

fun DrawScope.clear() {
    drawRect(
        color = Color.Transparent,
        size = size,
        blendMode = BlendMode.Clear
    )
}

fun PointF.scaleToCanvas(
    imageSizes: Sizes,
    screenSizes: Sizes,
    isFrontCamera: Boolean = true
): PointF {
    val scale = max(
        screenSizes.width.toFloat() / imageSizes.width.toFloat(),
        screenSizes.height.toFloat() / imageSizes.height.toFloat()
    )
    val offsetX = (screenSizes.width - imageSizes.width * scale) / 2
    val offsetY = (screenSizes.height - imageSizes.height * scale) / 2

    val x = if (isFrontCamera) {
        screenSizes.width - (this.x * scale + offsetX)
    } else {
        this.x * scale + offsetX
    }

    val y = this.y * scale + offsetY
    return PointF(x, y)
}

fun DrawScope.drawMaskPoints(points: List<PointF>, color: Color) {
    points.forEach { point ->
        drawCircle(
            color = color,
            radius = 8f,
            center = Offset(point.x, point.y)
        )
    }
}

fun DrawScope.drawFillMaskPoints(points: List<PointF>, color: Color) {
    if (points.size < 3) return

    val path = Path().apply {
        val firstPoint = points.first()
        moveTo(firstPoint.x, firstPoint.y)

        points.drop(1).forEach { point ->
            lineTo(point.x, point.y)
        }

        close()
    }

    drawPath(
        path = path,
        color = color,
        style = Fill
    )
}

fun DrawScope.drawClearMaskPoints(points: List<PointF>) {
    if (points.size < 3) return

    val path = Path().apply {
        moveTo(points.first().x, points.first().y)
        points.drop(1).forEach { point ->
            lineTo(point.x, point.y)
        }
        close()
    }

    drawPath(
        path = path,
        color = Color.Transparent,
        blendMode = BlendMode.Clear
    )
}