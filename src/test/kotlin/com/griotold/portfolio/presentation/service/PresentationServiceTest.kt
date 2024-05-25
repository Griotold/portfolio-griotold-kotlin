package com.griotold.portfolio.presentation.service

import com.griotold.portfolio.domain.entity.Introduction
import com.griotold.portfolio.domain.entity.Link
import com.griotold.portfolio.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {
    @InjectMocks
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroductions() {
        // give
        var introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE) {
            val introduction = Introduction(content = "${i}", isActive = i % 2 == 0)
            introductions.add(introduction)
        }
        val activeIntroductions = introductions.filter { it.isActive }

        Mockito.`when`(presentationRepository.getActiveIntroductions())
            .thenReturn(activeIntroductions)

        // when
        val introductionDTOS = presentationService.getIntroductions()

        // then
        assertThat(introductionDTOS).hasSize(DATA_SIZE / 2)
        for (introductionDTO in introductionDTOS) {
            assertThat(introductionDTO.content.toInt()).isEven()
        }
    }

    @Test
    fun testGetLinks() {
        // given
        var links = mutableListOf<Link>()
        for (i in 1..DATA_SIZE) {
            val link = Link(name = "${i}", content = "${i}", isActive = i % 2 == 0)
            links.add(link)
        }
        val activeLinks = links.filter { it.isActive }

        Mockito.`when`(presentationRepository.getActiveLinks())
            .thenReturn(activeLinks)

        // when
        val linkDTOs = presentationService.getLinks()

        assertThat(linkDTOs).hasSize(DATA_SIZE / 2)
        for (linkDTO in linkDTOs) {
            assertThat(linkDTO.content.toInt()).isEven()
        }
    }
}