package com.example.sobriquet.persistance

import com.example.sobriquet.DTOs.TagDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class TagEntity (
        @Column
        var name: String
) : BaseEntity() {
    constructor() : this("")

    fun toDTO() = TagDTO(
            name = name
    )
}
