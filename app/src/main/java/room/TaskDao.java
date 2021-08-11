package room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import model.NoteModel;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM notemodel")
    LiveData<List<NoteModel>>getAll();

    @Insert
    void InsertNote(NoteModel noteModel);

    @Insert
    void delete(NoteModel noteModel);

    @Insert
    void update(NoteModel noteModel);
}
