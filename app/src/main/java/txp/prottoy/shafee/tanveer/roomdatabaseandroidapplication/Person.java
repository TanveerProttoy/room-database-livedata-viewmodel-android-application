package txp.prottoy.shafee.tanveer.roomdatabaseandroidapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by tanveer on 3/16/18.
 */

@Entity(tableName = "persons")
public class Person {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    private int id;

    @ColumnInfo(name = "person_name")
    private String personName;

    @ColumnInfo(name = "person_address")
    private String personAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }
}
