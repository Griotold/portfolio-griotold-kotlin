package com.griotold.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

/**
 * HTTP 요청 정보를 담는 엔티티
 * */
@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null

    var cookies: String? = httpServletRequest.cookies
        ?.map { "${it.name}:${it.value}" }
        ?.toString()

    // 요청이 어디서부터 왔는지
    var referer: String? = httpServletRequest.getHeader("referer")

    var localAddr: String? = httpServletRequest.localAddr

    var remoteAddr: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost

    var requestUri: String? = httpServletRequest.requestURI

    // 브라우저 정보: 크롬 사파리, 모바일, 데스크탑
    var userAgent: String? = httpServletRequest.getHeader("user-agent")
}