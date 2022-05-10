package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.ProjectDTO
import com.example.sortinghat.services.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
class ProjectController(@Autowired val projectService: ProjectService) {

    @GetMapping("/projects")
    fun getAll() = projectService.getAll()

    @PostMapping("/addProject")
    fun addProject(@RequestBody project: ProjectDTO) = projectService.add(project)

    @PutMapping("/editProject/{id}")
    fun editProject(@PathVariable id: String, @RequestBody project: ProjectDTO) = projectService.edit(id, project)

    @DeleteMapping("deleteProject/{id}")
    fun deleteProject(@PathVariable id: String) = projectService.delete(id)
}
