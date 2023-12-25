package com.example.findmyip.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findmyip.domain.IpItem

@Composable
fun IpInfoItem(
    modifier: Modifier,
    ipItem: IpItem
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(16.dp)
    ) {

        Text(
            text = ipItem.name,
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f).padding(1.dp)
        )

     //   Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = ":",
            fontStyle = FontStyle.Normal,
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

     //   Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = ipItem.value!!,
            fontStyle = FontStyle.Normal,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
                .padding(1.dp)
        )

    }

}