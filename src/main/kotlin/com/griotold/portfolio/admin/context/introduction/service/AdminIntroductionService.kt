package com.griotold.portfolio.admin.context.introduction.service

import com.griotold.portfolio.admin.data.TableDTO
import com.griotold.portfolio.domain.entity.Introduction
import com.griotold.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService (
    private val introductionRepository: IntroductionRepository
){
    fun getIntroductionTable() : TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo,entities)
    }
}