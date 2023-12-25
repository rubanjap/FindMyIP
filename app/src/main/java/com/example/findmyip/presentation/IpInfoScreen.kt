package com.example.findmyip.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.findmyip.presentation.IpInfoItem
import com.example.findmyip.domain.IpItem

@Composable
fun IpInfoScreen(ipInfoViewModel: FindMyIpViewModel = hiltViewModel()) {

    val ipInfoItems by ipInfoViewModel.ipInfo.collectAsState()
    val loading by ipInfoViewModel.loading.collectAsState()
    val error by ipInfoViewModel.error.collectAsState()
    val scrollState = rememberScrollState()

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {

        if (loading) {
            // Display progress bar
            CircularProgressIndicator(
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        } else {
            if (ipInfoItems != null) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(ipInfoItems!!) { ipItem ->
                        IpInfoItem(
                            ipItem = ipItem,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                }

            } else {
                // Display error message
                Text(
                    "Error: $error",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .background(Color.Red)
                        .padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
