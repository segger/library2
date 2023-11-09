package se.johannalynn.springbooks.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.web.filter.OncePerRequestFilter

class ApiKeyAuthFilter(private val authenticationManager: AuthenticationManager) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val header = request.getHeader("X-API-KEY")
        val authentication = authenticationManager.authenticate(PreAuthenticatedAuthenticationToken(header, null))
        SecurityContextHolder.getContext().authentication = authentication
        filterChain.doFilter(request, response)
    }
}