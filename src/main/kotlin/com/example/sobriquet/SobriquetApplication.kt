package com.example.sobriquet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EntityScan
@EnableJpaAuditing
@SpringBootApplication
class SobriquetApplication

fun main(args: Array<String>) {
	runApplication<SobriquetApplication>(*args)
}
