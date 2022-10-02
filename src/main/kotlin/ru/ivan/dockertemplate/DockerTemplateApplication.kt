package ru.ivan.dockertemplate

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.Id

@SpringBootApplication
class DockerTemplateApplication

fun main(args: Array<String>) {
	runApplication<DockerTemplateApplication>(*args)
}

@RestController
@RequestMapping("/api")
class CityController {
	@Autowired
	private lateinit var cityRepository: CityRepository

	@GetMapping("/all")
	fun findAll(): List<City> = cityRepository.findAll()

	@GetMapping("/{id}")
	fun findById(@PathVariable("id") id: Int) = cityRepository.findById(id)

	@PostMapping("/save")
	fun save(@RequestBody city: City) = cityRepository.save(city)

	@DeleteMapping("/{id}")
	fun deleteById(@PathVariable("id") id: Int) = cityRepository.deleteById(id)
}

@Repository
interface CityRepository: JpaRepository<City, Int>

@Entity
data class City(@Id val id: Int, val name: String)
