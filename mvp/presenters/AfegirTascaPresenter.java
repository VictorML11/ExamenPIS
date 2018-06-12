package examen.victor.me.examenpis.mvp.presenters;

import examen.victor.me.examenpis.model.Tasca;
import examen.victor.me.examenpis.mvp.IAfegirTasca;
import examen.victor.me.examenpis.mvp.databases.AfegirTascaDatabase;

public class AfegirTascaPresenter implements IAfegirTasca.Presenter {

    private IAfegirTasca.View view;
    private IAfegirTasca.Model model;

    public AfegirTascaPresenter(IAfegirTasca.View view) {
        this.view = view;
        model = new AfegirTascaDatabase(this);
    }


    @Override
    public void changeActivity() {
        if (view != null) view.changeActivity();
    }

    @Override
    public void createTasca(Tasca tasca) {
        if(view != null) model.createTasca(tasca);
    }
}
