package com.example.sobriquet.controllers

import com.example.sobriquet.DTOs.RoleDTO
import com.example.sobriquet.services.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class RoleController(@Autowired val roleService: RoleService) {
    @PostMapping("/addRole")
    fun addRole(@RequestBody role: RoleDTO): RoleDTO = roleService.addRole(role)

    @GetMapping("/roles")
    fun getAllRoles() = roleService.getAllRoles()
}
