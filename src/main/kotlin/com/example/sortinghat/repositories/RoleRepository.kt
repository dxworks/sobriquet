package com.example.sortinghat.repositories


import com.example.sortinghat.persistance.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<RoleEntity, Long>

