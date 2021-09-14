package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.RepositoryDTO
import com.example.sortinghat.services.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class RepositoryController(@Autowired val repositoryService: RepositoryService) {
    @GetMapping("/repositories")
    fun getAll() = repositoryService.getAll()

    @PostMapping("/addRepository")
    fun addRepo(@RequestBody repository: RepositoryDTO) = repositoryService.addRepo(repository)

    @DeleteMapping("/deleteRepository/{id}")
    fun deleteRepo(@PathVariable id: String) = repositoryService.delete(id)
}
