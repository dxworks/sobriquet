package com.example.sortinghat.persistance

import com.example.sortinghat.DTOs.AffiliationDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class AffiliationEntity(
        @Column
        var institution: String,

        @Column
        var since: String,

        @Column
        var until: String
) : BaseEntity() {
    constructor() : this("", "", "")

    fun toDTO() = AffiliationDTO(
            id = uuid,
            institution = institution,
            since = since,
            until = until
    )
}
