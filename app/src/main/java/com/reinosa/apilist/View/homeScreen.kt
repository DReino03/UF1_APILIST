package com.reinosa.apilist.View

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.reinosa.apilist.View.Recycler.MyRecyclerView
import com.reinosa.apilist.ViewModel.APIViewModel
import com.reinosa.apilist.nav.MyAppBottomNavigationBar
import com.reinosa.apilist.nav.MyAppRoute

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun homeScreen(navController: NavController, viewModel: APIViewModel = viewModel()) {
    Scaffold(
        topBar = {
            Row(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f)) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "search" )
                }
                Spacer(modifier = Modifier.weight(1f))

                Text(text = "Noticias",
                    modifier = Modifier.padding(14.dp))
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f)) {
                    Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "search" )
                }
            }
        },
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            if (currentDestination?.route in listOf(MyAppRoute.Home, MyAppRoute.Fav, MyAppRoute.Profile)) {
                if (currentDestination != null) {
                    MyAppBottomNavigationBar(
                        selectedDestination = currentDestination.route!!,
                        navigateTopLevelDestination = { destination ->
                            navController.navigate(destination.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        MyRecyclerView(myViewModel = viewModel, navController = navController)
    }
}




