package com.doplesillo.httprequest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    TextView txtId;
    TextView txtContent;
    Button btnRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.txtId);
        txtContent = findViewById(R.id.txtContend);
        btnRefresh = findViewById(R.id.btnRefresh);

        //Evento onClick
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new HTTPRequestTask().execute();
            }
        });
    }
    private class HTTPRequestTask extends AsyncTask<Void,Void,Greeting>{

        @Override
        protected Greeting doInBackground(Void... voids) {
            try{
                //URL del web Service
                String url = "http://rest-service.guides.spring.io/greeting";
                //Utilizar Mapping
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Greeting greeting = restTemplate.getForObject(url,Greeting.class );
                return greeting;
            } catch (Exception e){
                Log.e("Dople::",e.getMessage(),e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Greeting greeting) {
            super.onPostExecute(greeting);
            txtId.setText(greeting.getId());
            txtContent.setText(greeting.getContent());
        }
    }

}

class Greeting {
    private String id;
    private String content;


    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}