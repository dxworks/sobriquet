package com.example.sobriquet.DTOs

import com.example.sobriquet.persistance.EngineerEntity

data class EngineerDTO(
        var id: Long?,
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
) {
    fun toEntity(): EngineerEntity {
        val entity = EngineerEntity()
        if (id !== null) {
            entity.id = id!!
        }
        entity.name = name
        entity.senority = senority
        entity.teams = teams
        entity.city = city
        entity.country = country
        entity.email = email
        entity.project = project
        entity.tags = tags
        entity.identities = identities
        entity.role = role
        entity.reportsTo = reportsTo
        entity.status = status
        entity.username = username
        entity.ignorable = ignorable
        return entity
    }
}

