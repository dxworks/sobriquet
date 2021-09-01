package com.example.sortinghat.persistance

import com.example.sortinghat.DTOs.AccountDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class AccountEntity(
        @Column
        var username: String,
        @Column
        var password: String,
        @Column
        var token: String?,

        ) : BaseEntity() {
    constructor() : this("", "", "")

    fun toDTO() = AccountDTO(
            id = uuid,
            username = username,
            password = password,
            token = token
    )
}
