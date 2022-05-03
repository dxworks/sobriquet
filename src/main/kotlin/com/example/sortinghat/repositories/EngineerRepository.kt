package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.EngineerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EngineerRepository: JpaRepository<EngineerEntity, Long> {
    fun findByUuid(id: String): Optional<EngineerEntity>

    fun findAllByProject(id: String): Optional<MutableList<EngineerEntity>>

}
