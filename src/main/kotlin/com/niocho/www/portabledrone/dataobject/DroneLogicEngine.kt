package com.niocho.www.portabledrone.dataobject

import javax.persistence.*

@Entity
class DroneLogicEngine (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long,
    @Column(nullable = false, unique = true)
    var name: String,
    @Column(length = 4096)
    var description: String?,
    @Column(nullable = false)
    var startEvent: String,
    @ManyToOne
    var startObject: DroneLogicObject,
    @Column(nullable = false)
    var dataPhase: String,
)