package com.kotlin.test.central.gateway.http

import com.kotlin.test.central.domain.SomeStuff
import com.kotlin.test.central.usecase.ListSomeStuff
import com.kotlin.test.central.usecase.SaveSomeStuff
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@RestController("/SomeStuff")
class SomeStuffController(
        val listSomeStuff: ListSomeStuff,
        val saveSomeStuff: SaveSomeStuff
){
    private val log = LoggerFactory.getLogger(SaveSomeStuff::class.java)

    @GetMapping
    fun getStuffs(): Mono<List<SomeStuff>> {
        return listSomeStuff.execute()
                .buffer()
                .doFinally({signalType -> log.info("Signal is {}", signalType) })
                .doOnNext({mutableList -> mutableList.forEach({stuff->log.info("Stuff found: {}",stuff)}) })
                .doOnError({error->throw error})
                .next()


    }

    @PostMapping
    fun saveStuff(){
        saveSomeStuff.execute(SomeStuff(description = "This is some coisa",bornDate = LocalDateTime.MAX))
    }
}