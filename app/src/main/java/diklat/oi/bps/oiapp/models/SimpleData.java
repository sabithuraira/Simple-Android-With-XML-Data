package diklat.oi.bps.oiapp.models;

/**
 * Created by sabithuraira on 3/20/17.
 */

public class SimpleData {
    private String title;
    private String deskripsi;

    public SimpleData(String title, String deskripsi){
        this.title=title;
        this.deskripsi=deskripsi;
    }

    public String getTitle() {
        return title;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
