package se.johannalynn.serverapp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ServerappController {

    @GetMapping("/")
    fun helloworld() = "Hello world!"

}