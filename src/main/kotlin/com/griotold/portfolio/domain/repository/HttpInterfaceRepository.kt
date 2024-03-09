package com.griotold.portfolio.domain.repository

import com.griotold.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {
    // 방문자 통계: 총 합계
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime): Long
}