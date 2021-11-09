package com.example.sortinghat.services

import com.example.sortinghat.DTOs.TagDTO
import com.example.sortinghat.persistance.TagEntity
import com.example.sortinghat.repositories.TagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class TagService(@Autowired val tagRepository: TagRepository) {

    fun addTag(tag: TagDTO) = tagRepository.save(TagEntity(tag.name)).toDTO()

    fun getAllTags() = tagRepository.findAll().map { it.toDTO() }
}
