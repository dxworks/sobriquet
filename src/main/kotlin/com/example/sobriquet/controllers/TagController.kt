package com.example.sobriquet.controllers

import com.example.sobriquet.DTOs.TagDTO
import com.example.sobriquet.services.TagService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TagController(@Autowired val tagService: TagService) {
    @PostMapping("/addTag")
    fun addTag(@RequestBody tag: TagDTO): TagDTO = tagService.addTag(tag)

    @GetMapping("/tags")
    fun getAllTags() = tagService.getAllTags()
}
