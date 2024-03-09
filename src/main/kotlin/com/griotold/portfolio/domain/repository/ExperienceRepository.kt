package com.griotold.portfolio.domain.repository

import com.griotold.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long> {
    // todo Experience 엔티티는 일대다 관계를 품고 있기 때문에 아래 메소드를 사용하면 성능이 매우 떨어지게 된다.
    fun findAllByIsActive(isActive: Boolean): List<Experience>
}