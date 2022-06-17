package com.example.sobriquet.services

import com.example.sobriquet.DTOs.TagDTO
import com.example.sobriquet.persistance.TagEntity
import com.example.sobriquet.repositories.TagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class TagService(@Autowired val tagRepository: TagRepository) {

    fun addTag(tag: TagDTO) = tagRepository.save(TagEntity(tag.name)).toDTO()

    fun getAllTags() = tagRepository.findAll().map { it.toDTO() }
}
