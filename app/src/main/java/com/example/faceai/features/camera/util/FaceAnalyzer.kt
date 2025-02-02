package com.example.faceai.features.camera.util

import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.faceai.domain.ImageFrame
import com.example.faceai.domain.Sizes
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetector
import com.google.mlkit.vision.face.FaceDetectorOptions
import com.google.mlkit.vision.face.FaceDetectorOptions.CONTOUR_MODE_ALL
import timber.log.Timber

class FaceAnalyzer(
    private val processFaceContourDetectionResult: (ImageFrame) -> Unit
) : ImageAnalysis.Analyzer {

    private val options =
        FaceDetectorOptions.Builder()
            .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
            .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_NONE)
            .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_NONE)
            .setContourMode(CONTOUR_MODE_ALL)
            .build()

    private val detector: FaceDetector = FaceDetection.getClient(options)

    @ExperimentalGetImage
    override fun analyze(imageProxy: ImageProxy) {

        val mediaImage = imageProxy.image ?: return
        val rotationDegrees = imageProxy.imageInfo.rotationDegrees

        val imageHeight = mediaImage.height
        val imageWidth = mediaImage.width

        val image: InputImage =
            InputImage.fromMediaImage(mediaImage, rotationDegrees)

        detector.process(image)
            .addOnSuccessListener { faces ->
                faces.firstOrNull()?.boundingBox?.height()
                processFaceContourDetectionResult(
                    ImageFrame(
                        faces = faces,
                        imageSizes = Sizes(width = imageHeight, height = imageWidth)
                    )
                )
            }
            .addOnFailureListener { e ->
                Timber.e(e)
            }
            .addOnCompleteListener {
                imageProxy.close()
            }

    }

}