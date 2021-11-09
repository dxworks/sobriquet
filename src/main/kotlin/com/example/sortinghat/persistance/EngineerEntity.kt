package com.example.sortinghat.persistance

import com.example.sortinghat.DTOs.AffiliationDTO
import com.example.sortinghat.DTOs.EngineerDTO
import com.example.sortinghat.DTOs.TagDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class EngineerEntity(
        @Column
        var firstName: String,
        @Column
        var lastName: String,
        @Column
        var position: String,
        @Column
        @ElementCollection
        var teams: MutableList<String>,
        @Column
        var city: String,
        @Column
        var country: String,
        @Column
        var email: String?,
        @Column
        @ElementCollection
        var affiliations: MutableList<AffiliationDTO>,
        @Column
        var project: String?,
        @Column
        @ElementCollection
        var tags: MutableList<TagDTO>,
        @Column
        var role: String
) : BaseEntity() {
    constructor() : this("", "", "", mutableListOf(), "", "", "", mutableListOf(), "", mutableListOf(), "")

    fun toDTO() = EngineerDTO(
            id = uuid,
            firstName = firstName,
            lastName = lastName,
            position = position,
            teams = teams,
            city = city,
            country = country,
            email = email,
            affiliations = affiliations,
            project = project,
            tags = tags,
            role = role
    )
}
