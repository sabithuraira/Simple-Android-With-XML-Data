package diklat.com.bps.sihaluan.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import diklat.com.bps.sihaluan.R;
import diklat.com.bps.sihaluan.helpers.JustifiedTextView;
import me.biubiubiu.justifytext.library.JustifyTextView;

/**
 * Created by sabithuraira on 3/2/17.
 */

public class SimpleFragment extends Fragment {
    String data="";
//    private JustifyTextView txtView;

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

//        txtView=(JustifyTextView) getView().findViewById(R.id.textView2);
//        txtView.setMovementMethod(new ScrollingMovementMethod());
        if (getArguments() != null) {
            this.data=this.getArguments().getString("txt_aboutus");
        }

        Spanned data_text;
        //this.data="<h2>Title</h2><br><p>Description here</p>";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            data_text = Html.fromHtml(this.data, Html.FROM_HTML_MODE_COMPACT);
        else
            data_text = Html.fromHtml(this.data);

//        txtView.setText(data_text.toString());


        ScrollView scrollView=new ScrollView(this.getActivity());
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT ));

        JustifiedTextView jtv= new JustifiedTextView(this.getActivity(),data_text.toString());
//        jtv.setMovementMethod(new ScrollingMovementMethod());
        LinearLayout place = (LinearLayout) getView().findViewById(R.id.relativeLayout);

        scrollView.addView(jtv);
        place.addView(scrollView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }
}
