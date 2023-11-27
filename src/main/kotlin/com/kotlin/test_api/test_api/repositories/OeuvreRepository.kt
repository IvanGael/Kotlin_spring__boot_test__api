package com.kotlin.test_api.test_api.repositories

import com.kotlin.test_api.test_api.models.Oeuvre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OeuvreRepository : JpaRepository<Oeuvre, Long> {
}