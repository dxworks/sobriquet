package com.example.sortinghat.DTOs

data class EngineerDTO(
        var id: String?,
        var name: String?,
        var senority: String = "",
        var teams: MutableList<String> = mutableListOf(),
        var city: String = "",
        var country: String = "",
        var email: String? = "",
        var project: String = "",
        var tags: MutableList<TagDTO> = mutableListOf(),
        var identities: MutableList<IdentityDTO> = mutableListOf(),
        var role: String = "",
        var reportsTo: String = "",
        var status: String = "",
        var username: String? = "",
        var ignorable: Boolean = false
)
