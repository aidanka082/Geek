package room;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

public class App extends Application {
    public static NoteDatabase instance = null;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        getInstance();
    }

    public static NoteDatabase getInstance() {
        if(instance == null){
            Room.databaseBuilder(context, NoteDatabase.class,
                    "task.database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


}
