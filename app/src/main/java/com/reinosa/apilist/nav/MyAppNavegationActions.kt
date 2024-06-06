package com.reinosa.apilist.nav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.reinosa.apilist.R

@Composable
fun MyAppBottomNavigationBar(
    selectedDestination: String,
    navigateTopLevelDestination: (MyAppTopLevelDestination) -> Unit
) {
    BottomNavigation {
        TOP_LEVEL_DESTINATIONS.forEach { destination ->
            BottomNavigationItem(
                icon = { Icon(imageVector = destination.selectedIcon, contentDescription = null) },
                label = { Text(stringResource(id = destination.iconTextId)) },
                selected = selectedDestination == destination.route,
                onClick = { navigateTopLevelDestination(destination) }
            )
        }
    }
}

data class MyAppTopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    MyAppTopLevelDestination(
        route = MyAppRoute.Home,
        selectedIcon = Icons.Default.Home,
        iconTextId = R.string.app_name
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.Fav,
        selectedIcon = Icons.Default.Favorite,
        iconTextId = R.string.app_name
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.Profile,
        selectedIcon = Icons.Default.Person,
        iconTextId = R.string.app_name
    ),

)



object  MyAppRoute{
    const val Home = "home"
    const val Fav = "fav"
    const val Profile = "profile"
    const val Launch = "launch"
    const val Detail = "detail"

}