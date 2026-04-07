package com.pobezhkin.starwars.presentation.detailsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StarDetailsScreen(modifier: Modifier = Modifier, heroName : String){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment  =  Alignment.Center){
        Text("СКОРО БУДУТ ДАННЫЕ ПОДОЖДИТЕ")
    }
}

@Preview
@Composable
fun StarDetailsScreenPreview(){
    Box(contentAlignment =  Alignment.Center){
        Text("СКОРО БУДУТ ДАННЫЕ ПОДОЖДИТЕ")
    }
}