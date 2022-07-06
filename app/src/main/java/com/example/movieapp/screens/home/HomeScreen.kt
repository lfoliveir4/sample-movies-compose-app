package com.example.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.widgets.MovieRow

@Composable
fun Header(title: String) {
    TopAppBar(
        backgroundColor = Color.Gray,
        elevation = 5.dp
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(15.dp),
            color = Color.White,
        )
    }
}

@Composable
fun HomeScreen(navigationController: NavController) {
    Scaffold(
        topBar = { Header(title = "Movies") }
    ) {
        MainContent(navigationController = navigationController)
    }
}

@Composable
fun MainContent(
    navigationController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navigationController.navigate(
                        route = MovieScreens.DetailScreen.name + "/${movie}"
                    )
                }
            }
        }
    }
}