package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.EngineerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EngineerRepository : CrudRepository<EngineerEntity, Long> {
    fun findAllByProject(id: String): Optional<List<EngineerEntity>>
}
