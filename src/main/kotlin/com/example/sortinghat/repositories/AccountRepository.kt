package com.example.sortinghat.repositories

import com.example.sortinghat.persistance.AccountEntity
import org.springframework.data.repository.CrudRepository
import java.util.*


interface AccountRepository: CrudRepository<AccountEntity, Long> {
    fun findByUsername(username: String): Optional<AccountEntity>
}
