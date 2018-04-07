package diklat.com.bps.sihaluan.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import diklat.com.bps.sihaluan.R;

/**
 * Created by sabithuraira on 3/20/17.
 */
public class HomeAdapter extends BaseAdapter {


//    private String[] list_color={"#22B0F2","#F25023","#19A050"};

    private List<String> datas=new ArrayList<String>();
    private List<String> descs=new ArrayList<String>();
    private LayoutInflater mInflater;

    public HomeAdapter(Context context, List<String> datas, List<String> descs){
        this.mInflater=LayoutInflater.from(context);
        this.datas = datas;
        this.descs = descs;
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
        String d = descs.get(position);

        if (p != null) {
            LinearLayout linearLayout=(LinearLayout)v.findViewById(R.id.layoutItem);

//            if(position<3){
//                linearLayout.setBackgroundColor(Color.parseColor(list_color[position]));
//            }

            TextView title = (TextView) v.findViewById(R.id.lblListItem);
//            title.setTextColor(Color.parseColor("#ffffff"));

            TextView desc = (TextView) v.findViewById(R.id.lblListDesc);

            if (title != null && desc != null) {
                title.setText(p);
                desc.setText(d);
            }
        }

        return v;
    }

}