package examen.victor.me.examenpis;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

import examen.victor.me.examenpis.model.Tasca;
import examen.victor.me.examenpis.mvp.IAfegirTasca;
import examen.victor.me.examenpis.mvp.presenters.AfegirTascaPresenter;

public class AfegirTasca extends AppCompatActivity implements IAfegirTasca.View{

    private EditText name;
    private EditText date;
    private EditText assumpte;
    private Spinner tipus;
    private CheckBox state;
    private Button cancelar;
    private Button aceptar;
    private boolean isEditMode = false;
    private IAfegirTasca.Presenter presenter;
    private Tasca t;


    private ArrayList<String> tipusTasca = new ArrayList<>(Arrays.asList("Familia", "Feina", "Personal", "Estudis"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_tasca);

        presenter = new AfegirTascaPresenter(this);

        name = findViewById(R.id.nom);
        date = findViewById(R.id.data);
        assumpte = findViewById(R.id.assumpte);
        tipus = findViewById(R.id.tipus);
        state = findViewById(R.id.estat);
        cancelar = findViewById(R.id.btn_cancelar);
        aceptar = findViewById(R.id.btn_aceptar);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tipusTasca);
        tipus.setAdapter(spinnerAdapter);

        tipus.setSelection(0);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            isEditMode = true;
            t = (Tasca) getIntent().getSerializableExtra("Data");
            name.setText(t.getNom());
            date.setText(t.getData());
            assumpte.setText(t.getAssumpte());
            tipus.setSelection(getIdxFromTipus(t.getTipus()));
            state.setChecked(t.isAcabada());
        }


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = name.getText().toString().trim();
                String data = date.getText().toString().trim();
                String ass = assumpte.getText().toString().trim();
                String tip = getTipusFromPos(tipus.getSelectedItemPosition());
                boolean isdone = isDone();

                if(!isEditMode){
                    Tasca tasca = new Tasca(nom,data,ass,tip,isdone);
                    presenter.createTasca(tasca);
                }else{
                    System.out.println("Test");
                    Tasca t2 = new Tasca(t.getId(), nom, data, ass, tip, isdone);
                    presenter.createTasca(t2);
                }


                /*
                Esto se tendria que substituir
                 */
                    //DataManager.getDataManager().addTasca(tasca);
                    //finish();





            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private String getTipusFromPos(int idx){
        return tipusTasca.get(idx);
    }

    private int getIdxFromTipus(String tipus){
        int idx = -1;
        for(int i = 0; i < tipusTasca.size(); i++){
            if(tipusTasca.get(i).equals(tipus)){
                idx = i;
            }
        }
        return idx;
    }

    private boolean isDone(){
        return state.isChecked();
    }

    @Override
    public void changeActivity() {
        finish();
    }
}
