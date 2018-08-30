package com.kotlin.test.central.domain

import java.time.LocalDateTime

data class SomeStuff(
        val description :String = "Not Informed",
        val bornDate : LocalDateTime = LocalDateTime.now()
        )