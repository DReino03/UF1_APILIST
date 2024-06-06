package com.reinosa.apilist.View.Recycler
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.reinosa.apilist.Model.Article
import com.reinosa.apilist.Model.Data
import com.reinosa.apilist.ViewModel.APIViewModel
import com.reinosa.apilist.nav.MyAppBottomNavigationBar
import com.reinosa.apilist.nav.Routes

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyRecyclerView(myViewModel: APIViewModel, navController: NavController) {
    val showLoading: Boolean by myViewModel.loading.observeAsState(true)
    val noticias by myViewModel.noticias.observeAsState(Data(listOf<Article>(),  "",0))

    myViewModel.getNoticias()

    Scaffold(
        topBar = {
            //MyAppBar()
        },
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            Box {
                if (currentDestination?.hierarchy?.any { navDestination ->
                        navDestination.route == Routes.homeScreen.route ||
                                navDestination.route == Routes.favScreen.route ||
                                navDestination.route == Routes.profileScreen.route
                    } == true) {
                    currentDestination.route?.let {
                        MyAppBottomNavigationBar(
                            selectedDestination = it,
                            navigateTopLevelDestination = { route ->
                                navController.navigate(route.route) {
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
        }
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colors.primary
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth().background(color = Color.DarkGray),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(noticias!!.articles!!) {
                    newsItem(noticia = it, navController = navController, viewModel = myViewModel)

                }

            }
        }
    }
}

