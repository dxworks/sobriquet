package com.example.sortinghat.services

import com.example.sortinghat.DTOs.RepositoryDTO
import com.example.sortinghat.persistance.RepositoryEntity
import com.example.sortinghat.repositories.RepositoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class RepositoryService(@Autowired val repository: RepositoryRepository) {

    fun getAll() = repository.findAll().map { it.toDTO() }

    fun addRepo(repo: RepositoryDTO) = repository.save(RepositoryEntity(repo.name, repo.owner)).toDTO()

    @Transactional
    fun delete(id: String) =
            repository.findByUuid(id)
                    ?.let { repository.delete(it.get()) }
}
