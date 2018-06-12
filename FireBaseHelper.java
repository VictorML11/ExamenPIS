package examen.victor.me.examenpis;

import com.google.firebase.database.FirebaseDatabase;

public class FireBaseHelper {

    private static FireBaseHelper instance;
    private FirebaseDatabase database;

    private FBTasques fbTasques;

    private FireBaseHelper() {
        this.database =  FirebaseDatabase.getInstance();
    }



    public void loadTasks() {
        fbTasques = new FBTasques(database);
    }


    /**
     * Singleton FireBaseHelper
     * @return FireBaseHelper instance
     */
    public static FireBaseHelper getFireBaseHelper(){
        synchronized (FireBaseHelper.class) {
            if (instance == null)
                instance = new FireBaseHelper();
        }
        return instance;
    }
}


