package serwisaparatow.CameraService_MPR.objects;

public class Person {
	
	private String name = "";
	private String surName = "";
	private String city = "";
	private String phoneNumber = "";

	
	
	public Person(String name, String surName, String city, String phoneNumber) {
		super();
		this.name = name;
		this.surName = surName;
		this.city = city;
		this.phoneNumber = phoneNumber;

		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String toString(){
		String s = String.format("%20s|%10s|%6s|%12s|%6s|%7s|%6s\n", name,surName,city,phoneNumber);
		return s;
	}
	
	
}
