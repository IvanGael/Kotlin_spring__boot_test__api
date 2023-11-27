package com.kotlin.test_api.test_api.controllers

import com.kotlin.test_api.test_api.dto.SessionDTO
import com.kotlin.test_api.test_api.services.definitions.SessionService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/sessions")
class SessionController(sessionService : SessionService) {
    private val sessionService : SessionService

    init {
        this.sessionService = sessionService
    }

    @GetMapping("/")
    fun findAll() : ResponseEntity<MutableList<SessionDTO>> {
        return ResponseEntity(this.sessionService.findAll(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : Long) : ResponseEntity<*> {
        val result = this.sessionService.findById(id)
        if(result != null){
            return ResponseEntity<SessionDTO>(result, HttpStatus.OK)
        }
        return ResponseEntity("Aucun élément trouvé avec id=$id", HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun create(@Valid @RequestBody sessionDTO: SessionDTO) : ResponseEntity<SessionDTO> {
        return ResponseEntity(this.sessionService.create(sessionDTO), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody sessionDTO: SessionDTO, @PathVariable("id") id : Long) : ResponseEntity<*> {
        val result = this.sessionService.update(sessionDTO, id)
        if(result != null){
            return ResponseEntity<SessionDTO>(result, HttpStatus.OK)
        }
        return ResponseEntity("Aucun élément trouvé avec id=$id", HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id : Long) : ResponseEntity<*> {
        val result = this.sessionService.delete(id)
        if(result != null){
            return ResponseEntity(result, HttpStatus.OK)
        }
        return ResponseEntity("Aucun élément trouvé avec id=$id", HttpStatus.NOT_FOUND)
    }

}