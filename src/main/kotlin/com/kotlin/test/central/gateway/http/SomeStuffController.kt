package com.kotlin.test.central.gateway.http

import com.kotlin.test.central.domain.SomeStuff
import com.kotlin.test.central.usecase.ListSomeStuff
import com.kotlin.test.central.usecase.SaveSomeStuff
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController("SomeStuff")
@RequestMapping("stuff")
class SomeStuffController(
        val listSomeStuff: ListSomeStuff,
        val saveSomeStuff: SaveSomeStuff
){
    private val log = LoggerFactory.getLogger(SaveSomeStuff::class.java)

    @GetMapping
    @ApiOperation(value = "List stuff",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    fun getStuffs(): Flux<SomeStuff> {
        return listSomeStuff.execute()
                .doOnNext({someStuff -> log.info("stuff found {}",someStuff) })

    }

    @PostMapping
    fun saveStuff(){
        saveSomeStuff.execute(SomeStuff(description = "This is some coisa"))
    }
}