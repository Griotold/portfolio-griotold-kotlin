package com.griotold.portfolio.presentation.interceptor

import com.griotold.portfolio.domain.entity.HttpInterface
import com.griotold.portfolio.domain.repository.HttpInterfaceRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.lang.Exception

@Component
class PresentationInterceptor(
    private val httpInterfaceRepository: HttpInterfaceRepository
): HandlerInterceptor {

    // afterCompletion 같은 경우, 컨트롤러에서 예외를 던져도 항상 실행된다.
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        val httpInterface = HttpInterface(request)
        httpInterfaceRepository.save(httpInterface)
    }
}