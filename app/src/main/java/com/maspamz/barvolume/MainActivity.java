package com.maspamz.barvolume;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Spinner spinnerbar;
    private Button buttonview, buttonhitungbalok, buttonhitungkubus, buttonhitungbola;
    private ViewFlipper vfview;
    private EditText epanjangb, elebarb, etinggib, ksisi, bradius;
    private TextView bhasil,khasil,bolhasil;
    //Include include;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //delarasi tombol
        spinnerbar = (Spinner) findViewById(R.id.spinner);
        buttonview = (Button) findViewById(R.id.btn_selectbar);
        vfview = (ViewFlipper) findViewById(R.id.vf_barvolume);

        //EditText Balok
        epanjangb = (EditText) findViewById(R.id.bpanjang);
        elebarb = (EditText) findViewById(R.id.blebar);
        etinggib = (EditText) findViewById(R.id.btinggi);
        bhasil = (TextView) findViewById(R.id.bhasil);
        buttonhitungbalok =(Button) findViewById(R.id.btn_hitung_balok);

        //EditText Kubus
        ksisi = (EditText) findViewById(R.id.ksisi);
        khasil = (TextView) findViewById(R.id.khasil);
        buttonhitungkubus =(Button) findViewById(R.id.btn_hitung_kubus);

        //EditText Bola
        bradius = (EditText) findViewById(R.id.bradius);
        bolhasil = (TextView) findViewById(R.id.bolhasil);
        buttonhitungbola =(Button) findViewById(R.id.btn_hitung_bola);

        buttonview.setOnClickListener(this);
        buttonhitungbalok.setOnClickListener(this);
        buttonhitungkubus.setOnClickListener(this);
        buttonhitungbola.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_selectbar){
            String GetDataSpinner = spinnerbar.getSelectedItem().toString();

            //alert
            /*AlertDialog.Builder alertDialogku=new AlertDialog.Builder(this);
            alertDialogku.setTitle("Pemberitahuan")
                    .setIcon(R.mipmap.ic_launcher)
                    .setMessage("Kubusku")
                    .setNeutralButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //kosong
                        }
                    })
                    .show();*/

            if(GetDataSpinner.equals("Kubus")){
                vfview.setDisplayedChild(1);
            }
            else if(GetDataSpinner.equals("Balok")){
                vfview.setDisplayedChild(2);
            }
            else if(GetDataSpinner.equals("Bola")){
                vfview.setDisplayedChild(3);
            }
            else{
                //Toast.makeText(this,GetDataSpinner+"kux",Toast.LENGTH_SHORT).show();
                vfview.setDisplayedChild(0);
            }

        }

        if (v.getId() == R.id.btn_hitung_kubus){
            int sisi = Integer.parseInt(ksisi.getText().toString());
            int hasil = sisi*sisi*sisi;
            khasil.setText(String.valueOf(hasil)+" cm3");
        }

        if (v.getId() == R.id.btn_hitung_balok){
            int panjang = Integer.parseInt(epanjangb.getText().toString());
            int lebar = Integer.parseInt(elebarb.getText().toString());
            int tinggi = Integer.parseInt(etinggib.getText().toString());
            int hasil = panjang*lebar*tinggi;
            bhasil.setText(String.valueOf(hasil)+" cm3");
        }

        if (v.getId() == R.id.btn_hitung_kubus){
            int sisi = Integer.parseInt(ksisi.getText().toString());
            int hasil = sisi*sisi*sisi;
            khasil.setText(String.valueOf(hasil)+" cm3");
        }

        if (v.getId() == R.id.btn_hitung_bola){
            double radius = Integer.parseInt(bradius.getText().toString());
            double hasil = (4*22*radius*radius*radius)/(3*7);
            bolhasil.setText(String.format("%2f",hasil)+" cm3");
        }

        

    }
}
