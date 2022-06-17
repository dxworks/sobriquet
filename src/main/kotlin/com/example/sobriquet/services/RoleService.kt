package com.example.sobriquet.services

import com.example.sobriquet.DTOs.RoleDTO
import com.example.sobriquet.persistance.RoleEntity
import com.example.sobriquet.repositories.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoleService(@Autowired val roleRepository: RoleRepository) {

    fun addRole(role: RoleDTO) = roleRepository.save(RoleEntity(role.name)).toDTO()

    fun getAllRoles() = roleRepository.findAll().map { it.toDTO() }
}
