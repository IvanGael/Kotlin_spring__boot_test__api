package com.kotlin.test_api.test_api.repositories

import com.kotlin.test_api.test_api.models.Session
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionRepository : JpaRepository<Session, Long> {
}