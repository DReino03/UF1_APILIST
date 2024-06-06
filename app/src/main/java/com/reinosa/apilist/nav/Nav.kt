package com.reinosa.apilist.nav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.reinosa.apilist.View.ProfileScreen
import com.reinosa.apilist.View.favScreen
import com.reinosa.apilist.View.homeScreen
import com.reinosa.apilist.View.launchScreen
import com.reinosa.apilist.ViewModel.APIViewModel
import detailScreen


@Composable
fun MyAppContent(
    navController: NavHostController,
    viewModel: APIViewModel
){
            NavHost(
                //modifier = modifier.weight(1f),
                navController = navController,
                startDestination = MyAppRoute.Home){
                composable(MyAppRoute.Home){
                    homeScreen(navController = navController, viewModel = viewModel)
                }
                composable(MyAppRoute.Fav){
                    favScreen(viewModel = viewModel)
                }
                composable(MyAppRoute.Profile){
                    ProfileScreen()
                }
                composable(MyAppRoute.Launch){
                    launchScreen(navController = navController)
                }
                composable(
                    route = MyAppRoute.Detail){
                    detailScreen(viewModel = viewModel, navController = navController)
                }


            }
    }



