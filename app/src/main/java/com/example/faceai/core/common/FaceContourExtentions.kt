package com.example.faceai.core.common

import android.graphics.PointF
import com.google.mlkit.vision.face.FaceContour

fun FaceContour.copy(
    @FaceContour.ContourType faceContourType: Int = this.faceContourType,
    points: List<PointF> = this.points
): FaceContour = FaceContour(faceContourType, points)
