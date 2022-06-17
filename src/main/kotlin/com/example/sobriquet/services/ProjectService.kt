package com.example.sobriquet.services

import com.example.sobriquet.DTOs.ProjectDTO
import com.example.sobriquet.persistance.EngineerEntity
import com.example.sobriquet.persistance.ProjectEntity
import com.example.sobriquet.repositories.EngineerRepository
import com.example.sobriquet.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ProjectService(@Autowired val projectRepository: ProjectRepository, @Autowired val engineerRepository: EngineerRepository) {

    fun getAll() = projectRepository.findAll().map { it.toDTO() }

    fun add(project: ProjectDTO) {
        val engineersEntity = project.engineers.map { EngineerEntity(it.name!!, it.senority, it.teams, it.city, it.country, it.email!!, it.project, it.tags, it.role, it.identities, it.reportsTo, it.status, it.username!!, it.ignorable) }.toMutableList()
        projectRepository.save(ProjectEntity(project.name, project.identities, engineersEntity))
    }

    fun edit(id: String, newProject: ProjectDTO) {
        val project = projectRepository.findByUuid(id).get()
        project.identities = newProject.identities
        project.engineers = newProject.engineers.map { it.toEntity() }.toMutableList()
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
