package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.EngineerEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface EngineerRepository: CrudRepository<EngineerEntity, Long> {
    fun findByUuid(id: String): Optional<EngineerEntity>

    fun findByProject(id: String): Optional<EngineerEntity>

}
