package com.example.sobriquet.repositories

import com.example.sobriquet.persistance.ProjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface  ProjectRepository : JpaRepository<ProjectEntity, Long>{
    fun findByUuid(id: String): Optional<ProjectEntity>

}
