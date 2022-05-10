package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.TeamEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TeamRepository: JpaRepository<TeamEntity, Long> {
    fun findByUuid(id: String): Optional<TeamEntity>
}
