package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.EngineerEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface EngineerRepository : CrudRepository<EngineerEntity, Long> {
    fun findAllByProject(id: String): Optional<List<EngineerEntity>>
}
