package com.niocho.www.portabledrone.dataobject

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class DroneTransaction (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long,
    @Column(nullable = false, unique = true)
    var name: String,
    @Column(length = 4096)
    var description: String?,
    @ManyToMany
    var drones: List<Drone>
    )