package com.uvg.teamapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.teamapp.data.repository.FakeTeamRepository
import com.uvg.teamapp.model.TeamMember

/**
 * Composable que muestra la lista de miembros usando LazyColumn.
 *
 */
@Composable
fun TeamListScreen(
    onMemberClick: (TeamMember) -> Unit = {},
    repository: FakeTeamRepository = FakeTeamRepository(),
    modifier: Modifier = Modifier
) {
    val teamMembers = remember { repository.getAllTeamMembers() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TeamListHeader()
        Spacer(modifier = Modifier.height(16.dp))
        TeamMembersLazyColumn(
            members = teamMembers,
            onMemberClick = onMemberClick
        )
    }
}

@Composable
private fun TeamListHeader() {
    Text(
        text = "Nuestro Equipo",
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
    Text(
        text = "Conoce a los miembros de nuestro equipo de desarrollo",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(top = 4.dp)
    )
}

@Composable
private fun TeamMembersLazyColumn(
    members: List<TeamMember>,
    onMemberClick: (TeamMember) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(members) { member ->
            TeamMemberCard(
                member = member,
                onClick = { onMemberClick(member) }
            )
        }
    }
}

@Composable
private fun TeamMemberCard(
    member: TeamMember,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = member.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = member.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamListScreenPreview() {
    MaterialTheme {
        TeamListScreen()
    }
}