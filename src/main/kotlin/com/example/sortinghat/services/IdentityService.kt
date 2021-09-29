package com.example.sortinghat.services

import com.example.sortinghat.DTOs.IdentityDTO
import com.example.sortinghat.persistance.IdentityEntity
import com.example.sortinghat.repositories.IdentityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class IdentityService(@Autowired val identityRepository: IdentityRepository){
    fun addIdentity(identity: IdentityDTO) = identityRepository.save(IdentityEntity(identity.username, identity.email, identity.avatar, identity.firstName, identity.lastName, identity.source)).toDTO()

    fun getAllIdentities() = identityRepository.findAll().map { it.toDTO() }

    fun getAllIdentitiesForFullName(firstName: String, lastName: String) = identityRepository.findByFirstNameAndLastName(firstName, lastName).map { it.toDTO() }

    fun edit(identity: IdentityDTO) {
       var identityVar = identityRepository.findByUuid(identity.id).get()
        identityVar.avatar = identity.avatar
        identityVar.email = identity.email
        identityVar.firstName = identity.firstName
        identityVar.lastName = identity.lastName
        identityVar.username = identity.username
        identityRepository.save(identityVar).toDTO()
    }

    @Transactional
    fun delete(id: String) =
            identityRepository.findByUuid(id).get()
                    ?.let { identityRepository.delete(it) }
                    ?: throw NoSuchElementException(id)
}
