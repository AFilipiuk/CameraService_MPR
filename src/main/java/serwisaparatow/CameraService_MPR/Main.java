package serwisaparatow.CameraService_MPR;

import java.util.List;

import serwisaparatow.CameraService_MPR.manager.CameraManager;
import serwisaparatow.CameraService_MPR.objects.Camera;

public class Main {


	public static void main(String[] args) {
		Camera camera = new Camera ("1","Canon","550d","CAN0284627","27.08.2011");
		CameraManager manager = new CameraManager ();
		manager.addCamera(camera);
		
		Camera camera2 = new Camera ("2","Canon","5DmarkII","CA0307122","21.10.2010");
		manager.addCamera(camera2);
		 
		List<Camera>lista= manager.getAll();	
		for (Camera c: lista){
			System.out.println(c);
		}


	}

}
