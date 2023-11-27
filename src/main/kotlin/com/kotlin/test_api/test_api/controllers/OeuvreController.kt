package com.kotlin.test_api.test_api.controllers

import com.kotlin.test_api.test_api.dto.OeuvreDTO
import com.kotlin.test_api.test_api.services.definitions.OeuvreService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/oeuvres")
class OeuvreController(oeuvreService: OeuvreService) {
    private val oeuvreService: OeuvreService

    init {
        this.oeuvreService = oeuvreService
    }

    @GetMapping("/")
    fun findAll() : ResponseEntity<MutableList<OeuvreDTO>> {
        return ResponseEntity(this.oeuvreService.findAll(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : Long) : ResponseEntity<*> {
        val result = this.oeuvreService.findById(id)
        if(result != null){
            return ResponseEntity<OeuvreDTO>(result, HttpStatus.OK)
        }
        return ResponseEntity("Aucun élément trouvé avec id=$id", HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun create(@Valid @RequestBody oeuvreDTO: OeuvreDTO) : ResponseEntity<OeuvreDTO> {
        return ResponseEntity(this.oeuvreService.create(oeuvreDTO), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody oeuvreDTO: OeuvreDTO, @PathVariable("id") id : Long) : ResponseEntity<*> {
        val result = this.oeuvreService.update(oeuvreDTO, id)
        if(result != null){
            return ResponseEntity<OeuvreDTO>(result, HttpStatus.OK)
        }
        return ResponseEntity("Aucun élément trouvé avec id=$id", HttpStatus.NOT_FOUND)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id : Long) : ResponseEntity<*> {
        val result = this.oeuvreService.delete(id)
        if(result != null){
            return ResponseEntity(result, HttpStatus.OK)
        }
        return ResponseEntity("Aucun élément trouvé avec id=$id", HttpStatus.NOT_FOUND)
    }

}