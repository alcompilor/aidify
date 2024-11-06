package com.example.aidify.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.aidify.R
import com.example.aidify.models.RequestState
import com.example.aidify.models.Route
import com.example.aidify.ui.components.LoadingState
import kotlinx.coroutines.flow.StateFlow

@Composable
fun <T> LoadingAIScreen(
    requestState: StateFlow<RequestState<T>>,
    resetState: () -> Unit,
    navController: NavController,
    successRoute: Route,
    failRoute: Route
) {
    val context = LocalContext.current
    val state by requestState.collectAsState()

    when (state) {
        is RequestState.Loading -> {
            LoadingState(text = stringResource(R.string.ai_loading_notice))
        }

        is RequestState.Success -> {
            Toast.makeText(context, stringResource(R.string.ai_success_notice), Toast.LENGTH_SHORT)
                .show()
            navController.navigate(successRoute.name) {
                popUpTo(navController.currentBackStackEntry?.destination?.route ?: "") {
                    inclusive = true
                }
            }
            resetState()
        }

        is RequestState.Error -> {
            Toast.makeText(context, stringResource(R.string.ai_error_notice), Toast.LENGTH_LONG)
                .show()
            navController.navigate(failRoute.name) {
                popUpTo(navController.currentBackStackEntry?.destination?.route ?: "") {
                    inclusive = true
                }
            }
            resetState()
        }

        is RequestState.Idle -> {}
    }
}
