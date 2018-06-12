package examen.victor.me.examenpis.mvp.databases;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import examen.victor.me.examenpis.FireBaseHelper;
import examen.victor.me.examenpis.model.Tasca;
import examen.victor.me.examenpis.mvp.IAfegirTasca;

public class AfegirTascaDatabase implements IAfegirTasca.Model {

    private IAfegirTasca.Presenter presenter;
    private FireBaseHelper fireBaseHelper;
    private DatabaseReference tascaReference;

    public AfegirTascaDatabase(IAfegirTasca.Presenter presenter) {
        this.presenter = presenter;
        fireBaseHelper = FireBaseHelper.getFireBaseHelper();
        tascaReference = FirebaseDatabase.getInstance().getReference("PIS/tasques");

    }


    @Override
    public void createTasca(Tasca tasca) {
        tascaReference.child(tasca.getId()).setValue(tasca).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    presenter.changeActivity();
                }
            }
        });

    }
}
