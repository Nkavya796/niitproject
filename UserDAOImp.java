package com.niit.SkillMappingBackEnd.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.SkillMappingBackEnd.Entity.Users;
import com.niit.SkillMappingBackEnd.Utility.DbConnect;

public class UserDAOImp {
	static Connection con = null;

	public UserDAOImp() {
		con = DbConnect.connect();
	}
	//inserting user details
		public boolean insertUser(Users user) {
			Users user1 = new Users();
			try {
				PreparedStatement ps = con.prepareStatement("INSERT INTO userinfo VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, user.getEmpId());
				ps.setString(2, user.getName());
				ps.setString(3, user. getDateofbirth());
				ps.setString(4, user.getGender());
				ps.setString(5, user.getAddress());
				ps.setString(6, user.getQualification());
				ps.setString(7, user.getEmailId());
				ps.setString(8, user.getContactNo());
				ps.setString(9, user.getDepartment());
				ps.setString(10, user.getSupervicer());
				ps.setString(11, user.getPassword());
				ps.setString(12, user.getRole());
				ps.setString(13, user.getAuthentication());
		
				
				int i = ps.executeUpdate();
				if (i > 0) {
					System.out.println("employee details  inserted successful");

					return true;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return false;
		}
		//updating users details
		public boolean updateUser(Users user) {
			// Users user1=new Users();
			int rowsUpdated = 0;

			try {
				PreparedStatement ps = con.prepareStatement("UPDATE Userinfo SET name=? WHERE empId=?");
				// user1 = getUserById(uId);
				ps.setString(1, user.getName());
				ps.setInt(2, user.getEmpId());
				// ps.setString(4, user1.getEmailId());

				rowsUpdated = ps.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
				return true;

			}
			return false;
		}
		//Retrieving user by Id
		public Users getUserById(int uid) {
			Users user = new Users();

			try {

				PreparedStatement ps = con.prepareStatement("select * from userinfo where empId=?");
				ps.setInt(1, uid);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					user.setEmpId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setDateofbirth(rs.getString(3));
					user.setGender(rs.getString(4));
					user.setAddress(rs.getString(5));
					user.setQualification(rs.getString(6));
					user.setEmailId(rs.getString(7));
					user.setContactNo(rs.getString(8));
					user.setDepartment(rs.getString(9));
					user.setSupervicer(rs.getString(10));
					user.setPassword(rs.getString(11));
					user.setRole(rs.getString(12));
					user.setAuthentication(rs.getString(13));
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return user;
		}
		
		
		//getting details by getUserbyAuthentication details for hr
		public static List <Users> getUserByAuthentication(String authentication){
			List<Users> list=new ArrayList<Users>();  
			Users user=new Users();


			
	try {
		PreparedStatement ps=con.prepareStatement("select * from userinfo where Authentication=?");
	    ps.setString(1,authentication);
		ResultSet rs=ps.executeQuery();
		if (rs.next()) {
			
			user.setEmpId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setDateofbirth(rs.getString(3));
			user.setGender(rs.getString(4));
			user.setAddress(rs.getString(5));
			user.setQualification(rs.getString(6));
			user.setEmailId(rs.getString(7));
			user.setContactNo(rs.getString(8));
			user.setDepartment(rs.getString(9));
			user.setSupervicer(rs.getString(10));
			user.setPassword(rs.getString(11));
			user.setRole(rs.getString(12));
			user.setAuthentication(rs.getString(13));
			list.add(user);
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	return list;
	}
		//Deleting user by Id
		public boolean deleteUser(int id) {

			int rowsUpdated = 0;
			try {

				PreparedStatement ps = con.prepareStatement("delete from userinfo where empId=?");
				ps.setInt(1, id);
				rowsUpdated = ps.executeUpdate();
				if (rowsUpdated > 0) {
					System.out.println("employee details  deleted successfully");

					return true;

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return false;

		}
		public boolean authorizeUser(int empId, String pwd)
		{
			boolean flag=false;
			Users u = new Users();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement
						("select * from userinfo where empId=? and password=?");
				ps.setInt(1, empId);
				ps.setString(2, pwd);
				ResultSet rs =ps.executeQuery();
				flag = rs.next();
				
				 /* ps=con.prepareStatement("SELECT password from userinfo where empId=?");  
				  ps.setInt(2, empId);
					ps.setString(1, pwd);
			       if(empId==u.getEmpId() && pwd.equals(u.getPassword())){  
			            return true;  
			        }
			else {  
			            return false;  
			        }  */
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



			return flag;

		}
		public static List<Users> getAllUsers(){  
			List<Users> list=new ArrayList<Users>();  

			try{  

				PreparedStatement ps=con.prepareStatement("select * from userinfo");  
				ResultSet rs=ps.executeQuery();  
				while(rs.next()){  
					Users user=new Users();  
					user.setEmpId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setDateofbirth(rs.getString(3));
					user.setGender(rs.getString(4));
					user.setAddress(rs.getString(5));
					user.setQualification(rs.getString(6));
					user.setEmailId(rs.getString(7));
					user.setContactNo(rs.getString(8));
					user.setDepartment(rs.getString(9));
					user.setSupervicer(rs.getString(10));
					user.setPassword(rs.getString(11));
					user.setRole(rs.getString(12));
					user.setAuthentication(rs.getString(13));
					list.add(user);  
				}  
				 
			}catch(Exception e){e.printStackTrace();}  

			return list;  
		}
	
}