package com.example.sortinghat.persistance

import com.example.sortinghat.DTOs.EngineerDTO
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
class EngineerEntity (
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
    var country: String
) : BaseEntity() {
    constructor() : this("", "", "", mutableListOf(""),"", "", "")

    fun toDTO() = EngineerDTO(
            id = uuid,
            firstName = firstName,
            lastName = lastName,
            position = position,
            teams = teams,
            phone = phone,
            city = city,
            country = country
    )
}
