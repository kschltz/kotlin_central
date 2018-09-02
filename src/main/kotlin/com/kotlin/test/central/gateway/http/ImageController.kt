package com.kotlin.test.central.gateway.http

import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.net.URL
import org.openimaj.io.HttpUtils
import java.io.InputStream

@RestController("image")

@RequestMapping("image")
class ImageController {

    @PostMapping(consumes = [APPLICATION_JSON_UTF8_VALUE])
    @ApiOperation("Builds url")
    fun loadImage(@RequestBody urlPath: Mono<String>):Mono<InputStream> {

        val logger = LoggerFactory.getLogger(ImageController::class.java)

       return urlPath
                .map {
                    s ->val url = URL(s)
                    val readURL = HttpUtils.readURL(url)
                    logger.info("Read: {}",readURL)
                    readURL
                }

               .doOnError { logger.error("Failed to build image from url") }
    }





}
