package com.example.myapplication.data.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpManager {

    public static boolean isOnline(Context context  ){


        ConnectivityManager cm=
                (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo=cm.getActiveNetworkInfo();
        if(netinfo !=null && netinfo.isConnected()){
            return true;
        }
        else
            return false;

    }





    public static String getDataHttpUrlConnection(RequestPackage rp)
    {
        String uri=rp.getUri();
        if(rp.getMethod().equals("GET")){
            uri +="?"+rp.getEncodedParams();
        }
        try {
            URL url=new URL(uri);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod(rp.getMethod());
            if(rp.getMethod().equals("POST")){
                connection.setDoOutput(true);
                OutputStreamWriter writer=new OutputStreamWriter(connection.getOutputStream());
                writer.write(rp.getEncodedParams());
                writer.flush();
            }
            BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null)
            {
                sb.append(line);
            }
            return sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class RequestPackage{
        private String uri;
        private String method;
        private Map<String,String> params;


        public RequestPackage(){
            this.uri="";
            this.method="GET";
            this.params=new HashMap<String, String>();


        }


        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public Map<String, String> getParams() {
            return params;
        }

        public void setParams(Map<String, String> params) {
            this.params = params;
        }


        public void setparameter(String key,String value){
            params.put(key, value);
        }

        public String getEncodedParams(){
            StringBuilder sb=new StringBuilder();

            for(String key:params.keySet()){
                try {
                    String value= URLEncoder.encode(params.get(key),"UTF-8");
                    if(sb.length()>0){
                        sb.append('&');
                    }
                    sb.append(key+"="+value);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
            return sb.toString();        }


    }
}
