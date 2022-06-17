package com.example.sobriquet.repositories

import com.example.sobriquet.persistance.IdentityEntity
import org.springframework.data.repository.CrudRepository


interface IdentityRepository : CrudRepository<IdentityEntity, Long>
