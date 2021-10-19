package com.example.sortinghat.services

import com.example.sortinghat.DTOs.IdentityDTO
import com.example.sortinghat.persistance.ProjectEntity
import com.example.sortinghat.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService(@Autowired val projectRepository: ProjectRepository) {

    fun getAll() = projectRepository.findAll().map { it.toDTO() }

    fun add(name: String, identities: MutableList<IdentityDTO>) = projectRepository.save(ProjectEntity(name, identities))
}
