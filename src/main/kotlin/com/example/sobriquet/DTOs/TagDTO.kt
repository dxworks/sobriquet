package com.example.sobriquet.DTOs

import javax.persistence.Embeddable

@Embeddable
class TagDTO (
        var name: String
){
    constructor() : this("")
}

