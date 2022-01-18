package com.example.sortinghat.services

import com.example.sortinghat.DTOs.EngineerDTO
import com.example.sortinghat.persistance.EngineerEntity
import com.example.sortinghat.repositories.AffiliationRepository
import com.example.sortinghat.repositories.EngineerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class EngineerService(@Autowired val engineerRepository: EngineerRepository, @Autowired val affiliationRepository: AffiliationRepository) {

    fun getAllEngineers() = engineerRepository.findAll().map { it.toDTO() }

    fun addEngineer(engineer: EngineerDTO) = engineerRepository.save(EngineerEntity(engineer.firstName, engineer.lastName, engineer.position, engineer.teams, engineer.city, engineer.country, engineer.email, engineer.affiliations, engineer.project, engineer.tags, engineer.role, engineer.identities)).toDTO()

    fun assignEngineerToTeam(engineerId: String, teamId: String) {
        val engineer = engineerRepository.findByUuid(engineerId).get()
        engineer.toDTO().teams.add(teamId)
        engineerRepository.save(engineer).toDTO()
    }

    fun removeTeam(id: String) = engineerRepository.findAll().forEach { it.toDTO().teams.remove(id) }

    fun linkAffiliation(engineerId: String, affiliationId: String) {
        val engineer = engineerRepository.findByUuid(engineerId).get()
        val affiliation = affiliationRepository.findByUuid(affiliationId).get()
        engineer.toDTO().affiliations.add(affiliation.toDTO())
        engineerRepository.save(engineer).toDTO()
    }

    fun edit(engineerId: String, engineer: EngineerDTO) {
        val repoEngineer = engineerRepository.findByUuid(engineerId).get()
        repoEngineer.position = engineer.position
        repoEngineer.city = engineer.city
        repoEngineer.country = engineer.country
        repoEngineer.tags = engineer.tags
        repoEngineer.role = engineer.role
        repoEngineer.email = engineer.email
        repoEngineer.identities = engineer.identities
        engineerRepository.save(repoEngineer).toDTO()
    }

    @Transactional
    fun delete(id: String)  = engineerRepository.findByUuid(id).let { engineerRepository.delete(it.get()) }
}
