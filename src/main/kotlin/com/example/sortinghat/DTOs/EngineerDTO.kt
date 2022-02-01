package com.example.sortinghat.DTOs


data class EngineerDTO(
        var id: String?,
        var name: String,
        var senority: String,
        var teams: MutableList<String>,
        var city: String,
        var country: String,
        var email: String?,
        var project: String?,
        var tags: MutableList<TagDTO>,
        var identities: MutableList<IdentityDTO>,
        var role: String,
        var reportsTo: String,
        var status: String
)
