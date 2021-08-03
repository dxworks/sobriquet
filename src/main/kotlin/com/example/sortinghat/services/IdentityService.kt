package com.example.sortinghat.services

import com.example.sortinghat.DTOs.IdentityDTO
import com.example.sortinghat.persistance.IdentityEntity
import com.example.sortinghat.repositories.IdentityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IdentityService(@Autowired val identityRepository: IdentityRepository){
    fun addIdentity(identity: IdentityDTO) = identityRepository.save(IdentityEntity(identity.username, identity.email, identity.avatar, identity.firstName, identity.lastName)).toDTO()

    fun getAllIdentities() = identityRepository.findAll().forEach { it.toDTO() }

    fun getAllIdentitiesForFullName(firstName: String, lastName: String) = identityRepository.findByFirstNameAndLastName(firstName, lastName).forEach { it.toDTO() }
}
