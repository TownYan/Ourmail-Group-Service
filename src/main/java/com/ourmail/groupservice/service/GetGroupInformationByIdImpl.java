package com.ourmail.groupservice.service;

import com.ourmail.groupservice.contract.GetGroupInformationById;
import com.ourmail.groupservice.repository.MainGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class GetGroupInformationByIdImpl implements GetGroupInformationById {

    @Autowired
    private MainGroupRepository mainGroupRepository;

    @Override
    public long getGroupOwnerId(long groupID) {
        return mainGroupRepository.findGroupowneridById(groupID);
    }
}
