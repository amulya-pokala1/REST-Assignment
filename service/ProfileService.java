package com.accolite.mini_au.Messgener.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlType;

import com.accolite.mini_au.Messgener.model.Profile;
public class ProfileService {
	List<Profile> messages=new ArrayList<Profile>();
	public List<Profile> getProfile() throws ClassNotFoundException, SQLException
	{
		ArrayList<Profile> listofpersons=new ArrayList<Profile>();
		Connection con=DBConnection.getInstance();
		String query="select * from profile.profile";
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(query);
		while(rs.next())
		{
			String name=rs.getString(1);
			int followers=rs.getInt(2);
			String About=rs.getString(3);
			Profile p=new Profile(name,followers,About);
			listofpersons.add(p);
		}
		smt.close();
		return listofpersons;
		
	}
	public Profile getProfile(@PathParam("name") String name) throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.getInstance();
		String query="select * from profile.profile where name=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		Profile profile=new Profile();
		while(rs.next())
		{
			profile.setProfile_name(rs.getString(1));
			profile.setNoOfFriends(rs.getInt(2));
			profile.setAbout(rs.getString(3));
		}
		ps.close();
		return profile;
	}
	public boolean addnewProfile(Profile profile) throws ClassNotFoundException, SQLException
	{
		String query="insert into profile.profile values(?,?,?)";
		Connection con=DBConnection.getInstance();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, profile.getProfile_name());
		ps.setInt(2, profile.getNoOfFriends());
		ps.setString(3, profile.getAbout());
		int rowsCreated=ps.executeUpdate();
		if(rowsCreated!=0) return true;
		ps.close();
		return false;
	}
	public boolean update(@PathParam("name") String name,Profile profile) throws ClassNotFoundException, SQLException
	{
			String query="update profile.profile  set followers=? , About=? where name=?";
			Connection con=DBConnection.getInstance();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(3, name);
			ps.setInt(1, profile.getNoOfFriends());
			ps.setString(2, profile.getAbout());
			int rowsCreated=ps.executeUpdate();
			if(rowsCreated!=0) return true;
				ps.close();
			return false;
	}
	public boolean deleteProfile(@PathParam("name") String name) throws ClassNotFoundException, SQLException
	{
		String query="delete from profile.profile where name=?";
		Connection con=DBConnection.getInstance();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, name);
		int rowsCreated=ps.executeUpdate();
		if(rowsCreated!=0) return true;
		ps.close();
		return false;
	}

}
