package txp.prottoy.shafee.tanveer.roomdatabaseandroidapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by tanveer on 3/16/18.
 */

public class PersonRepository {
    private PersonDao personDao;
    private LiveData<List<Person>> personList;

    public PersonRepository(Application application) {
        ApplicationDatabase db = ApplicationDatabase.getInstance(application);
        personDao = db.personDao();
        personList = personDao.getAll();
    }

    public LiveData<List<Person>> getPersonList() {
        return personList;
    }

    public void insert(Person person) {
        new InsertAsyncTask(personDao).execute(person);
    }

    private static class InsertAsyncTask extends AsyncTask<Person, Void, Void> {

        private PersonDao personDao;

        InsertAsyncTask(PersonDao personDao) {
            this.personDao = personDao;
        }

        @Override
        protected Void doInBackground(final Person... params) {
            personDao.insert(params[0]);
            return null;
        }
    }
}