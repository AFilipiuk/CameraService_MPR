package serwisaparatow.CameraService_MPR.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import serwisaparatow.CameraService_MPR.manager.CameraManager;
import serwisaparatow.CameraService_MPR.objects.Camera;

public class CameraManagerTest {
	private CameraManager manager = new CameraManager();
	private static Camera camera_1 = new Camera("3","Pentax", "K10", "PEN9210734", null);
    private static Camera camera_2 = new Camera("5","Nikon", "D90", "NIK0297368", null);
	@Test
	public void testAddCamera() {
		manager.addCamera(camera_1);
		int i = manager.getAll().size();
		manager.addCamera(camera_2);
		assertEquals(i,manager.getAll().size()-1);
	}
	@Test
	public void testShowCamera() {
		assertNotNull(manager.getAll());
		
	}
	/*@Test
	public void testDeleteCamera() {
		manager.addCamera(camera_1);
		int i = manager.getAll().size();
		manager.removeCamera(camera_2);
		assertEquals(i,manager.getAll().size()+1);
	}*/
}
