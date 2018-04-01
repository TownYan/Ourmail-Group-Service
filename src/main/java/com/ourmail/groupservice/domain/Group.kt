package com.ourmail.groupservice.domain

import javax.persistence.Entity

@Entity
class Group {
    var id = 0L;
    var name = "";
    var password = "";
    var mail = "";
    var createdata = "";
    var createuser = 0L;
}