package com.griotold.portfolio.presentation.controller

import com.griotold.portfolio.domain.constant.SkillType
import com.griotold.portfolio.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController(
    private val presentationsService: PresentationService
) {

    @GetMapping("/test")
    fun test(): String {
        return "test"
    }

    @GetMapping("/")
    fun index(model: Model): String {

        val introductions = presentationsService.getIntroductions()
        model.addAttribute("introductions", introductions)

        val links = presentationsService.getLinks()
        model.addAttribute("links", links)

        return "presentation/index"
    }

    @GetMapping("/resume")
    fun resume(model: Model): String {
        val resume = presentationsService.getResume()
        model.addAttribute("resume", resume)
        model.addAttribute("skillTypes", SkillType.values())

        return "presentation/resume"
    }

    @GetMapping("/projects")
    fun projects(model: Model): String {
        val projects = presentationsService.getProjects()
        model.addAttribute("projects", projects)

        return "presentation/projects"
    }
}