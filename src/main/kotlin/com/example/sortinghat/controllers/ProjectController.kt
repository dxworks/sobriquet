package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.IdentityDTO
import com.example.sortinghat.services.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
class ProjectController(@Autowired val projectService: ProjectService) {

    @GetMapping("/projects")
    fun getAll() = projectService.getAll()

    @GetMapping("/project/{name}")
    fun getByName(@PathVariable name: String) = projectService.getById(name)

    @PostMapping("/addProject/{name}")
    fun addProject(@PathVariable name: String, @RequestBody identities: MutableList<IdentityDTO>) = projectService.add(name, identities)

    @PutMapping("/editProject/{id}")
    fun editProject(@PathVariable id: String, @RequestBody identities: MutableList<IdentityDTO>) = projectService.edit(id, identities)

    @DeleteMapping("deleteProject/{id}")
    fun deleteProject(@PathVariable id: String) = projectService.delete(id)
}
