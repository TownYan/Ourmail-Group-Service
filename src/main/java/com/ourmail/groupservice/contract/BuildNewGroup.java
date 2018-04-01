package com.ourmail.groupservice.contract;

public interface BuildNewGroup {
    void createNewGroup(long userID, String groupname, String grouppassword);
}
