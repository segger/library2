package se.johannalynn.springbooks.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken

open class ApiKeyAuthenticationProvider(private val apiKey: String) : AuthenticationProvider {

    override fun authenticate(authentication: Authentication): Authentication {
        val token = authentication.principal as String

        if (token == apiKey) {
            return ApiKeyAuthentication()
        }
        throw BadCredentialsException("Invalid or missing token")
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return PreAuthenticatedAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}

class ApiKeyAuthentication : Authentication {
    override fun getName(): String = ""

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? = null

    override fun getCredentials() = Unit

    override fun getDetails() = Unit

    override fun getPrincipal() = Unit

    override fun isAuthenticated() = true

    override fun setAuthenticated(isAuthenticated: Boolean) { }

}