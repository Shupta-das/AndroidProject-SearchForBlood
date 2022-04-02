package com.example.searchforblood;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsed="";
    String singleParsed="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL("https://api.myjson.com/bins/k47bw");
            HttpsURLConnection httpsURLConnection= (HttpsURLConnection) url.openConnection();
            InputStream inputStream=httpsURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null)
            {
                line=bufferedReader.readLine();
                data=data+line;
            }
            JSONArray JA =new JSONArray(data);
            for(int i=0;i<JA.length();i++)
            {
                JSONObject JO= (JSONObject) JA.get(i);
                singleParsed = "Warning: "+JO.get("warning")+"\n"+"\n"+"\n"+
                        "High Risks : "+JO.get("highRisk")+"\n"+"\n"+"\n"+
                        "Eligibility: "+JO.get("eligibility")+"\n"+"\n"+"\n"+
                        "Food and Medications : "+JO.get("foodAndMedications")+"\n"+"\n"+"\n"+
                        "After donation procedure : "+JO.get("afterDonation")+"\n";

                dataParsed=dataParsed+singleParsed;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        WarningJsonActivity.data.setText(this.dataParsed);
    }
}
