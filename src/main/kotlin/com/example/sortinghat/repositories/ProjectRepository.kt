package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.ProjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface  ProjectRepository : JpaRepository<ProjectEntity, Long>{
    fun findByUuid(id: String): Optional<ProjectEntity>

    fun findByName(name: String): Optional<ProjectEntity>
}
