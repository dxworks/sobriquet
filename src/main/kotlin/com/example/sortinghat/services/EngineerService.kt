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

    fun getAllEngineersByProject(projectID: String) = engineerRepository.findAllByProject(projectID).get().map { it.toDTO() }

    fun addEngineer(engineer: EngineerDTO) = engineerRepository.save(EngineerEntity(engineer.name, engineer.senority, engineer.teams, engineer.city, engineer.country, engineer.email, engineer.project, engineer.tags, engineer.role, engineer.identities, engineer.reportsTo, engineer.status, engineer.username, engineer.ignorable)).toDTO()

    fun addEngineers(engineers: MutableList<EngineerDTO>) = engineers.forEach { engineer -> engineerRepository.save(EngineerEntity(engineer.name, engineer.senority, engineer.teams, engineer.city, engineer.country, engineer.email, engineer.project, engineer.tags, engineer.role, engineer.identities, engineer.reportsTo, engineer.status, engineer.username, engineer.ignorable)).toDTO() }

    fun assignEngineerToTeam(engineerId: String, teamId: String) {
        val engineer = engineerRepository.findByUuid(engineerId).get()
        engineer.toDTO().teams.add(teamId)
        engineerRepository.save(engineer).toDTO()
    }

    fun removeTeam(id: String) = engineerRepository.findAll().forEach { it.toDTO().teams.remove(id) }

    fun edit(engineerId: String, engineer: EngineerDTO) {
        val repoEngineer = engineerRepository.findByUuid(engineerId).get()
        repoEngineer.senority = engineer.senority
        repoEngineer.city = engineer.city
        repoEngineer.country = engineer.country
        repoEngineer.tags = engineer.tags
        repoEngineer.role = engineer.role
        repoEngineer.email = engineer.email
        repoEngineer.identities = engineer.identities
        repoEngineer.reportsTo = engineer.reportsTo
        repoEngineer.status = engineer.status
        repoEngineer.name = engineer.name
        repoEngineer.teams = engineer.teams
        repoEngineer.username = engineer.username
        repoEngineer.ignorable = engineer.ignorable
        engineerRepository.save(repoEngineer).toDTO()
    }

    @Transactional
    fun delete(id: String) = engineerRepository.findByUuid(id).let { engineerRepository.delete(it.get()) }
}
