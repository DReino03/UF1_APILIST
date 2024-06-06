package com.reinosa.apilist.View

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.reinosa.apilist.Model.Storage.UserPrefs


@Composable
fun favScreen(viewModel: ViewModel) {

    val context = LocalContext.current
    val userPrefs = UserPrefs(context)
    val storedUserData = userPrefs.getUserData.collectAsState(initial = emptyList())

    if (storedUserData.value.isEmpty() && storedUserData.value[0].isEmpty()
        && storedUserData.value[1].isEmpty()) {
        // No data stored
    } else {
        // Data stored
    }
    Column {
        Text(text ="Fav Screen")
    }
}