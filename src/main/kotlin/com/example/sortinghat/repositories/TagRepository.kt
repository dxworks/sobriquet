package com.example.sortinghat.repositories


import com.example.sortinghat.persistance.TagEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TagRepository: CrudRepository<TagEntity, Long>

