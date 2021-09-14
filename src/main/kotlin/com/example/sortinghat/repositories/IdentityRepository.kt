package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.IdentityEntity
import org.springframework.data.repository.CrudRepository
import java.util.*


interface IdentityRepository : CrudRepository<IdentityEntity, Long> {
   fun findByUuid(id: String?): Optional<IdentityEntity>

   fun findByFirstNameAndLastName(firstname: String, lastname: String): List<IdentityEntity>
}
