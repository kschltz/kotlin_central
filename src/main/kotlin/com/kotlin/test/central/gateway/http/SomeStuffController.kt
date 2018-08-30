package com.kotlin.test.central.gateway.http

import com.kotlin.test.central.domain.SomeStuff
import com.kotlin.test.central.usecase.ListSomeStuff
import com.kotlin.test.central.usecase.SaveSomeStuff
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController("/SomeStuff")
class SomeStuffController(
        val listSomeStuff: ListSomeStuff,
        val saveSomeStuff: SaveSomeStuff
){

    @GetMapping
    fun getStuffs(): Flux<SomeStuff> {
        return listSomeStuff.execute()

    }

    @PostMapping
    fun saveStuff(){
        saveSomeStuff.execute(SomeStuff(description = "This is some coisa"))
    }
}