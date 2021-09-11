package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.AffiliationDTO
import com.example.sortinghat.services.AffiliationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class AffiliationController(@Autowired val affiliationService: AffiliationService) {

    @GetMapping("affiliation/{id}")
    fun getById(@PathVariable id: String) = affiliationService.getAffiliation(id)

    @PostMapping("addAffiliation")
    fun addAffiliation(@RequestBody affiliationDTO: AffiliationDTO) = affiliationService.addAffiliation(affiliationDTO)
}
