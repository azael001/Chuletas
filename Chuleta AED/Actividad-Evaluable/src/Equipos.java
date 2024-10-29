import java.util.ArrayList;

public class Equipos {
    int nClub;
    String nomClub;
    String president;
    String tel ;
    String local;


    public Equipos(int nClub,  String nomClub,String president, String tel, String local) {
        this.nClub = nClub;
        this.nomClub = nomClub;
        this.president = president;
        this.tel = tel;
        this.local = local;

    }

    public int getnClub() {
        return nClub;
    }

    public void setnClub(int nClub) {
        this.nClub = nClub;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }


    @Override
    public String toString() {
        return "Equipos{" +
                "nClub=" + nClub +
                ", nomClub='" + nomClub + '\'' +
                ", president='" + president + '\'' +
                ", tel='" + tel + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
