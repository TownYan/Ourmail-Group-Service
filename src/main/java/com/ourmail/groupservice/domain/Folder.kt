package com.ourmail.groupservice.domain

import javax.persistence.Entity

@Entity
class Folder {
    var id = 0L;
    var upid = 0L;
    var name = "";
    var type = 0L;
}