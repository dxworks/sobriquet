package com.example.sobriquet.repositories


import com.example.sobriquet.persistance.TagEntity
import org.springframework.data.repository.CrudRepository

interface TagRepository: CrudRepository<TagEntity, Long>

