package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.ProjectEntity
import org.springframework.data.repository.CrudRepository
import java.util.*


interface  ProjectRepository : CrudRepository<ProjectEntity, Long>{
    fun findByUuid(id: String): Optional<ProjectEntity>

    fun findByName(name: String): Optional<ProjectEntity>
}
