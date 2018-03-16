package txp.prottoy.shafee.tanveer.roomdatabaseandroidapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int CREATE_PERSON_ACTIVITY_REQUEST_CODE = 11;
    private PersonListAdapter personListAdapter;
    private PersonViewModel personViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        initializeViewModel();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CREATE_PERSON_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String[] values = data.getStringArrayExtra(CreatePersonActivity.REPLY);
            Person person = new Person();
            person.setPersonName(values[0]);
            person.setPersonAddress(values[1]);
            personViewModel.insert(person);
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "Input empty", Toast.LENGTH_LONG).show();
        }
    }

    private View.OnClickListener favButtonOcl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivityForResult(new Intent(MainActivity.this, CreatePersonActivity.class), CREATE_PERSON_ACTIVITY_REQUEST_CODE);
        }
    };

    private void initializeView() {
        findViewById(R.id.fab).setOnClickListener(favButtonOcl);
        personListAdapter = new PersonListAdapter();
        RecyclerView personRecyclerView = findViewById(R.id.main_recycler);
        personRecyclerView.setAdapter(personListAdapter);
        personRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private void initializeViewModel() {
        personViewModel = ViewModelProviders.of(MainActivity.this).get(PersonViewModel.class);
        personViewModel.getPersonList().observe(MainActivity.this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable final List<Person> personList) {
                personListAdapter.setPersons(personList);
            }
        });
    }
}
