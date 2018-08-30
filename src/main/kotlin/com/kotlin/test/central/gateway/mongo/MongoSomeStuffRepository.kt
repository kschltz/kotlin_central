package com.kotlin.test.central.gateway.mongo

import com.kotlin.test.central.domain.SomeStuff
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoSomeStuffRepository : ReactiveCrudRepository<SomeStuff,String>