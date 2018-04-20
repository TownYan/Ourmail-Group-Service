package com.ourmail.groupservice.service;

import com.ourmail.group.contract.GroupService;
import com.ourmail.group.contract.OutMainGroup;
import com.ourmail.groupservice.domain.MainGroup;
import com.ourmail.groupservice.repository.MainGroupRepository;
import com.ourmail.userservice.contract.UserService;
import kotlin.collections.AbstractList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private MainGroupRepository mainGroupRepository;
    @Autowired
    private UserService userService;

    @Override
    public void creatNewGroup(long l, String s, String s1) {
        MainGroup newMainGroup = new MainGroup();
        newMainGroup.setGroupName(s);
        newMainGroup.setGroupPassword(s1);
        newMainGroup.setGroupOwnerId(l);
        newMainGroup.setCreateUser(l);
        mainGroupRepository.save(newMainGroup);
    }

    @Override
    public void modifyGroupName(long l, String s) {
        mainGroupRepository.findById(l).setGroupName(s);
    }

    @Override
    public void modifyPassword(long l, String s) {
        mainGroupRepository.findById(l).setGroupPassword(s);
    }

    @Override
    public void modifyOwnerId(long l, long l1) {
        mainGroupRepository.findById(l).setGroupOwnerId(l1);
    }

    @Override
    public void removeGroup(long l) {
        mainGroupRepository.deleteById(l);
    }

    @Override
    public OutMainGroup getGroupById(long l) {
        OutMainGroup NeedOutMainGroup = new OutMainGroup();
        NeedOutMainGroup.setId(l);
        NeedOutMainGroup.setGroupName(mainGroupRepository.findById(l).getGroupName());
        NeedOutMainGroup.setGroupAddress(mainGroupRepository.findById(l).getGroupAddress());
        NeedOutMainGroup.setCreatedata(mainGroupRepository.findById(l).getCreateDate());
        NeedOutMainGroup.setGroupOwnerId(mainGroupRepository.findById(l).getGroupOwnerId());
        NeedOutMainGroup.setGroupCreateUser(mainGroupRepository.findById(l).getCreateUser());
        return NeedOutMainGroup;
    }

    @Override
    public List<OutMainGroup> getGroupListByGroupName(String s) {
        List<MainGroup> NeedGroup = mainGroupRepository.findAllByGroupName(s);
        List<OutMainGroup> NeedOutMainGroup;
        return NeedOutMainGroup;
    }

    @Override
    public List<OutMainGroup> getGroupListByOwnerId(long l) {
        List<MainGroup> NeedGroup = mainGroupRepository.findAllByGroupOwnerId(l);
        List<OutMainGroup> NeedOutMainGroup = new AbstractList<OutMainGroup>();
        return NeedOutMainGroup;
    }

    @Override
    public List<OutMainGroup> getGroupListByCreateUserId(long l) {
        List<MainGroup> NeedGroup = mainGroupRepository.findAllByCreateUser(l);
        List<OutMainGroup> NeedOutMainGroup = null;
        return NeedOutMainGroup;
    }

    @Override
    public List<Long> getGroupIdByGroupName(String s) {
        List<Long> GroupIdList = new ArrayList<>();
        List<MainGroup> NeedGroup = mainGroupRepository.findAllByGroupName(s);
        for (int i = 0; i < NeedGroup.size(); i++)
            GroupIdList.add(NeedGroup.get(i).getId());
        return GroupIdList;
    }
}