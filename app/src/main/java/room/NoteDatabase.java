package room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import model.NoteModel;

@Database(entities = NoteModel.class,version = 3,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
   public abstract TaskDao taskDao();
}
