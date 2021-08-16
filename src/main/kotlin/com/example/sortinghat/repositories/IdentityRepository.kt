package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.IdentityEntity
import org.springframework.data.repository.CrudRepository


interface IdentityRepository : CrudRepository<IdentityEntity, Long> {
   fun findById(id: String): IdentityEntity?

   fun findByUsername(username: String): List<IdentityEntity>

   fun findByFirstNameAndLastName(firstname: String, lastname: String): List<IdentityEntity>

   fun deleteById(id: String)
}
