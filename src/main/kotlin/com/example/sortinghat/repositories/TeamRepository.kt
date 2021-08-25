package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.TeamEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TeamRepository: CrudRepository<TeamEntity, Long> {
    fun findByUuid(id: String): Optional<TeamEntity>
}
