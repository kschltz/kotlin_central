package com.kotlin.test.central.usecase

import com.kotlin.test.central.domain.SomeStuff
import com.kotlin.test.central.gateway.mongo.MongoSomeStuffRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.function.Function

@Service
class ListSomeStuff(val someStuffRepository: MongoSomeStuffRepository){
    private val log = LoggerFactory.getLogger(ListSomeStuff::class.java)

    fun execute(): Flux<SomeStuff> {
        log.info("Listing all stuff")
        return someStuffRepository
                .findAll()
                .onErrorMap(Function.identity())
                .doOnComplete { log.info("done Listing") }
    }
}