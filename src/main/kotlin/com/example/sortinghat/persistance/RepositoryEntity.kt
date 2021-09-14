package com.example.sortinghat.persistance

import com.example.sortinghat.DTOs.RepositoryDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class RepositoryEntity (
        @Column
        var name: String,

        @Column
        var owner: String,
) : BaseEntity() {
    constructor() : this("", "",)

    fun toDTO() = RepositoryDTO(
            id = uuid,
            name = name,
            owner = owner
    )
}
