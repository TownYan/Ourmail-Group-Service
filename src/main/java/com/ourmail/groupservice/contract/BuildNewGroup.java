package com.ourmail.groupservice.contract;

public interface BuildNewGroup {
    long createNewGroup(long userID, String groupname, String grouppassword);

}
