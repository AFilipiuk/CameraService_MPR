package serwisaparatow.CameraService_MPR.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import serwisaparatow.CameraService_MPR.objects.Camera;

public class Database {

	private Connection connection;
	private Statement statement;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	private ResultSet rs;
	private String createTable = "Create table Cameras (title varchar(40),kind varchar(20),serial varchar(4),dateOfPrint varchar(20),pages int,own boolean,quantity int);";
    PreparedStatement addCamera;
    PreparedStatement removeCamera;
    PreparedStatement getCameras;
	
	
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
			removeCamera.setString(1, c.getSerialNumber());				
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
}
