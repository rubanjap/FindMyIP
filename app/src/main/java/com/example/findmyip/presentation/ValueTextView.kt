package com.example.findmyip.presentation

import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ValueTextView(
    modifier: Modifier,
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelSmall,
        modifier = modifier.fillMaxWidth()
            .background(Color.Green)
            .padding(8.dp)
    )

}