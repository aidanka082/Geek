package model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity
public class NoteModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public
    int id;
    String title;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NoteModel(String title) {
        this.title = title;
    }
}
