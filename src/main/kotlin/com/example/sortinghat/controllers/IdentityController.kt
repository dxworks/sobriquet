package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.IdentityDTO
import com.example.sortinghat.services.IdentityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/identity")
class IdentityController(@Autowired val identityService: IdentityService) {
    @PostMapping
    fun addIdentity(@RequestBody identity: IdentityDTO): IdentityDTO = identityService.addIdentity(identity)

    @GetMapping
    fun getAllIdentities() = identityService.getAllIdentities()

    @GetMapping("/{firstName}/{lastName}")
    fun getIdentitiesByFullName(@PathVariable firstname: String, @PathVariable lastname: String) = identityService.getAllIdentitiesForFullName(firstname, lastname)
}
