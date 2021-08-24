package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.IdentityDTO
import com.example.sortinghat.services.IdentityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class IdentityController(@Autowired val identityService: IdentityService) {

    @PostMapping("/identity")
    fun addIdentity(@RequestBody identity: IdentityDTO): IdentityDTO = identityService.addIdentity(identity)

    @GetMapping("/getAllIdentities")
    fun getAllIdentities() = identityService.getAllIdentities()

    @GetMapping("/identity/{firstName}/{lastName}")
    fun getIdentitiesByFullName(@PathVariable firstName: String, @PathVariable lastName: String) = identityService.getAllIdentitiesForFullName(firstName, lastName)

    @DeleteMapping("/deleteIdentity/{id}")
    fun deleteIdentity(@PathVariable id: String): ResponseEntity<Any> {
        return try {
            identityService.delete(id)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } catch (e: NoSuchElementException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
