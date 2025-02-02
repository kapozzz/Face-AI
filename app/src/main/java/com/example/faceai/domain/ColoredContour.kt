package com.example.faceai.domain

import androidx.compose.ui.graphics.Color
import com.google.mlkit.vision.face.FaceContour

data class ColoredContour(@FaceContour.ContourType val contour: Int, val color: Color)