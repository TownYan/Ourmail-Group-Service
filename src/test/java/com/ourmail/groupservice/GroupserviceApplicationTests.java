package com.ourmail.groupservice;

import com.ourmail.group.contract.GroupService;
import com.ourmail.userservice.contract.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Repository
public class GroupserviceApplicationTests {

	public static final String TEST_NAME = "test user";

	@Autowired
	private GroupService groupService;
	@MockBean
	private UserService userService;

	@Test
	public void contextLoads() {
		when(userService.getNameByID(5)).thenReturn(TEST_NAME);
		List<Long> s = new ArrayList<>();
		List<Long> ss = new ArrayList<>();
		s.add((long) 2);
		s.add((long) 3);
		ss.add((long) 2);
		groupService.creatNewGroup(5, "Group1", "Password1");
		groupService.creatNewGroup(10, "Group3", "Password3");
		groupService.creatNewGroup(10, "Group3", "Password4");
		//assertEquals(s, groupService.getGroupIdByGroupName("Group3"));
		assertEquals(s, groupService.getGroupIdByOwnerId(10));
		assertEquals(s, groupService.getGroupIdByCreateUser(10));
		groupService.removeGroup(3);
		assertEquals(ss, groupService.getGroupIdByGroupName("Group3"));
		long userID = groupService.getGroupOwnerId(1);
		assertEquals(userID, 5);
		String user = userService.getNameByID(userID);
		assertEquals(user, TEST_NAME);
		userID = groupService.getCreateUser(1);
		user = userService.getNameByID((userID));
		assertEquals(user, TEST_NAME);
		assertEquals(groupService.getCreateDate(1), (long)0);
		assertEquals(groupService.getGroupAddress(1), "");
		groupService.modifyGroupName(1,"Group2");
		groupService.modifyPassword(1,"Password2");
		assertEquals("Group2", groupService.getGroupName(1));
	}
}
