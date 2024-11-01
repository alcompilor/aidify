package com.example.aidify

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aidify.models.NavigatorAnimations
import com.example.aidify.models.Route
import com.example.aidify.screens.EducationalLibraryScreen
import com.example.aidify.screens.UncopeScreen
import com.example.aidify.screens.WelcomeScreen
import com.example.aidify.screens.AddictionChoiceScreen
import com.example.aidify.viewmodels.DataViewModel
import com.example.aidify.viewmodels.UncopeViewModel
import com.example.aidify.screens.StageCheckScreen
import com.example.aidify.viewmodels.EducationalLibraryViewModel
import com.example.aidify.viewmodels.WelcomeViewModel
import com.example.aidify.viewmodels.AddictionChoiceViewModel
import com.example.aidify.screens.LoadingAIScreen
import com.example.aidify.viewmodels.StageCheckViewModel

@Composable
fun Navigator(navController: NavHostController, modifier: Modifier = Modifier) {
    val animations = getAnimations()
    val dataViewModel: DataViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Route.Welcome.name,
        modifier = Modifier.then(modifier)
    ) {
        composable(
            route = Route.Welcome.name,
            enterTransition = animations.enterTransition,
            exitTransition = animations.exitTransition,
            popEnterTransition = animations.popEnterTransition,
            popExitTransition = animations.popExitTransition
        ) {
            val welcomeViewModel: WelcomeViewModel = viewModel()
            WelcomeScreen(viewmodel = welcomeViewModel, navController = navController)
        }

        composable(
            route = Route.AddictionChoice.name,
            enterTransition = animations.enterTransition,
            exitTransition = animations.exitTransition,
            popEnterTransition = animations.popEnterTransition,
            popExitTransition = animations.popExitTransition
        ) {

            val addictionChoiceViewModel = AddictionChoiceViewModel(dataViewModel.state)
            AddictionChoiceScreen(navController = navController, viewModel = addictionChoiceViewModel)
        }


        composable(
            route = Route.OpenQuestions.name,
            enterTransition = animations.enterTransition,
            exitTransition = animations.exitTransition,
            popEnterTransition = animations.popEnterTransition,
            popExitTransition = animations.popExitTransition
        ) {
        }

        composable(
            route = Route.UNCOPE.name,
            enterTransition = animations.enterTransition,
            exitTransition = animations.exitTransition,
            popEnterTransition = animations.popEnterTransition,
            popExitTransition = animations.popExitTransition
        ) {
            val uncopeViewModel = UncopeViewModel(dataViewModel.state)
            UncopeScreen(viewmodel = uncopeViewModel, navController = navController)
        }

        composable(
            route = Route.STAGECHECK.name,
            enterTransition = animations.enterTransition,
            exitTransition = animations.exitTransition,
            popEnterTransition = animations.popEnterTransition,
            popExitTransition = animations.popExitTransition
        ) {
            val stageCheckViewModel = StageCheckViewModel(dataViewModel.state)
            StageCheckScreen(viewModel = stageCheckViewModel, navController = navController)
        }

        composable(
            route = Route.Summary.name,
            enterTransition = animations.enterTransition,
            exitTransition = animations.exitTransition,
            popEnterTransition = animations.popEnterTransition,
            popExitTransition = animations.popExitTransition
        ) {

        }

        composable(
            route = Route.EducationLibrary.name,
            enterTransition = animations.enterTransition,
            exitTransition = animations.exitTransition,
            popEnterTransition = animations.popEnterTransition,
            popExitTransition = animations.popExitTransition
        ) {
            val educationalLibraryViewModel: EducationalLibraryViewModel = viewModel()
            EducationalLibraryScreen(educationalLibraryViewModel, navController)
        }

        composable(
            route = Route.LoadingAI.name,
            enterTransition = animations.enterTransition,
            exitTransition = animations.exitTransition,
            popEnterTransition = animations.popEnterTransition,
            popExitTransition = animations.popExitTransition
        ) {
            LoadingAIScreen(
                requestState = dataViewModel.aiRequestState,
                resetState = dataViewModel::resetAiRequestState,
                navController = navController,
                successRoute = Route.Summary,
                failRoute = Route.Welcome
            )
        }
    }
}

fun getAnimations(): NavigatorAnimations {
    return NavigatorAnimations(
        enterTransition = {
            slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }) + fadeIn()
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth }) + fadeOut()
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = { fullWidth -> -fullWidth }) + fadeIn()
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth }) + fadeOut()
        }
    )
}