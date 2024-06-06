package com.reinosa.apilist.nav

import androidx.compose.material.icons.Icons

sealed class Routes(val route: String) {
    object launchScreen:Routes("launchScreen")
    object homeScreen:Routes("homeScreen")
    object favScreen:Routes("favScreen")
    object profileScreen:Routes("profileScreen")

}