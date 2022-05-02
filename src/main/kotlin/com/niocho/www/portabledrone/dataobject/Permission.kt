package com.niocho.www.portabledrone.dataobject

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany

class Permission (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var treeNode: String,
    @Column(nullable = false, unique = true)
    var name: String,
    @ManyToMany
    var roles: List<Role>
)