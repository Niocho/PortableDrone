package com.niocho.www.portabledrone.dataobject

import javax.persistence.*

enum class Role {
    USER,
    ADMIN
}

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long,
    @Column(nullable = false, unique = true)
    var name: String,
    @Column(length = 4096)
    var description: String?,
    @Column
    @Enumerated(EnumType.ORDINAL)
    var role: Role
)