package com.accolite.mini_au.Messgener.model;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {
	public Profile()
	{
		
	}
	public Profile(String profile_name, int noOfFriends, String about) {
		super();
		this.profile_name = profile_name;
		NoOfFriends = noOfFriends;
		About = about;
	}
	String profile_name;
	int NoOfFriends;
	String About;
	public String getProfile_name() {
		return profile_name;
	}
	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}
	public int getNoOfFriends() {
		return NoOfFriends;
	}
	public void setNoOfFriends(int noOfFriends) {
		NoOfFriends = noOfFriends;
	}
	public String getAbout() {
		return About;
	}
	public void setAbout(String about) {
		About = about;
	}
	
}
