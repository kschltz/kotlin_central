package com.kotlin.test.central

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class CentralApplication

fun main(args: Array<String>) {
    runApplication<CentralApplication>(*args)
}
