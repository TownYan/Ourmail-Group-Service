package com.ourmail.groupservice.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class MemberGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var memberGroupId = 0L;
    var groupid = 0L;
    var membergroupname = "";
}