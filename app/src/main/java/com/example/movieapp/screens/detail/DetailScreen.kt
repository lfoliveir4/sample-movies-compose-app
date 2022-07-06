package com.example.movieapp.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies

fun goBack(navigationController: NavController) {
    navigationController.popBackStack()
}

@Composable
fun DetailScreen(
    navigationController: NavController,
    movieId: String?,
) {
    val movie = getMovies().filter { movie ->
        movie.id == movieId
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
            ) {
                Text(text = "Details Movie: ")
                Text(text = movie[0].title)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Title:")
                Text(text = movie[0].title)
            }

            Spacer(modifier = Modifier.padding(1.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Director:")
                Text(text = movie[0].director)
            }

            Spacer(modifier = Modifier.padding(1.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Actors: ")
                Text(text = movie[0].actors)
            }

            Spacer(modifier = Modifier.padding(1.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Rating:")
                Text(text = movie[0].rating)
            }

            CarouselImages(movie)

            Spacer(modifier = Modifier.height(23.dp))

            Button(onClick = { goBack(navigationController) }) {
                Text(text = "Go Back")
            }
        }
    }
}

@Composable
private fun CarouselImages(movie: List<Movie>) {
    LazyRow {
        items(movie[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = image),
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}