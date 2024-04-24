package com.gyub.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gyub.core.design.R
import com.gyub.core.design.theme.CleanArchitectureComposeMovieAppTheme
import com.gyub.core.design.theme.GDSWhite
import com.gyub.core.design.theme.Paddings
import com.gyub.movieapp.ui.CategoryList
import com.gyub.movieapp.ui.GenreScreen
import com.gyub.movieapp.ui.MovieScreen
import com.gyub.movieapp.util.enums.MovieListsCategory
import com.gyub.movieapp.util.ui.ComingSoonCircularText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureComposeMovieAppTheme {
                var showText by remember { mutableStateOf(false) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = GDSWhite
                ) {
                    ComingSoonCircularText(visible = showText, onVisibilityChange = { showText = it })

                    Column(modifier = Modifier.fillMaxSize()) {
                        MovieTopAppBar(onImageClick = { showText = true })
                        Spacer(modifier = Modifier.height(48.dp))
                        CategoryList(MovieListsCategory.entries)
                        Spacer(modifier = Modifier.height(48.dp))
                        GenreScreen()
                        Spacer(modifier = Modifier.height(72.dp))
                        MovieScreen(modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopAppBar(onImageClick: () -> Unit) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = Paddings.xExtra, end = Paddings.xExtra),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gds_menu),
                    contentDescription = "Menu",
                    modifier = Modifier.clickable {
                        onImageClick()
                    }
                )

                Image(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = Modifier.clickable {
                        onImageClick()
                    }
                )
            }

        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopAppBarPreview() {
    MovieTopAppBar({})
}
