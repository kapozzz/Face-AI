package com.example.faceai.features.camera.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.faceai.R
import com.example.faceai.features.camera.MaskType
import com.kapozzz.ui.AppTheme

@Composable
fun PickMaskTypeButton(
    onMaskClickAction: (MaskType) -> Unit,
    modifier: Modifier = Modifier
) {

    val isOpened = remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppTheme.colors.background)
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            AnimatedContent(isOpened.value) {
                if (!it) {
                    IconButton({ isOpened.value = true }, modifier = Modifier.size(86.dp)) {
                        Icon(
                            modifier = Modifier.size(62.dp),
                            painter = painterResource(R.drawable.ic_face),
                            contentDescription = null,
                            tint = AppTheme.colors.onBackground
                        )
                    }
                } else {
                    IconButton({ isOpened.value = false }, modifier = Modifier.size(86.dp)) {
                        Icon(
                            modifier = Modifier.size(62.dp),
                            painter = painterResource(R.drawable.ic_close),
                            contentDescription = null,
                            tint = AppTheme.colors.onBackground
                        )
                    }
                }
            }

            MaskType.entries.forEach {
                AnimatedVisibility(isOpened.value) {
                    MaskButton(it, {
                        onMaskClickAction(it)
                        isOpened.value = false
                    })
                }
            }
        }
    }
}

@Composable
private fun MaskButton(
    type: MaskType,
    onClick: (MaskType) -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = { onClick(type) },
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(Color(0xFF274C77))
    ) {
        Text(
            text = stringResource(type.title),
            fontSize = 28.sp,
            color = Color(0xFFE7ECEF)
        )
    }
}