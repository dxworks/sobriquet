package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.EngineerDTO
import com.example.sortinghat.services.EngineerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class EngineerController(@Autowired val engineerService: EngineerService) {
    @GetMapping("/engineers")
    fun getAllEngineers() = engineerService.getAllEngineers()

    @GetMapping("/engineers/{pageIndex}/{pageSize}/{projectID}")
    fun getEngineersByPage(@PathVariable pageIndex: Int, @PathVariable pageSize: Int, @PathVariable projectID: String) = engineerService.getEngineersByPage(pageIndex, pageSize, projectID)

    @PostMapping("/addEngineer")
    fun addEngineer(@RequestBody engineer: EngineerDTO) = engineerService.addEngineer(engineer)

    @PostMapping("/addEngineers")
    fun addEngineers(@RequestBody engineers: MutableList<EngineerDTO>) = engineerService.addEngineers(engineers)

    @PutMapping("/addTeam/{engineerId}/{teamId}")
    fun assignTeam(@PathVariable engineerId: String, @PathVariable teamId: String) = engineerService.assignEngineerToTeam(engineerId, teamId)

    @PutMapping("/editEngineer/{engineerId}")
    fun editEngineer(@PathVariable engineerId: String, @RequestBody engineer: EngineerDTO) = engineerService.edit(engineerId, engineer)

    @DeleteMapping("deleteEngineer/{id}")
    fun deleteEngineer(@PathVariable id: String) = engineerService.delete(id)

}
