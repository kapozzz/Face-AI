package com.kapozzz.ui

import androidx.compose.ui.graphics.Color
import com.example.faceai.core.ui.dark
import com.example.faceai.core.ui.darkGray
import com.example.faceai.core.ui.darkOutline
import com.example.faceai.core.ui.green
import com.example.faceai.core.ui.greenContainer
import com.example.faceai.core.ui.lightGray
import com.example.faceai.core.ui.red
import com.example.faceai.core.ui.redContainer
import com.example.faceai.core.ui.yellow
import com.example.faceai.core.ui.yellowContainer

internal val baseLightPalette = Colors(
    primary = red,
    onPrimary = Color.White,
    primaryContainer = redContainer,
    onPrimaryContainer = Color.White,
    secondary = green,
    onSecondary = Color.White,
    secondaryContainer = greenContainer,
    onSecondaryContainer = Color.White,
    tertiary = yellow,
    onTertiary = Color.White,
    tertiaryContainer = yellowContainer,
    onTertiaryContainer = Color.Black,
    background = Color.White,
    onBackground = Color.Black,
    outline = Color.LightGray,
    error = Color.Red,
    hint = Color.Gray,
    container = lightGray,
    onContainer = Color.Black,
    containerOutline = Color.Black,
    tapColor = darkGray
)

internal val baseDarkPalette = Colors(
    primary = red,
    onPrimary = Color.White,
    primaryContainer = redContainer,
    onPrimaryContainer = Color.White,
    secondary = green,
    onSecondary = Color.White,
    secondaryContainer = greenContainer,
    onSecondaryContainer = Color.White,
    tertiary = yellow,
    onTertiary = Color.White,
    tertiaryContainer = yellowContainer,
    onTertiaryContainer = Color.Black,
    background = dark,
    onBackground = Color.White,
    outline = darkOutline,
    error = Color.Red,
    hint = Color.Gray,
    container = dark,
    onContainer = Color.White,
    containerOutline = darkOutline,
    tapColor = lightGray
)