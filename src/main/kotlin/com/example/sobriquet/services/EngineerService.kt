package com.example.sobriquet.services

import com.example.sobriquet.repositories.EngineerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EngineerService(@Autowired val engineerRepository: EngineerRepository) {

    fun removeTeam(id: String) = engineerRepository.findAll().forEach { it.toDTO().teams.remove(id) }

}
