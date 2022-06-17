package com.example.sobriquet.repositories


import com.example.sobriquet.persistance.RoleEntity
import org.springframework.data.repository.CrudRepository

interface RoleRepository: CrudRepository<RoleEntity, Long>

