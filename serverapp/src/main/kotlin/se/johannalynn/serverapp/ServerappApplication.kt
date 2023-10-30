package se.johannalynn.serverapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerappApplication

fun main(args: Array<String>) {
	runApplication<ServerappApplication>(*args)
}
