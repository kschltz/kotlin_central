package com.kotlin.test.central.usecase


import com.kotlin.test.central.domain.SomeStuff
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class SaveSomeStuff(private val mongoTemplate: MongoTemplate){

    private val log = LoggerFactory.getLogger(SaveSomeStuff::class.java)

    fun execute(someStuff: SomeStuff){
        log.info("Saving stuff: {}",someStuff)
       mongoTemplate.save(someStuff)
    }

}
