package com.example.composetask.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    uiState: DetailUiState = DetailUiState()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        AsyncImage(
            model = "https://image.tmdb.org/t/p/original/9Rj8l6gElLpRL7Kj17iZhrT5Zuw.jpg",
            contentDescription = null,
            modifier= Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Text(
            text = uiState.movie?.title.orEmpty(),
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(
            text = uiState.movie?.plot.orEmpty(),
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(
            text = "Actors : ${uiState.movie?.actorsText.orEmpty()}",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(
            text = "Genre : ${uiState.movie?.genreText.orEmpty()}",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.tertiary
        )


        Text(
            text = "Awards : ${uiState.movie?.awards.orEmpty()}",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(
            text = "Language : ${uiState.movie?.language.orEmpty()}",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(
            text = "boxOffice : ${uiState.movie?.boxOffice.orEmpty()}",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(
            text = "Production : ${uiState.movie?.production.orEmpty()}",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.tertiary
        )


    }


}

@Preview
@Composable
private fun DetailsScreenPreview() {
    DetailsScreen()
}