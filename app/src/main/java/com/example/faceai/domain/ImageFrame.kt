package com.example.faceai.domain

import com.google.mlkit.vision.face.Face

data class ImageFrame(
    val faces: List<Face>,
    val imageSizes: Sizes
) {
    companion object {
        val EMPTY = ImageFrame(emptyList(), Sizes(0, 0))
    }
}