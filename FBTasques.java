package examen.victor.me.examenpis;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import examen.victor.me.examenpis.model.Tasca;

public class FBTasques {

    private FirebaseDatabase database;
    private DatabaseReference tasquesReference;


    public FBTasques(FirebaseDatabase database) {
        this.database = database;
        tasquesReference = database.getReference("PIS/tasques");
        this.loadTasques();
    }

    private void loadTasques(){
        tasquesReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                System.out.println("Task added");
                Tasca tasca = dataSnapshot.getValue(Tasca.class);

                DataManager.getDataManager().addTasca(tasca);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Tasca tasca = dataSnapshot.getValue(Tasca.class);
                DataManager.getDataManager().updateTasca(tasca);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
