package com.uvg.teamapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvg.teamapp.data.repository.FakeTeamRepository
import com.uvg.teamapp.ui.screens.TeamDetailScreen
import com.uvg.teamapp.ui.screens.TeamListScreen

@Preview
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    repository: FakeTeamRepository = FakeTeamRepository()
) {
    NavHost(
        navController = navController,
        startDestination = "team_list",
        modifier = modifier
    ) {
        composable("team_list") {
            TeamListScreen(
                onMemberClick = { member ->
                    navController.navigate("team_detail/${member.name}")
                },
                repository = repository
            )
        }

        composable("team_detail/{memberName}") { backStackEntry ->
            val memberName = backStackEntry.arguments?.getString("memberName") ?: ""
            val member = repository.findMemberByName(memberName)

            member?.let {
                TeamDetailScreen(
                    member = it,
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    }
}