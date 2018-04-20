package com.ourmail.groupservice.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0L;
    var upId = 0L;
    var name = "";
    var type = 0L;
}