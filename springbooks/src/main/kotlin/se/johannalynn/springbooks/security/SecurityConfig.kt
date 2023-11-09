package se.johannalynn.springbooks.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity, apiKeyAuthenticationProvider: ApiKeyAuthenticationProvider): SecurityFilterChain {
        http.csrf { it.disable() }
            .authorizeHttpRequests {
                it.anyRequest().authenticated()
            }
            .addFilterBefore(ApiKeyAuthFilter(ProviderManager(apiKeyAuthenticationProvider)), UsernamePasswordAuthenticationFilter::class.java)
            .sessionManagement { SessionCreationPolicy.STATELESS }
        return http.build()
    }

    @Bean
    fun apiKeyAuthenticationProvider(@Value("\${api.key}") apiKey: String) : ApiKeyAuthenticationProvider = ApiKeyAuthenticationProvider(apiKey)
}