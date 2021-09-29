package com.example.sortinghat.persistance

import com.example.sortinghat.DTOs.IdentityDTO
import com.example.sortinghat.DTOs.ProjectDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class ProjectEntity(
        @Column
        var name: String,

        @Column
        @ElementCollection
        var identities: MutableList<IdentityDTO>

) : BaseEntity() {
    constructor() : this("", mutableListOf())

    fun toDTO() = ProjectDTO(
            name = name,
            identities = identities
    )
}
