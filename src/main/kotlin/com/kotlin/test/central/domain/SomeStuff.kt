package com.kotlin.test.central.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document(collection = "someStuff")
data class SomeStuff(
        @Id
        val id: String = UUID.randomUUID().toString(),
        val description: String = "Not Informed",
        val bornDate: LocalDateTime = LocalDateTime.now()
)