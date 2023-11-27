package com.kotlin.test_api.test_api.controllers

import com.kotlin.test_api.test_api.dto.ExpositionDTO
import com.kotlin.test_api.test_api.services.definitions.ExpositionService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/expositions")
class ExpositionController(expositionService: ExpositionService) {
    private val expositionService: ExpositionService

    init {
        this.expositionService = expositionService
    }

    @GetMapping("/")
    fun findAll() : ResponseEntity<MutableList<ExpositionDTO>> {
        return ResponseEntity(this.expositionService.findAll(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : Long) : ResponseEntity<*> {
        val result = this.expositionService.findById(id)
        if(result != null){
            return ResponseEntity<ExpositionDTO>(result, HttpStatus.OK)
        }
        return ResponseEntity("Aucun élément trouvé avec id=$id", HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun create(@Valid @RequestBody expositionDTO: ExpositionDTO) : ResponseEntity<ExpositionDTO> {
        return ResponseEntity(this.expositionService.create(expositionDTO), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody expositionDTO: ExpositionDTO, @PathVariable("id") id : Long) : ResponseEntity<*> {
        val result = this.expositionService.update(expositionDTO, id)
        if(result != null){
            return ResponseEntity<ExpositionDTO>(result, HttpStatus.OK)
        }
        return ResponseEntity("Aucun élément trouvé avec id=$id", HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id : Long) : ResponseEntity<*> {
        val result = this.expositionService.delete(id)
        if(result != null){
            return ResponseEntity(result, HttpStatus.OK)
        }
        return ResponseEntity("Aucun élément trouvé avec id=$id", HttpStatus.NOT_FOUND)
    }
}