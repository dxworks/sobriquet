package com.example.sobriquet.persistance

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import java.util.*
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @CreatedDate
    @Column(name = "created", nullable = false, updatable = false)
    lateinit var created: Instant

    @LastModifiedDate
    @Column(name = "last_modified", nullable = false)
    lateinit var lastModified: Instant

    @Column(unique = true)
    var uuid: String = UUID.randomUUID().toString()

}
