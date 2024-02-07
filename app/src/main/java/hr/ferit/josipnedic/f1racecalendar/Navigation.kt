package hr.ferit.josipnedic.f1racecalendar

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.ferit.josipnedic.f1racecalendar.Details.RaceDetailScreen
import hr.ferit.josipnedic.f1racecalendar.Racing.RacingPage
import hr.ferit.josipnedic.f1racecalendar.Results.DriversViewModel
import hr.ferit.josipnedic.f1racecalendar.Results.ResultsScreen

object Routes {

  const val SCREEN_RACING = "racingList"
  const val SCREEN_RACE_DETAILS = "raceDetails/{raceId}"
  fun getRaceDetailsPath(raceId: Int?): String {
    if (raceId != null && raceId != -1) {
      return "raceDetails/$raceId"
    }
    return "raceDetails/0"
  }

  const val SCREEN_RACE_RESULTS = "raceResults/{raceId}"
  fun getRaceResultSPath(raceId: Int?): String {
    if (raceId != null && raceId != -1) {
      return "raceResults/$raceId"
    }
    return "raceResults/0"
  }
}

@Composable
fun NavigationController(
  viewModel: DriversViewModel
) {
  val navController = rememberNavController()
  NavHost(
    navController = navController,
    startDestination = Routes.SCREEN_RACING
  ) {
    composable(Routes.SCREEN_RACING) {
      RacingPage(viewModel,navController)
    }
    composable(
      Routes.SCREEN_RACE_DETAILS,
      arguments = listOf(
        navArgument("raceId") {
          type = NavType.IntType
        }
      )
    ) { backStackEntry ->
      backStackEntry.arguments?.getInt("raceId")?.let {id ->
        RaceDetailScreen(
          navController,
          race = viewModel.racesData[id]
        )
      }
    }

    composable(
      Routes.SCREEN_RACE_RESULTS,
      arguments = listOf(
        navArgument("raceId") {
          type = NavType.IntType
        }
      )
    ) { backStackEntry ->
      backStackEntry.arguments?.getInt("raceId")?.let {id ->
        ResultsScreen(
          viewModel = viewModel,
          navController,
          race = viewModel.racesData[id],
        )
      }
    }
  }
}