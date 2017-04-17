package diklat.oi.bps.oiapp.components;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import diklat.oi.bps.oiapp.R;
import diklat.oi.bps.oiapp.models.SimpleData;

/**
 * Created by sabithuraira on 3/20/17.
 */
public class SimpleAdapter extends BaseAdapter {

    private List<SimpleData> datas=new ArrayList<SimpleData>();
    private LayoutInflater mInflater;
    private Context context;

    /*
    public SimpleAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public SimpleAdapter(Context context, int resource, List<SimpleData> items) {
        super(context, resource, items);
    }
    */

    public SimpleAdapter(Context context, List<SimpleData> datas){
        this.context=context;
        this.mInflater=LayoutInflater.from(context);
        this.datas=datas;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        SimpleData p = datas.get(position);

        //if (v == null) {
        if(p!=null && p.getTitle().length()==0){
            v = this.mInflater.inflate(R.layout.list_image, null);
        }
        else{
            v = this.mInflater.inflate(R.layout.list_simple, null);
        }
        //}

        if(p!=null){
            if(p.getTitle().length()==0){
                String[] split = p.getDeskripsi().split(";");

                ImageView img=(ImageView) v.findViewById(R.id.img_grid);
                TextView nama=(TextView) v.findViewById(R.id.nama);
                TextView jabatan=(TextView) v.findViewById(R.id.jabatan);

                Resources r = this.context.getResources();
                int imageId = r.getIdentifier(split[0], "mipmap", this.context.getPackageName());

                if(imageId!=0)
                    img.setImageResource(imageId);

                if(split.length==3){
                    nama.setText(split[1]);
                    jabatan.setText(split[2]);
                }
            }
            else {
                TextView title = (TextView) v.findViewById(R.id.title);
                TextView deskripsi = (TextView) v.findViewById(R.id.deskripsi);

                if (title != null) {
                    title.setText(p.getTitle());
                }

                if (deskripsi != null) {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                        deskripsi.setText(Html.fromHtml(p.getDeskripsi(), Html.FROM_HTML_MODE_COMPACT));
                    else
                        deskripsi.setText(Html.fromHtml(p.getDeskripsi()));
                }
            }
        }

        return v;
    }
}