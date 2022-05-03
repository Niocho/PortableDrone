package com.niocho.www.portabledrone.dataobject

import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.ManyToMany

class Permission (
    @Id
    @Column(nullable = false)
    var treeNode: String,
    @Column(nullable = false, unique = true)
    var name: String,
    @ManyToMany
    var roles: List<Role>
)