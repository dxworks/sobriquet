package com.example.sortinghat.services

import com.example.sortinghat.DTOs.AffiliationDTO
import com.example.sortinghat.persistance.AffiliationEntity
import com.example.sortinghat.repositories.AffiliationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AffiliationService(@Autowired val affiliationRepository: AffiliationRepository) {
    fun getAffiliation(id: String) = affiliationRepository.findByUuid(id).map { it.toDTO() }

    fun addAffiliation(affiliationDTO: AffiliationDTO) = affiliationRepository.save(AffiliationEntity(affiliationDTO.institution, affiliationDTO.since, affiliationDTO.until)).toDTO()
}
