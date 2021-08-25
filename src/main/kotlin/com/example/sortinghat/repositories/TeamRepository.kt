package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.IdentityEntity
import com.example.sortinghat.persistance.TeamEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TeamRepository: CrudRepository<TeamEntity, String> {
    override fun findById(id: String): Optional<TeamEntity>

    fun findByName(name: String): List<TeamEntity>

    override fun deleteById(id: String)
}
