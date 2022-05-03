package com.niocho.www.portabledrone.dataobject

import javax.persistence.*

@Entity
class DroneLogicObject (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long,
    @Column(nullable = false, unique = true)
    var type: String,
    @Column(nullable = false, unique = true)
    var name: String,
    @Column(length = 4096)
    var description: String?
    )