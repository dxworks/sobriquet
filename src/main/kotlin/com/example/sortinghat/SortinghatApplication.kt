package com.example.sortinghat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EntityScan
@EnableJpaAuditing
@SpringBootApplication
class SortinghatApplication

fun main(args: Array<String>) {
	runApplication<SortinghatApplication>(*args)
}
