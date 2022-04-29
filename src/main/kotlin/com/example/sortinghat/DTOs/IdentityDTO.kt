package com.example.sortinghat.DTOs

import javax.persistence.Embeddable

@Embeddable
data class IdentityDTO(
    var id: String?,
    var username: String?,
    var email: String?,
    var avatar: String?,
    var firstName: String?,
    var lastName: String?,
    var source: String?
) {
    constructor() : this("", "", "", "", "", "", "")
}
