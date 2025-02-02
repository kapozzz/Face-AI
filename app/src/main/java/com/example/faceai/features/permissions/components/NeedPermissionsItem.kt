package com.example.faceai.features.permissions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.faceai.R
import com.example.faceai.core.ui.type.AppTypo
import com.kapozzz.ui.AppTheme

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
            Icon(
                modifier = Modifier
                    .size(124.dp)
                    .padding(bottom = 16.dp),
                painter = painterResource(R.drawable.ic_access),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                text = stringResource(R.string.need_permissions),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                style = AppTypo.regular
            )
            TextButton(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .clip(RoundedCornerShape(26.dp))
                    .background(AppTheme.colors.secondary)
                ,
                onClick = onGetPermissionsClickAction
            ) {
                Text(
                    text = stringResource(R.string.provide_permissions),
                    fontSize = 28.sp,
                    color = AppTheme.colors.onSecondary,
                    style = AppTypo.regular
                )
            }
        }
    }
}