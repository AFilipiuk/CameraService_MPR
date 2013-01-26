package serwisaparatow.CameraService_MPR.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import serwisaparatow.CameraService_MPR.manager.PersonManager;
import serwisaparatow.CameraService_MPR.objects.Person;

public class PersonManagerTest {
	
	private PersonManager manager = new PersonManager();
    private static Person person_1 = new Person("Kasia", "Kilc", "Gdynia", "9274014");
    private static Person person_2 = new Person("Krzysztof", "Kowalski", "Starogard", "9237401");
	@Test
	public void testAddPerson() {
		manager.addPerson(person_1);
		int i = manager.getAll().size();
		manager.addPerson(person_2);
		assertEquals(i,manager.getAll().size()-1);
	}
	@Test
	public void testShowPerson() {
		assertNotNull(manager.getAll());
		
	}
	/*@Test
	public void testDeletePerson() {
		manager.addPerson(person_1);
		int i = manager.getAll().size();
		manager.removePerson(person_2);
		assertEquals(i,manager.getAll().size()+1);
	}*/
}
