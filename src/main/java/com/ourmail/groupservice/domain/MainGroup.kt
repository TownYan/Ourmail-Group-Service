package com.ourmail.groupservice.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class MainGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id=0L;
    var groupname="";
    var grouppassword="";
    var mail="";
    var groupownerid=0L;
    var createdata="";
    var createuser=0L;
}
