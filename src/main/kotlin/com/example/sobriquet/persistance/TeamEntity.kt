package com.example.sobriquet.persistance

import com.example.sobriquet.DTOs.TeamDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class TeamEntity (
        @Column
        var name: String,

        @Column
        var description: String?
) : BaseEntity() {
    constructor() : this("", "")

    fun toDTO() = TeamDTO(
            id = uuid,
            name = name,
            description = description
    )
}
