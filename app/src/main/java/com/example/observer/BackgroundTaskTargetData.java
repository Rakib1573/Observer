package com.example.observer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTaskTargetData extends AsyncTask<String, Void, String> {

    AlertDialog dialog;
    Context context;
    public Boolean login = false;
    public BackgroundTaskTargetData(Context context)
    {
        this.context = context;
    }
    String s="Data Sending successful";
    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("DATA SENT");
    }
    @Override
    protected void onPostExecute(String s) {
        dialog.setMessage(s);
        dialog.show();

    }
    @Override
    protected String doInBackground(String... params) {
        String result = "";
        String Tgt_Easting = params[0];
        String Tgt_Northing = params[1];
       // String Gun_Easting = params[2];
        //String Gun_nothing = params[3];
        //String ZLbg = params[4];
        //String ZL_deg_mil = params[5];
        //String OTbg = params[6];
        //String OT_deg_mil = params[7];
        //String corr_rt_lt = params[8];
        //String corr_add_drop = params[9];

        String connstr = "http://192.168.0.101:8080/ifcs/login.php";
        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("Tgt_Easting","UTF-8")+"="+ URLEncoder.encode(Tgt_Easting,"UTF-8")
                    +"&&"+ URLEncoder.encode("Tgt_Northing","UTF-8")+"="+ URLEncoder.encode(Tgt_Northing,"UTF-8");
                   // +"&&"+ URLEncoder.encode("Gun_Easting","UTF-8")+"="+ URLEncoder.encode(Gun_Easting,"UTF-8")
                    //+"&&"+ URLEncoder.encode("Gun_nothing","UTF-8")+"="+ URLEncoder.encode(Gun_nothing,"UTF-8")
                    //+"&&"+ URLEncoder.encode("ZLbg","UTF-8")+"="+ URLEncoder.encode(ZLbg,"UTF-8")
                    //+"&&"+ URLEncoder.encode("ZL_deg_mil","UTF-8")+"="+ URLEncoder.encode(ZL_deg_mil,"UTF-8")
                    //+"&&"+ URLEncoder.encode("OTbg","UTF-8")+"="+ URLEncoder.encode(OTbg,"UTF-8")
                    //+"&&"+ URLEncoder.encode("OT_deg_mil","UTF-8")+"="+ URLEncoder.encode(OT_deg_mil,"UTF-8")
                    //+"&&"+ URLEncoder.encode("corr_rt_lt","UTF-8")+"="+ URLEncoder.encode(corr_rt_lt,"UTF-8")
                    //+"&&"+ URLEncoder.encode("corr_add_drop","UTF-8")+"="+ URLEncoder.encode(corr_add_drop,"UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"UTF-8"));
            String line ="";
            while ((line = reader.readLine()) != null)
            {
                result += line + line +"\n";
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }


        return result;
    }
}
