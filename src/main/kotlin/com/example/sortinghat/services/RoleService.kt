package com.example.sortinghat.services

import com.example.sortinghat.DTOs.RoleDTO
import com.example.sortinghat.persistance.RoleEntity
import com.example.sortinghat.repositories.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoleService(@Autowired val roleRepository: RoleRepository) {

    fun addRole(role: RoleDTO) = roleRepository.save(RoleEntity(role.name)).toDTO()

    fun getAllRoles() = roleRepository.findAll().map { it.toDTO() }
}
