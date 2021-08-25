package com.example.sortinghat.DTOs

data class EngineerDTO(
        var id: String?,
        var firstName: String,
        var lastName: String,
        var position: String,
        var teams: List<String>,
        var phone: String,
        var city: String,
        var country: String
)
