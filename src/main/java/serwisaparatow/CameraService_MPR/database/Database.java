package serwisaparatow.CameraService_MPR.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import serwisaparatow.CameraService_MPR.objects.*;

public class Database {

	private Connection connection;
	private Statement statement;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	private ResultSet rs;
	
	private String createTable = "Create table Cameras (id varchar(10),name varchar(50),model varchar(20),serialNumber varchar(10),dateOfReceive varchar(10));";
	
	private String createTable2 = "Create table Persons (name varchar(20),surName varchar(20),city varchar(20),phoneNumber varchar(10));";
    
	PreparedStatement addCamera;
    PreparedStatement removeCamera;
    PreparedStatement getCameras;
    
    PreparedStatement addPerson;
    PreparedStatement removePerson;
    PreparedStatement getPersons;
	
	
	public Database() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			rs = connection.getMetaData().getTables(null, null, null, null);

			boolean tableExists = false;
			while (rs.next()) {
				if ("Cameras".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists) {
				statement.executeUpdate(createTable);

			}
          addCamera=connection.prepareStatement("insert into Cameras (id, name,model,serialNumber,dateOfReceive) values (?,?,?,?,?);");
          removeCamera=connection.prepareStatement("delete from Cameras where id = ?");
          getCameras=connection.prepareStatement("select * from Cameras");
			
		
		tableExists = false;
		rs.first();
		while (rs.next()) {
			if ("Persons".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
				tableExists = true;
				break;
			}
		}

		if (!tableExists) {
			statement.executeUpdate(createTable2);

		}
      addPerson=connection.prepareStatement("insert into Persons (name,surName,city,phoneNumber) values (?,?,?,?);");
      removePerson=connection.prepareStatement("delete from Persons where name = ?");
      getPersons=connection.prepareStatement("select * from Persons");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	public boolean addCamera(Camera c){
		try {
			addCamera.setString(1, c.getId());
			addCamera.setString(2, c.getName());
			addCamera.setString(3, c.getModel());
			addCamera.setString(4, c.getSerialNumber());
			addCamera.setString(5, c.getDateOfReceive());
			return addCamera.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
	public boolean removeCamera(Camera c){
		try {
			removeCamera.setString(1, c.getId());				
			return removeCamera.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
}
	public List<Camera> getCameras(){
		ArrayList<Camera> result=new ArrayList<Camera>(); 
		
		try {
			ResultSet rs=getCameras.executeQuery();
			while (rs.next()){
				Camera c = new Camera(rs.getString("id"),rs.getString("name"),rs.getString("model"),rs.getString("serialNumber"),rs.getString("dateOfReceive"));
				result.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return result;
	}
	
	//Person
	public boolean addPerson(Person p){
		try {
			addPerson.setString(1, p.getName());
			addPerson.setString(2, p.getSurName());
			addPerson.setString(3, p.getCity());
			addPerson.setString(4, p.getPhoneNumber());
			return addPerson.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
	public boolean removePerson(Person p){
		try {
			removePerson.setString(1, p.getName());				
			return removePerson.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
}
	public List<Person> getPersons(){
		ArrayList<Person> result=new ArrayList<Person>(); 
		
		try {
			ResultSet rs=getPersons.executeQuery();
			while (rs.next()){
				Person p = new Person(rs.getString("name"),rs.getString("surName"),rs.getString("city"),rs.getString("phoneNumber"));
				result.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return result;
	}
}
