package diklat.oi.bps.oiapp.components;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

    /*
    public SimpleAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public SimpleAdapter(Context context, int resource, List<SimpleData> items) {
        super(context, resource, items);
    }
    */

    public SimpleAdapter(Context context, List<SimpleData> datas){
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

        if (v == null) {
            v = this.mInflater.inflate(R.layout.list_simple, null);
        }

        SimpleData p = datas.get(position);

        if (p != null) {
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

        return v;
    }

}