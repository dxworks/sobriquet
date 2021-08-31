package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.TeamDTO
import com.example.sortinghat.services.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TeamController(@Autowired val teamService: TeamService) {
    @PostMapping("/addTeam")
    fun addTeam(@RequestBody team: TeamDTO): TeamDTO = teamService.addTeam(team)

    @GetMapping("/teams")
    fun getAllTeams() = teamService.getAllTeams()

    @DeleteMapping("/deleteTeam/{id}")
    fun deleteTeam(@PathVariable id: String): ResponseEntity<Any> {
        return try {
            teamService.delete(id)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } catch (e: NoSuchElementException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
