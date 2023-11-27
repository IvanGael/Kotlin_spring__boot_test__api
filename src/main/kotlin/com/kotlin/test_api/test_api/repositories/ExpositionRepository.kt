package com.kotlin.test_api.test_api.repositories

import com.kotlin.test_api.test_api.models.Exposition
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpositionRepository : JpaRepository<Exposition, Long> {
}