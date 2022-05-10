package com.example.sortinghat.DTOs

class ProjectDTO (
        var id: String?,
        var name: String,
        var identities: MutableList<IdentityDTO>,
        var engineers: MutableList<EngineerDTO>

)
