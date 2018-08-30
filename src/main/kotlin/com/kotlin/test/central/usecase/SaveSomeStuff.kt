package com.kotlin.test.central.usecase


import com.kotlin.test.central.domain.SomeStuff
import com.kotlin.test.central.gateway.mongo.MongoSomeStuffRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.function.Function

@Service
class SaveSomeStuff(private val mongoStuffSomeStuffRepository: MongoSomeStuffRepository){

    private val log = LoggerFactory.getLogger(SaveSomeStuff::class.java)

    fun execute(someStuff: SomeStuff){
        log.info("Saving some stuff: {}",someStuff.description)
        mongoStuffSomeStuffRepository
                .save(someStuff)
                .onErrorMap(Function.identity())
    }

}
