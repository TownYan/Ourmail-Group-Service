package com.ourmail.groupservice.service;

import com.ourmail.groupservice.contract.BuildNewGroup;
import com.ourmail.groupservice.domain.MainGroup;
import com.ourmail.groupservice.repository.MainGroupRepository;
import com.ourmail.userservice.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class BuildNewGroupImpl implements BuildNewGroup {

    @Autowired
    private MainGroupRepository mainGroupRepository;
    @Autowired
    private UserService userService;

    @Override
    public long createNewGroup(long userID, String groupname, String grouppassword) {
        MainGroup newMainGroup = new MainGroup();
        newMainGroup.setGroupname(groupname);
        newMainGroup.setGrouppassword(grouppassword);
        newMainGroup.setGroupownerid(userID);
        newMainGroup.setCreateuser(userID);
        mainGroupRepository.save(newMainGroup);
        return newMainGroup.getId();
    }
}