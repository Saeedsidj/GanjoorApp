package com.saeedev.ganjoor.ir.presentation.poetsList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.saeedev.ganjoor.ir.R
import com.saeedev.ganjoor.ir.common.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoetsListScreen(
    viewModel: PoetsListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.ganjoor)
                    )

                }
            )
        }
    ) { pading ->
        LazyColumn(
            modifier = Modifier
                .padding(pading)
                .background(Color.White)
        ) {
            items(uiState) {
                PoetCard(
                    imgUrl = it.imgUrl,
                    name = it.name
                )
            }
        }
    }
}

@Composable
fun PoetCard(
    imgUrl: String,
    name: String,
    onCardClick: () -> Unit = { }, //to be continued
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onCardClick)
            .background(Color(255, 246, 247))
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .size(50.dp)
                .background(Color.Gray),
            model = ImageRequest.Builder(LocalContext.current)
                .data(Constants.BASE_URL.plus(imgUrl))
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = name,
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}