package com.ourmail.groupservice;

import com.ourmail.groupservice.contract.BuildNewGroup;
import com.ourmail.groupservice.contract.GetGroupInformationById;
import com.ourmail.userservice.contract.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Repository
public class GroupserviceApplicationTests {

	public static final String TEST_NAME = "test user";

	@Autowired
	private BuildNewGroup buildNewGroup;
	@Autowired
	private GetGroupInformationById getGroupInformationById;
	@MockBean
	private UserService userService;

	@Test
	public void contextLoads() {
		when(userService.getNameByID(5)).thenReturn(TEST_NAME);
		long groupID = buildNewGroup.createNewGroup(5, "Group1", "Password1");
		long userID = getGroupInformationById.getGroupOwnerId(groupID);
		String user = userService.getNameByID(userID);
		assertEquals(user, TEST_NAME);
	}
}
