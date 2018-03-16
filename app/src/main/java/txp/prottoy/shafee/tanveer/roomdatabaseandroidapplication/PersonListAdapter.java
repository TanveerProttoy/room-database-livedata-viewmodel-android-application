package txp.prottoy.shafee.tanveer.roomdatabaseandroidapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tanveer on 3/16/18.
 */

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.PersonListViewHolder> {
    private List<Person> personList;

    protected class PersonListViewHolder extends RecyclerView.ViewHolder {
        private TextView rowPersonTxt0, rowPersonTxt1;

        PersonListViewHolder(View view) {
            super(view);
            rowPersonTxt0 = view.findViewById(R.id.row_person_txt_view0);
            rowPersonTxt1 = view.findViewById(R.id.row_person_txt_view1);
        }
    }

    @Override
    public PersonListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PersonListViewHolder((LayoutInflater.from(parent.getContext()))
                .inflate(R.layout.row_person_list, parent, false));
    }

    @Override
    public void onBindViewHolder(PersonListViewHolder holder, int position) {
        try {
            holder.rowPersonTxt0.setText("Name: " + personList.get(position).getPersonName());
            holder.rowPersonTxt1.setText("Address: " + personList.get(position).getPersonAddress());
        }
        catch(NullPointerException n) {

        }
    }

    @Override
    public int getItemCount() {
        try {
            return personList.size();
        }
        catch(NullPointerException n) {
            return 0;
        }
    }

    public void setPersons(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }
}
