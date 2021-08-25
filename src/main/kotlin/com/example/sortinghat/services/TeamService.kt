package com.example.sortinghat.services

import com.example.sortinghat.DTOs.TeamDTO
import com.example.sortinghat.persistance.TeamEntity
import com.example.sortinghat.repositories.TeamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TeamService(@Autowired val teamRepository: TeamRepository) {

    fun addTeam(team: TeamDTO) = teamRepository.save(TeamEntity(team.name, team.description)).toDTO()

    fun getAllTeams() = teamRepository.findAll().map { it.toDTO() }

    @Transactional
    fun delete(id: String) =
            teamRepository.findById(id)
                    ?.let { teamRepository.delete(it.get()) }
                    ?: throw NoSuchElementException(id)
}
