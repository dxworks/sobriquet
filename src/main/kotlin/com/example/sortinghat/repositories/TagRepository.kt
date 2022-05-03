package com.example.sortinghat.repositories


import com.example.sortinghat.persistance.TagEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository: JpaRepository<TagEntity, Long>

