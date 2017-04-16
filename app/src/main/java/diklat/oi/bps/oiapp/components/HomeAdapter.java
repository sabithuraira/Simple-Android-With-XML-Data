package diklat.oi.bps.oiapp.components;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import diklat.oi.bps.oiapp.R;
import diklat.oi.bps.oiapp.models.SimpleData;

/**
 * Created by sabithuraira on 3/20/17.
 */
public class HomeAdapter extends BaseAdapter {


    private String[] list_color={"#22B0F2","#F25023","#19A050"};

    private List<String> datas=new ArrayList<String>();
    private LayoutInflater mInflater;

    public HomeAdapter(Context context, List<String> datas){
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

        //if (v == null) {
        v = this.mInflater.inflate(R.layout.list_item, null);
        //}

        String p = datas.get(position);

        if (p != null) {
            LinearLayout linearLayout=(LinearLayout)v.findViewById(R.id.layoutItem);

            if(position<3){
                linearLayout.setBackgroundColor(Color.parseColor(list_color[position]));
            }

            TextView title = (TextView) v.findViewById(R.id.lblListItem);
            title.setTextColor(Color.parseColor("#ffffff"));

            if (title != null) {
                title.setText(p);
            }
        }

        return v;
    }

}