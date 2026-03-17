
import java.util.ArrayList;
import java.util.List;

public class PeopleManeger {

	private List<Person> PeopleList;
	
	public PeopleManeger() {
		PeopleList = new ArrayList<>();
	}
	
	public List<Person> getPeopleList(){
		return PeopleList;
	}
	
	public boolean save(Person person) {
		if(person != null) {
			PeopleList.add(person);
			return true;
		}
		return false;
	}
	
	public Person search(String cpf) {
		for(Person person: PeopleList) {
			if(person.getCpf().equals(cpf)) {
				
				return person;
			}
		}
		return null;
	}
	
	public boolean update(String cpf, String newName) {
		Person person = search(cpf);
		if(person != null) {
			int index = PeopleList.indexOf(person);
			if(index != -1) {
				person.setName(newName);
				PeopleList.set(index, person);
				return true;
			}
		}
		return false;
	}
	
	public boolean remove(String cpf) {
		Person person = search(cpf);
		if(person != null) {
			PeopleList.remove(person);
			return true;
		}
		return false;
	}
}
	