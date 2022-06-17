package com.example.sobriquet.repositories

import com.example.sobriquet.persistance.EngineerEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface EngineerRepository : CrudRepository<EngineerEntity, Long> {
    fun findAllByProject(id: String): Optional<List<EngineerEntity>>
}
