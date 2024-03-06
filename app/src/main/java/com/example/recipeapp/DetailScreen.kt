package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.recipeapp.data.Category

@Composable
fun DetailScreen(modifier: Modifier = Modifier,
                 catergory:Category
                 ){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = catergory.strCategory,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge
        )
        Image(painter = rememberAsyncImagePainter(catergory.strCategoryThumb),
              contentDescription = catergory.strCategory,
              modifier = Modifier
                  .wrapContentSize()
                  .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = catergory.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .padding(4.dp)
                .scrollable(
                    rememberScrollState(),
                    orientation = Orientation.Vertical
                )
            )
    }
}