package diklat.oi.bps.oiapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.Arrays;

import diklat.oi.bps.oiapp.components.HomeAdapter;
import diklat.oi.bps.oiapp.components.HomeImageAdapter;

public class Main2Activity extends AppCompatActivity {

    private HomeImageAdapter adapter;
//    private ListView listView;
    private GridView gridView;
    private Button ttg_kami;
    private Button kontak_kami;
    private String[] datas= {"Data Strategis", "Data Lainnya"};
    private String[] descs= {
            "Berisi data yang bersumber dari BPS Kabupaten OKU Timur",
            "Berisi data sektoral yang bersumber dari instansi, badan atau lembaga di luar Badan Pusat Statistik",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        listView = (ListView) findViewById(R.id.listView);

//        getActionBar().hide();
        gridView = (GridView) findViewById(R.id.gridview);
        ttg_kami = (Button) findViewById(R.id.ttg_kami);
        kontak_kami = (Button) findViewById(R.id.kontak_kami);

        adapter = new HomeImageAdapter(this, Arrays.asList(datas), Arrays.asList(descs));
//        listView.setAdapter(adapter);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(Main2Activity.this, DataMenuActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(Main2Activity.this, DataSpinnerActivity.class);
                        startActivity(intent1);
                        break;
//                    case 2:
//                        Intent intent2 = new Intent(Main2Activity.this, KecActivity.class);
//                        startActivity(intent2);
//                        break;
                }
            }
        });

        ttg_kami.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        kontak_kami.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DialogFragment dialog = new FDialog();
                dialog.show(getSupportFragmentManager(), "FDialog");
            }
        });

        //setListAdapter(adapter);
        //getListView().setOnItemClickListener(this);
    }


    public static class FDialog extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Get the layout inflater
            LayoutInflater inflater = getActivity().getLayoutInflater();

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialog_kontak, null))

                    .setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            FDialog.this.getDialog().cancel();
                        }
                    });
            return builder.create();
        }
    }
}
