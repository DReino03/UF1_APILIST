package com.reinosa.apilist.View

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.reinosa.apilist.ViewModel.APIViewModel

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySearchBar(myViewModel: APIViewModel) {
    val searchText by myViewModel.searchText.observeAsState("")

    SearchBar(
        query = searchText,
        onQueryChange = { myViewModel.onSearchTextChange(it) },
        onSearch = { myViewModel.onSearchTextChange(it) },
        active = true,
        leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search") },
        trailingIcon = { Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Mic") },
        placeholder = { Text("What are you looking for?") },
        onActiveChange = {},
        modifier = Modifier.fillMaxHeight(0.1f).clip(CircleShape)
    ) {
        // Searchs list
    }
}

 */