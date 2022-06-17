package com.example.sobriquet.persistance

import com.example.sobriquet.DTOs.IdentityDTO
import com.example.sobriquet.DTOs.ProjectDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class ProjectEntity(
        @Column
        var name: String,

        @Column
        @ElementCollection
        var identities: MutableList<IdentityDTO>,
        @Column
        @OneToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "engineers")
        var engineers: MutableList<EngineerEntity>

) : BaseEntity() {
    constructor() : this("", mutableListOf(), mutableListOf())

    fun toDTO() = ProjectDTO(
            id = uuid,
            name = name,
            identities = identities,
            engineers = engineers.map { it.toDTO() }.toMutableList()
    )
}
