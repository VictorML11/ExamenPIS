package examen.victor.me.examenpis.model;

import java.io.Serializable;
import java.util.UUID;

public class Tasca implements Serializable{

    private String id;
    private String nom;
    private String data;
    private String assumpte;
    private String tipus;
    private boolean acabada;

    public Tasca() {
    }

    public Tasca(String nom, String data, String assumpte, String tipus, boolean acabada) {
        this.id = UUID.randomUUID().toString();
        this.nom = nom;
        this.data = data;
        this.assumpte = assumpte;
        this.tipus = tipus;
        this.acabada = acabada;
    }

    public Tasca(String id, String nom, String data, String assumpte, String tipus, boolean acabada) {
        this.id = id;
        this.nom = nom;
        this.data = data;
        this.assumpte = assumpte;
        this.tipus = tipus;
        this.acabada = acabada;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAssumpte() {
        return assumpte;
    }

    public void setAssumpte(String assumpte) {
        this.assumpte = assumpte;
    }

    public boolean isAcabada() {
        return acabada;
    }

    public void setAcabada(boolean acabada) {
        this.acabada = acabada;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void copyAttrs(Tasca tasca){
        this.id = tasca.getId();
        this.nom = tasca.getNom();
        this.data = tasca.getData();
        this.assumpte = tasca.getAssumpte();
        this.tipus = tasca.getTipus();
        this.acabada = tasca.isAcabada();
    }

    @Override
    public String toString() {
        return "Tasca{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", data='" + data + '\'' +
                ", assumpte='" + assumpte + '\'' +
                ", tipus='" + tipus + '\'' +
                ", acabada=" + acabada +
                '}';
    }
}
