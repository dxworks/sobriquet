package com.example.sobriquet.persistance

import com.example.sobriquet.DTOs.IdentityDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class IdentityEntity(
        @Column
        var username: String,

        @Column
        var email: String,

        @Column
        var avatar: String,

        @Column
        var firstName: String,

        @Column
        var lastName: String,

        @Column
        var source: String?
) : BaseEntity() {
    constructor() : this("", "", "", "", "", "")

    fun toDTO() = IdentityDTO(
            id = uuid,
            username = username,
            email = email,
            avatar = avatar,
            firstName = firstName,
            lastName = lastName,
            source = source
    )
}

