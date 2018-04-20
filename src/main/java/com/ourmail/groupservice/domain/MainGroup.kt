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
    var groupName="";
    var groupPassword="";
    var groupAddress="";
    var groupOwnerId=0L;
    var createDate=0L;
    var createUser=0L;
}
