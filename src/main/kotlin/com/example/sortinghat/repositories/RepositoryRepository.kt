package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.RepositoryEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface RepositoryRepository : CrudRepository<RepositoryEntity, Long> {
    fun findByUuid(id: String): Optional<RepositoryEntity>
}
