package com.nagarro.shubhamvashishth.readpin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.nagarro.shubhamvashishth.readpin.ui.components.BottomBar
import com.nagarro.shubhamvashishth.readpin.ui.components.MainScreen
import com.nagarro.shubhamvashishth.readpin.ui.theme.ReadPinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReadPinTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}


