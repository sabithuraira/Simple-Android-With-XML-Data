package diklat.oi.bps.oiapp.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import diklat.oi.bps.oiapp.R;
/**
 * Created by sabithuraira on 3/2/17.
 */

public class SimpleFragment extends Fragment {
    String data="";
    private TextView txtView;

    public SimpleFragment(){

    }

    public void SetTextData(String data) {
        // Required empty public constructor
        this.data=data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Inflate the layout for this fragment

        txtView=(TextView) getView().findViewById(R.id.textView2);
        txtView.setMovementMethod(new ScrollingMovementMethod());
        if (getArguments() != null) {
            this.data=this.getArguments().getString("txt_aboutus");
        }

        //this.data="<h2>Title</h2><br><p>Description here</p>";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            txtView.setText(Html.fromHtml(this.data, Html.FROM_HTML_MODE_COMPACT));
        else
            txtView.setText(Html.fromHtml(this.data));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }
}
