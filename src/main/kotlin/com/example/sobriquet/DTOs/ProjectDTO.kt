package com.example.sobriquet.DTOs

class ProjectDTO (
        var id: String?,
        var name: String,
        var identities: MutableList<IdentityDTO>,
        var engineers: MutableList<EngineerDTO>

)
