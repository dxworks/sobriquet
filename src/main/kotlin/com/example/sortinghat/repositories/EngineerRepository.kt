package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.EngineerEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface EngineerRepository: CrudRepository<EngineerEntity, String> {
    override fun findById(id: String): Optional<EngineerEntity>

    override fun deleteById(id: String)

}
