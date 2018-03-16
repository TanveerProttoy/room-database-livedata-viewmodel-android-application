package txp.prottoy.shafee.tanveer.roomdatabaseandroidapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by tanveer on 3/16/18.
 */

@Dao
public interface PersonDao {

    @Query("SELECT * FROM PERSONS")
    LiveData<List<Person>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Person person);
}