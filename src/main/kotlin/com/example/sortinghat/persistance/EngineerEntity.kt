package com.example.sortinghat.persistance

import com.example.sortinghat.DTOs.AffiliationDTO
import com.example.sortinghat.DTOs.EngineerDTO
import com.example.sortinghat.DTOs.IdentityDTO
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
        var name: String,
        @Column
        var senority: String,
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
        var project: String?,
        @Column
        @ElementCollection
        var tags: MutableList<TagDTO>,
        @Column
        var role: String,
        @Column
        @ElementCollection
        var identities: MutableList<IdentityDTO>,
        @Column
        var reportsTo: String,
        @Column
        var status: String

) : BaseEntity() {
    constructor() : this("", "", mutableListOf(), "", "", "", "",
            mutableListOf(), "", mutableListOf(), "", "")

    fun toDTO() = EngineerDTO(
            id = uuid,
            name = name,
            senority = senority,
            teams = teams,
            city = city,
            country = country,
            email = email,
            project = project,
            tags = tags,
            role = role,
            identities = identities,
            reportsTo = reportsTo,
            status = status
    )
}
