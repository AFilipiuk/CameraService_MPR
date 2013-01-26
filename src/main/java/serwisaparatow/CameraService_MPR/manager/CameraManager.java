package serwisaparatow.CameraService_MPR.manager;

import java.util.List;

import serwisaparatow.CameraService_MPR.database.Database;
import serwisaparatow.CameraService_MPR.objects.Camera;

public class CameraManager {
	private Database db = new Database();

	public boolean addCamera(Camera camera) {
		return db.addCamera(camera);

	}
	public boolean removeCamera(Camera camera) {
		return db.removeCamera(camera);

	}
	public List<Camera> getAll(){
		return db.getCameras();
		
	}
}
