package com.uvg.teamapp.data.repository

import com.uvg.teamapp.model.TeamMember

/**
 * Repository que devuelve una lista con los miembros del equipo.
 * Implementa fake data para desarrollo siguiendo Clean Code principles.
 */
class FakeTeamRepository {

    /**
     * Devuelve la lista completa de miembros del equipo.
     *
     * @return Lista de TeamMember con los integrantes del equipo
     */
    fun getAllTeamMembers(): List<TeamMember> {
        return listOf(
            TeamMember(
                name = "Fatima",
                description = "La progra es progra"
            ),
            TeamMember(
                name = "Adrian",
                description = "Le gustan las bananas"
            )
        )
    }

    /**
     * Obtiene el número total de miembros del equipo.
     */
    fun getTeamSize(): Int = getAllTeamMembers().size

    /**
     * Busca un miembro por nombre.
     */
    fun findMemberByName(name: String): TeamMember? {
        return getAllTeamMembers().find { it.name.equals(name, ignoreCase = true) }
    }
}