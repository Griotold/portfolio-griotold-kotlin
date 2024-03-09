package com.griotold.portfolio.domain.repository

import com.griotold.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long> {
    // todo Project 엔티티는 일대다관계를 품고 있기 때문에 아래 메서드를 사용하면 성능이 매우 떨어진다.
    fun findAllByIsActive(isActive: Boolean): List<Project>

}