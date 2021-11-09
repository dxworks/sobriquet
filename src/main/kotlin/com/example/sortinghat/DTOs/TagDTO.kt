package com.example.sortinghat.DTOs

import javax.persistence.Embeddable

@Embeddable
class TagDTO (
        var name: String
){
    constructor() : this("")
}

