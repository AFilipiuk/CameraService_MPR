package serwisaparatow.CameraService_MPR.objects;

public class Camera {
	
	private String id = "";
	private String name = "";
	private String model = "";
	private String serialNumber = "";
	private String dateOfReceive = "";

	
	
	public Camera(String id, String name, String model, String serialNumber, String dateOfReceive) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.serialNumber = serialNumber;
		this.dateOfReceive = dateOfReceive;

		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	

	public String getDateOfReceive() {
		return dateOfReceive;
	}
	public void setDateOfReceive(String dateOfReceive) {
		this.dateOfReceive = dateOfReceive;
	}

	public String toString(){
		String s = String.format("%20s|%10s|%6s|%12s|%6s|%7s|%6s\n", name,model,serialNumber,dateOfReceive);
		return s;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
