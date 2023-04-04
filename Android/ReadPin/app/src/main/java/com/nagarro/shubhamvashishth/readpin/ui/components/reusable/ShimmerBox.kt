package com.nagarro.shubhamvashishth.readpin.ui.components.reusable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun bookPlaceholderShimmer(){
    Row {
    for (i in 0..3){
        Box(modifier = Modifier
            .padding(10.dp)
            .width(120.dp)
            .height(200.dp)
            .shimmer()
            .background(Color(4283256141)))
    }
    }

}