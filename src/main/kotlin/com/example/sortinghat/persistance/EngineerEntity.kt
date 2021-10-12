package com.example.sortinghat.persistance

import com.example.sortinghat.DTOs.AffiliationDTO
import com.example.sortinghat.DTOs.EngineerDTO
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
        var phone: String,
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
        @ElementCollection
        var projects: MutableList<String>
) : BaseEntity() {
    constructor() : this("", "", "", mutableListOf(""),"", "", "", "", mutableListOf(), mutableListOf())

    fun toDTO() = EngineerDTO(
            id = uuid,
            firstName = firstName,
            lastName = lastName,
            position = position,
            teams = teams,
            phone = phone,
            city = city,
            country = country,
            email = email,
            affiliations = affiliations,
            projects = projects
    )
}
