package com.example.sortinghat.DTOs

data class EngineerDTO(
        var id: String?,
        var firstName: String,
        var lastName: String,
        var position: String,
        var teams: MutableList<String>,
        var phone: String,
        var city: String,
        var country: String,
        var email: String?,
        var affiliations: MutableList<AffiliationDTO>,
        var projects: MutableList<String>
)
