package serwisaparatow.CameraService_MPR.manager;

import java.util.List;

import serwisaparatow.CameraService_MPR.database.Database;
import serwisaparatow.CameraService_MPR.objects.Person;

public class PersonManager {
	private Database db = new Database();

	public boolean addPerson(Person person) {
		return db.addPerson(person);

	}
	public boolean removePerson(Person person) {
		return db.removePerson(person);

	}
	public List<Person> getAll(){
		return db.getPersons();
		
	}
}
