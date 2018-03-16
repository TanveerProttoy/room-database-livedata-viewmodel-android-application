package txp.prottoy.shafee.tanveer.roomdatabaseandroidapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by tanveer on 3/16/18.
 */

@Database(entities = {Person.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    private static volatile ApplicationDatabase INSTANCE;

    public abstract PersonDao personDao();

    public static ApplicationDatabase getInstance(Context context) {
        if(INSTANCE == null) {
            synchronized(ApplicationDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ApplicationDatabase.class, "room_application_db.db").build();
                }
            }
        }
        return INSTANCE;
    }
}
