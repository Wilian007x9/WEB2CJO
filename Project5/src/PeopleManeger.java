
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
}
