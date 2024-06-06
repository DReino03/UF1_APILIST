package com.reinosa.apilist

import android.annotation.SuppressLint
import com.reinosa.apilist.nav.MyAppContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController

import com.reinosa.apilist.ViewModel.APIViewModel
import com.reinosa.apilist.ui.theme.APILISTTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APILISTTheme {
                val navController = rememberNavController()
                val viewModel: APIViewModel by viewModels()
                MyAppContent(navController = navController, viewModel = viewModel)
            }
        }
    }
}


