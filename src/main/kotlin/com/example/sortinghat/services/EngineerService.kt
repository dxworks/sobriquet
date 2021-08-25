package com.example.sortinghat.services

import com.example.sortinghat.DTOs.EngineerDTO
import com.example.sortinghat.persistance.EngineerEntity
import com.example.sortinghat.repositories.EngineerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class EngineerService(@Autowired val engineerRepository: EngineerRepository) {

    fun getAllEngineers() = engineerRepository.findAll().map { it.toDTO() }

    fun addEngineer(engineer: EngineerDTO) = engineerRepository.save(EngineerEntity(engineer.firstName, engineer.lastName, engineer.position, engineer.teams, engineer.phone, engineer.city, engineer.country)).toDTO()

    fun assignEngineerToTeam(engineerId: String, teamId: String) {
        val engineer = engineerRepository.findByUuid(engineerId).get()
        engineer.toDTO().teams.add(teamId)
        engineerRepository.save(engineer).toDTO()
    }

    @Transactional
    fun delete(id: String) =
            engineerRepository.findByUuid(id)
                    ?.let { engineerRepository.delete(it.get()) }
                    ?: throw NoSuchElementException(id)
}
