package examen.victor.me.examenpis;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import examen.victor.me.examenpis.adapters.TascaAdapter;
import examen.victor.me.examenpis.model.Tasca;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton addTask;
    private Context context;
    private DataManager dataManager;
    private TascaAdapter tascaAdapter;

    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        dataManager = DataManager.getDataManager();
        FireBaseHelper.getFireBaseHelper().loadTasks();


        addTask = findViewById(R.id.addTask);
        list = findViewById(R.id.listTaks);
        tascaAdapter = new TascaAdapter(context);
        list.setAdapter(tascaAdapter);

        new Handler().postDelayed(() -> {
            tascaAdapter.getTasques().clear();
            tascaAdapter.getTasques().addAll(DataManager.getDataManager().getTasques());
            tascaAdapter.notifyDataSetChanged();

        }, 3 * 1000);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AfegirTasca.class);
                startActivity(intent);
            }
        });



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, AfegirTasca.class);
                Tasca t = dataManager.getTasques().get(position);
                System.out.println(t.toString());
                Bundle inf = new Bundle();
                inf.putSerializable("Data", t);
                intent.putExtras(inf);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Enter");
        tascaAdapter.getTasques().clear();
        tascaAdapter.getTasques().addAll(DataManager.getDataManager().getTasques());
        tascaAdapter.notifyDataSetChanged();

    }
}
