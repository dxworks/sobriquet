package com.example.sortinghat.repositories


import com.example.sortinghat.persistance.RoleEntity
import org.springframework.data.repository.CrudRepository

interface RoleRepository: CrudRepository<RoleEntity, Long>

