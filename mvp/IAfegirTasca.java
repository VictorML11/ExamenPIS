package examen.victor.me.examenpis.mvp;

import android.net.Uri;

import examen.victor.me.examenpis.model.Tasca;

public interface IAfegirTasca {

    interface View{
        void changeActivity();

    }

    interface Presenter{
        void changeActivity();

        void createTasca(Tasca tasca);

    }

    interface Model{
        void createTasca(Tasca tasca);
    }
}
