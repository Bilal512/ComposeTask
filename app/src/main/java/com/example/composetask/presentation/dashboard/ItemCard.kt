package com.example.composetask.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetask.domain.model.Movie

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    movie: Movie = Movie(
        id = 1,
        title = "The Shawshank Redemption",
        year = 1994,
        genre = listOf("Drama"),
        rating = 9.3,
        director = "Frank Darabont",
        actors = listOf("Tim Robbins", "Morgan Freeman"),
        plot = "Two imprisoned men bond over several years, finding solace and eventual redemption through acts of common decency.",
        poster = "https://fakeimg.pl/220x310/ff0000",
        trailer = "https://example.com/shawshank_redemption_trailer.mp4",
        runtime = 142,
        awards = "Nominated for 7 Oscars",
        country = "USA",
        language = "English",
        boxOffice = "$28.3 million",
        production = "Columbia Pictures",
        website = "http://www.warnerbros.com/movies/shawshank-redemption"
    )
) {

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.inversePrimary)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.Start),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {


            Text(
                text = movie.title,
                style = MaterialTheme.typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 16.sp
                )
            )
            Text(text = movie.year.toString())
            Text(
                text = movie.plot,
                style = MaterialTheme.typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 12.sp
                )
            )
        }

    }


}

@Preview
@Composable
private fun ItemCardPreview() {
    ItemCard()
}