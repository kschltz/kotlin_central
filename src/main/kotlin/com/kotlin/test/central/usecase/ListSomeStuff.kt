package com.kotlin.test.central.usecase

import com.kotlin.test.central.domain.SomeStuff
import com.kotlin.test.central.gateway.mongo.MongoSomeStuffRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ListSomeStuff(val someStuffRepository: MongoSomeStuffRepository){
    private val log = LoggerFactory.getLogger(ListSomeStuff::class.java)

    fun execute(): Flux<SomeStuff> {
        log.info("Listing all stuff")
        return someStuffRepository
                .findAll()
                .doOnError { error->throw error }
                .doOnSubscribe({subscription ->  log.info("listing started: {}", subscription)})
                .doOnComplete { log.info("done Listing") }
    }
}