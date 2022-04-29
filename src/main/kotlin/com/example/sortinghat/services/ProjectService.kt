package com.example.sortinghat.services

import com.example.sortinghat.DTOs.IdentityDTO
import com.example.sortinghat.persistance.ProjectEntity
import com.example.sortinghat.repositories.EngineerRepository
import com.example.sortinghat.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ProjectService(@Autowired val projectRepository: ProjectRepository, @Autowired val engineerRepository: EngineerRepository) {

    fun getAll() = projectRepository.findAll().map { it.toDTO() }

    fun getByName(name: String) = projectRepository.findByName(name).get().toDTO()

    fun add(name: String, identities: MutableList<IdentityDTO>) = projectRepository.save(ProjectEntity(name, identities))

    fun edit(id: String, identities: MutableList<IdentityDTO>) {
        val project = projectRepository.findByUuid(id).get()
        project.identities = identities
        projectRepository.save(project).toDTO()
    }

    @Transactional
    fun delete(id: String) {
        if (engineerRepository.findAllByProject(id).isPresent) {
            engineerRepository.findAllByProject(id).let { engineerRepository.deleteAll(it.get()) }
        }
        projectRepository.findByUuid(id).let { projectRepository.delete(it.get()) }
    }
}
