package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.IdentityDTO
import com.example.sortinghat.services.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
class ProjectController(@Autowired val projectService: ProjectService) {

    @GetMapping("/projects")
    fun getAll() = projectService.getAll()

    @PostMapping("/addProject/{name}")
    fun addProject(@PathVariable name: String, @RequestBody identities: MutableList<IdentityDTO>) = projectService.add(name, identities)

    @DeleteMapping("deleteProject/{name}")
    fun deleteEngineer(@PathVariable name: String) = projectService.delete(name)
}
