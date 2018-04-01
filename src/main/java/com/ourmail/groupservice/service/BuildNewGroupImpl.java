package com.ourmail.groupservice.service;

import com.ourmail.groupservice.contract.BuildNewGroup;
import com.ourmail.groupservice.domain.Group;

public class BuildNewGroupImpl implements BuildNewGroup {
    @Override
    public void createNewGroup(long userID, String groupname, String grouppassword) {
            Group newGroup = new Group();
            newGroup.setName(groupname);
            newGroup.setPassword(grouppassword);
            newGroup.setCreateuser(userID);
    }
}
