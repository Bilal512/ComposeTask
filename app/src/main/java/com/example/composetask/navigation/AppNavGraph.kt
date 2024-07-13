package com.example.composetask.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composetask.presentation.dashboard.DashboardScreen
import com.example.composetask.presentation.dashboard.DashboardViewModel
import com.example.composetask.presentation.details.DetailsScreen
import com.example.composetask.presentation.details.DetailsViewModel
import com.example.composetask.presentation.login.LoginScreen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = NavRoute.Login.path) {
        addLoginScreen(navController, this)
        addDashboardScreen(navController, this)
        addDetailsScreen(navController, this)
    }

}

private fun addLoginScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Login.path) {
        LoginScreen(
            navigateToDashboard = { email ->
                navController.navigate(NavRoute.Dashboard.withArgs(email))
            }
        )
    }
}

private fun addDashboardScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Dashboard.withArgsFormat(NavRoute.Dashboard.email),
        arguments = listOf(
            navArgument(NavRoute.Dashboard.email) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments
        val dashboardViewModel: DashboardViewModel = hiltViewModel()
        val context  = LocalContext.current
        LaunchedEffect(key1 = context) {
            dashboardViewModel.channel.collectLatest { event ->
                when(event) {
                    is DashboardViewModel.EventsToView.NavigateToDetailsScreen -> {
                        navController.navigate(NavRoute.Details.withArgs(event.details))
                    }
                }
            }
        }
        DashboardScreen(
            uiState = dashboardViewModel.uiState.collectAsStateWithLifecycle().value,
            onIntent = dashboardViewModel::onIntent
        )
    }
}

private fun addDetailsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Details.withArgsFormat(NavRoute.Details.obj),
        arguments = listOf(
            navArgument(NavRoute.Details.obj) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->
        val detailsViewModel: DetailsViewModel = hiltViewModel()
        DetailsScreen(
            uiState = detailsViewModel.uiState.collectAsStateWithLifecycle().value
        )
    }
}