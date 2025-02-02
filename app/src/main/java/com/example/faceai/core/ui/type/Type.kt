package com.example.faceai.core.ui.type

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object AppTypo {

    val regular = TextStyle(
        fontFamily = popinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 38.sp,
        letterSpacing = 0.5.sp
    )

    val emoji = TextStyle(
        fontFamily = emojiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 38.sp,
        letterSpacing = 0.5.sp
    )

}