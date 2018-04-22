package diklat.com.bps.sihaluan.components;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import diklat.com.bps.sihaluan.R;

/**
 * Created by sabithuraira on 3/23/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String[] data;

    private String[] list_color={"#46B04A", "#00A1EA"};

    public ImageAdapter(Context c, String[] data) {

        mContext = c;
        this.data=data;
    }

    public int getCount() {
        return data.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(185, 185));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
        */

        View myView;

        LayoutInflater li = ((Activity) mContext).getLayoutInflater();
        myView = li.inflate(R.layout.grid_layout, null);

        RelativeLayout relativeLayout=(RelativeLayout) myView.findViewById(R.id.relaGrid);
        int color_index=position%2;

        relativeLayout.setBackgroundColor(Color.parseColor(list_color[color_index]));

        ImageView img = (ImageView) myView.findViewById(R.id.img_grid);
        TextView txt = (TextView) myView.findViewById(R.id.txt_grid);


        String rsrc=(data[position].toLowerCase()).replace(' ','_');

        Resources r = this.mContext.getResources();
        int imageId = r.getIdentifier(rsrc, "mipmap", this.mContext.getPackageName());

        //this.createTable(r.getStringArray(titleId),r.getStringArray(dataId));
        img.setImageResource(imageId);
        txt.setText(data[position]);
        txt.setTypeface(null, Typeface.BOLD);

        return myView;
    }
}

