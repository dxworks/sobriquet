package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.AffiliationEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface AffiliationRepository: CrudRepository<AffiliationEntity, Long> {
    fun findByUuid(id: String): Optional<AffiliationEntity>
}
