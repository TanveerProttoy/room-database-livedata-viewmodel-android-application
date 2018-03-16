package txp.prottoy.shafee.tanveer.roomdatabaseandroidapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by tanveer on 3/16/18.
 */

public class PersonViewModel extends AndroidViewModel {
    private PersonRepository personRepository;
    private LiveData<List<Person>> personList;

    public PersonViewModel(Application application) {
        super(application);
        personRepository = new PersonRepository(application);
        personList = personRepository.getPersonList();
    }

    public LiveData<List<Person>> getPersonList() {
        return personList;
    }

    public void insert(Person person) {
        personRepository.insert(person);
    }
}
