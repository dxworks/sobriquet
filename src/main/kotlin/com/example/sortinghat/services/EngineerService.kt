package com.example.sortinghat.services

import com.example.sortinghat.DTOs.EngineerDTO
import com.example.sortinghat.persistance.EngineerEntity
import com.example.sortinghat.repositories.EngineerRepository
import com.example.sortinghat.repositories.TeamRepository
import org.apache.el.lang.ELArithmetic.add
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EngineerService(@Autowired val engineerRepository: EngineerRepository, @Autowired val teamRepository: TeamRepository) {

    fun getAllEngineers() = engineerRepository.findAll().map { it.toDTO() }

    fun addEngineer(engineer: EngineerDTO) = engineerRepository.save(EngineerEntity(engineer.firstName, engineer.lastName, engineer.position, engineer.teams, engineer.phone, engineer.city, engineer.country)).toDTO()

    fun assignEngineerToTeam(engineerId: String, teamId: String) = add(engineerRepository.findById(engineerId).get().teams, teamId)
}
