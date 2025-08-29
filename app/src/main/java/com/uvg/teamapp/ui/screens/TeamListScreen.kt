package com.uvg.teamapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.teamapp.R
import com.uvg.teamapp.data.repository.FakeTeamRepository
import com.uvg.teamapp.model.TeamMember

@Composable
fun TeamListScreen(
    onMemberClick: (TeamMember) -> Unit = {},
    repository: FakeTeamRepository = FakeTeamRepository(),
    modifier: Modifier = Modifier
) {
    val teamMembers = remember { repository.getAllTeamMembers() }

    Box(modifier = modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.frutiger),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Overlay for better text readability
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.1f)
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Header()
            Spacer(modifier = Modifier.height(24.dp))
            TeamList(
                members = teamMembers,
                onMemberClick = onMemberClick
            )
        }
    }
}

@Composable
private fun Header() {
    Column {
        Text(
            text = "Nuestro Equipo",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Light,
            color = Color(0xFF1976D2)
        )

        Text(
            text = "Conoce a los miembros de nuestro equipo",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Light,
            color = Color(0xFF424242),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
private fun TeamList(
    members: List<TeamMember>,
    onMemberClick: (TeamMember) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(members) { member ->
            MemberCard(
                member = member,
                onClick = { onMemberClick(member) }
            )
        }
    }
}

@Composable
private fun MemberCard(
    member: TeamMember,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.85f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Small hamsti avatar
            Card(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.9f)
                ),
                elevation = CardDefaults.cardElevation(1.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hamsti),
                    contentDescription = "Avatar de ${member.name}",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = member.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF1976D2)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = member.description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF424242),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
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