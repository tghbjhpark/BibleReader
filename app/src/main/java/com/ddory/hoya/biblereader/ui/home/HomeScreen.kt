package com.ddory.hoya.biblereader.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter

@Composable
fun HomeScreen() {
    ProfileCardView()
}

@Composable
fun ProfileCardView(
    homeViewModel: HomeViewModel = viewModel()
) {
    val photoUrl = homeViewModel.photoUrl.observeAsState()
    val name = homeViewModel.displayName.observeAsState()

    Row {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
            Image(
                painter = rememberImagePainter(
                    data = photoUrl.value
                ),
                contentDescription = "Android Logo",
                modifier = Modifier.size(50.dp)
            )
        }
        Text(name.value.orEmpty(), fontWeight = FontWeight.Bold)
    }
}
