package com.niit.SkillMappingBackEnd.TestCase;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.SkillMappingBackEnd.Entity.Users;
import com.niit.SkillMappingBackEnd.Repository.UserDAOImp;

public class UsersTest {
	private static UserDAOImp userDao = new UserDAOImp();
	private Users user1 = new Users();
	
	@BeforeClass
	public static void init() {
		userDao = new UserDAOImp();
	}
	//@Ignore

	@Test
	public void testInsertUser() {
		boolean flag;
		user1 = new Users();
	    user1.setEmpId(203);
		user1.setName("rama");
		user1.setDateofbirth("34995");
		user1.setGender("Male");
		user1.setAddress("bangalore");
		user1.setQualification("BE");
		user1.setEmailId("reem@gmail.com");
		user1.setContactNo("998011221");
		user1.setDepartment("dept1");
		user1.setSupervicer("geeta");
		user1.setPassword("1234567");
		user1.setRole("Employee");
		user1.setAuthentication("NotApproved");
	
		flag = userDao.insertUser(user1);
		assertEquals("Failed to insert userdetails!", true, flag);
	}
	
	
		
@Ignore
@Test
public void  testgetUserByAuthentication1() {
	List<Users>list=userDao.getUserByAuthentication("Approved");
	assertEquals("Failed to get user!",5,list.size());
}
@Ignore
@Test
public void  testgetUserByAuthentication() {
	List<Users>list=userDao.getUserByAuthentication("Not Approved");
	assertEquals("Failed to get user!",1,list.size());
}

	
@Ignore
	@Test
	public void testgetUserById() {
		user1 = userDao.getUserById(111);
		assertEquals("Failed to get User !", "john", user1.getName());
	}

 @Ignore

	@Test
	public void testUpdateUser() {

		user1 = userDao.getUserById(458);
		user1.setName("sunny");
		boolean flag = userDao.updateUser(user1);
		assertEquals("Failed to update userdetails!", true, flag);
	}

	@Ignore
	@Test
	public void testDeleteUser() {
 
		boolean flag = userDao.deleteUser(2900);
		assertEquals("Failed to delete userdetails!", true, flag);
	}
	@Ignore
@Test
public void testValidateuser(){
	boolean flag=userDao.authorizeUser(112, "1234");
	assertEquals("Failed to authorize!", true, flag);
}
@Ignore
@Test
public void testlistuser() {
List<Users> list=userDao.getAllUsers();
assertEquals("Failed to authorize!",5,list.size());

}


}	