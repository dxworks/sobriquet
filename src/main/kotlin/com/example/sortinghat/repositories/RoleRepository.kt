package com.example.sortinghat.repositories


import com.example.sortinghat.persistance.RoleEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface RoleRepository: CrudRepository<RoleEntity, Long> {
    fun findByName(name: String): Optional<RoleEntity>
}

