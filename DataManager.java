package examen.victor.me.examenpis;

import java.util.ArrayList;
import java.util.Iterator;

import examen.victor.me.examenpis.model.Tasca;

public class DataManager {

    private static DataManager instance;
    private ArrayList<Tasca> tasques = new ArrayList<>();



    public DataManager() {
    }

    public void updateTasca(Tasca tasca){
        Tasca sr = this.getTascaById(tasca.getId());
        System.out.println(sr.toString());
        if(sr != null){
            sr.copyAttrs(tasca);
        }

    }

    public Tasca getTascaById(String id) {
        Tasca tasca = null;
        Iterator iterator = this.tasques.iterator();
        boolean found = false;
        while (iterator.hasNext() && !found) {
            Tasca sr = (Tasca) iterator.next();
            if (sr.getId().equalsIgnoreCase(id)) {
                tasca = sr;
                found = true;
            }
        }
        return tasca;
    }



    public void addTasca(Tasca tasca){
        this.tasques.add(tasca);
    }

    public ArrayList<Tasca> getTasques() {
        return tasques;
    }

    /**
     * Singleton FoodDataHandler
     * @return FoodDataHandler instance
     */
    public static DataManager getDataManager(){
        synchronized (DataManager.class) {
            if (instance == null)
                instance = new DataManager();
        }
        return instance;
    }
}
