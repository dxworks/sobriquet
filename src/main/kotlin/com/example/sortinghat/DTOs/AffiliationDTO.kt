package com.example.sortinghat.DTOs

import javax.persistence.Embeddable

@Embeddable
data class AffiliationDTO (
        var id: String?,
        var institution: String,
        var since: String,
        var until: String
) {
    constructor() : this("","", "", "")
}
