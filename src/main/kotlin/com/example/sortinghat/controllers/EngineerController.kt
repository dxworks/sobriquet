package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.EngineerDTO
import com.example.sortinghat.services.EngineerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class EngineerController(@Autowired val engineerService: EngineerService) {
    @GetMapping("/engineers")
    fun getAllEngineers() = engineerService.getAllEngineers()

    @PostMapping("/addEngineer")
    fun addEngineer(@RequestBody engineer: EngineerDTO) = engineerService.addEngineer(engineer)

    @PutMapping("/addTeam/{engineerId}/{teamId}")
    fun assignTeam(@PathVariable engineerId: String, @PathVariable teamId: String) = engineerService.assignEngineerToTeam(engineerId, teamId)

    @PutMapping("/linkAffiliation/{engineerId}/{affiliationId}")
    fun linkAffiliation(@PathVariable engineerId: String, @PathVariable affiliationId: String) = engineerService.linkAffiliation(engineerId, affiliationId)

    @PutMapping("/editEngineer/{engineerId}")
    fun editEngineer(@PathVariable engineerId: String, @RequestBody engineer: EngineerDTO) = engineerService.edit(engineerId, engineer)

    @DeleteMapping("deleteEngineer/{id}")
    fun deleteEngineer(@PathVariable id: String) = engineerService.delete(id)

}
