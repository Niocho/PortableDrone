package com.niocho.www.portabledrone.dataobject

import javax.persistence.*

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long,
    @Column(nullable = false, unique = true)
    var name: String,
    @Column(nullable = false)
    var password: String,
    @Column(length = 4096)
    var description: String?,
    @ManyToOne(optional = false)
    var role: Role
)