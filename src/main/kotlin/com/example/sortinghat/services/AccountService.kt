package com.example.sortinghat.services

import com.example.sortinghat.persistance.AccountEntity
import com.example.sortinghat.repositories.AccountRepository
import com.example.sortinghat.utils.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import java.util.*


@Service
class AccountService(@Autowired val accountRepository: AccountRepository, @Autowired private val jwtUtil: JWTUtil) {

    fun login(username: String, password: String): HashMap<Any, Any> {
        val token = jwtUtil.createToken(username)
        val model = HashMap<Any, Any>()
        model["username"] = username
        model["token"] = token
        return model
    }

    fun registerUser(username: String, password: String) {
       if (accountRepository.findByUsername(username).isEmpty)
           accountRepository.save(AccountEntity(username, BCrypt.hashpw(password, BCrypt.gensalt()), UUID.randomUUID().toString())).toDTO()
    }

    fun getAll() = accountRepository.findAll()
}
