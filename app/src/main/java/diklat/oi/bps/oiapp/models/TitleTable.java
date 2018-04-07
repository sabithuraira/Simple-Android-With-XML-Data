package diklat.oi.bps.oiapp.models;

/**
 * Created by sabithuraira on 4/2/18.
 */

public class TitleTable {
    private String title;
    private String[] header;

    public TitleTable(String title, String[] header){
        this.title = title;
        this.header = header;
    }

    public String getTitle() {
        return title;
    }

    public String[] getHeader() {
            return header;
        }
}