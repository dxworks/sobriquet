package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.IdentityEntity
import org.springframework.data.repository.CrudRepository


interface IdentityRepository : CrudRepository<IdentityEntity, Long>
