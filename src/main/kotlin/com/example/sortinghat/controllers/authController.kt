package com.example.sortinghat.controllers

import com.example.sortinghat.DTOs.AccountDTO
import com.example.sortinghat.services.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class AuthenticationController(@Autowired val accountService: AccountService) {

    @PostMapping("/api/login")
    fun login(@RequestBody data: AccountDTO): ResponseEntity<*> {
        val model = accountService.login(data.username, data.password)
        return ResponseEntity.ok(model)
    }

    @PostMapping("/api/register")
    fun registerUser(@RequestBody userData: AccountDTO) = accountService.registerUser(userData.username, userData.password)

    @GetMapping("/api/accounts")
    fun getAllAccounts()  = accountService.getAll()
}
