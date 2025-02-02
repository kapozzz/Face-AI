package com.example.faceai.features.permissions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NeedPermissionsItem(
    onGetPermissionsClickAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Для работы приложения нам нужен доступ к вашей камере",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            TextButton(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .clip(RoundedCornerShape(26.dp))
                    .background(Color(0xFF274C77))
                ,
                onClick = onGetPermissionsClickAction
            ) {
                Text(
                    text = "Предоставить",
                    fontSize = 28.sp,
                    color = Color(0xFFE7ECEF)
                )
            }
        }
    }
}