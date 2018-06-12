package examen.victor.me.examenpis.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import examen.victor.me.examenpis.R;
import examen.victor.me.examenpis.model.Tasca;

public class TascaAdapter extends BaseAdapter {

    private ArrayList<Tasca> tasques;
    private Context ctx;
    private LayoutInflater layoutInflater;

    public TascaAdapter(ArrayList<Tasca> tasques, Context ctx) {
        this.tasques = tasques;
        this.ctx = ctx;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    public TascaAdapter(Context ctx) {
        this.ctx = ctx;
        tasques = new ArrayList<>();
        layoutInflater = (LayoutInflater) ctx.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.tasques.size();
    }

    @Override
    public Object getItem(int position) {
        return this.tasques.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = layoutInflater.inflate(R.layout.tasca_element, null);
        TextView nom = vista.findViewById(R.id.tv_nom);
        TextView data = vista.findViewById(R.id.tv_data);
        TextView assumpte = vista.findViewById(R.id.tv_assumpte);
        TextView tipus = vista.findViewById(R.id.tv_tipus);
        TextView estat = vista.findViewById(R.id.tv_estat);

        Tasca tasca = tasques.get(position);

        nom.setText("Nom: " + tasca.getNom());
        data.setText("Data: " + tasca.getData());
        assumpte.setText("Assumpte: " + tasca.getAssumpte());
        tipus.setText("Tipus: " + tasca.getTipus());
        estat.setText("Estat: " + tasca.isAcabada());

        return vista;
    }

    public ArrayList<Tasca> getTasques() {
        return tasques;
    }

    public void setTasques(ArrayList<Tasca> tasques) {
        this.tasques = tasques;
    }
}
