package se.johannalynn.springbooks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerappApplication

fun main(args: Array<String>) {
	runApplication<ServerappApplication>(*args)
}
