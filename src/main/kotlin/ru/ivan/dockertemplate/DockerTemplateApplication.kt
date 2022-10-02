package ru.ivan.dockertemplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DockerTemplateApplication

fun main(args: Array<String>) {
	runApplication<DockerTemplateApplication>(*args)
}

@RestController
@RequestMapping("/api")
class CityController {

	@GetMapping("/hello")
	fun greet() = "hello!"
}
