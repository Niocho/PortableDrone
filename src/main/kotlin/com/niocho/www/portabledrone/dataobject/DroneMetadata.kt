package com.niocho.www.portabledrone.dataobject

import javax.persistence.*

object Metadata {
    const val AES_PASSWORD = "aes_password"
    const val BELONG_TO_USER = "belong_to_user"
}

@Entity
class DroneMetadata (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long,
    @ManyToOne(targetEntity = Drone::class, cascade = [CascadeType.ALL], fetch = FetchType.LAZY, optional = false)
    var belongTo: Drone,
    @Column(name = "[key]", nullable = false)
    var key: String,
    @Column(nullable = false, length = 4096)
    var value: String
)