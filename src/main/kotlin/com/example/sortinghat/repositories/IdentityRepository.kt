package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.IdentityEntity
import org.springframework.data.repository.CrudRepository
import java.util.*


interface IdentityRepository : CrudRepository<IdentityEntity, Long> {
   override fun findById(id: Long): Optional<IdentityEntity>

   fun findByUsername(username: String): List<IdentityEntity>

   fun findByFirstNameAndLastName(firstname: String, lastname: String): List<IdentityEntity>

   override fun deleteById(id: Long)
}
