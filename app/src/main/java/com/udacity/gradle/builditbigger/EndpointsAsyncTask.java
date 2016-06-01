package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.android.tofi.mohammad.myandroidlib.JokeDisplay;
import com.example.GetJoke;
import com.example.hamzak.myapplication.backend.myApi.MyApi;
import com.example.hamzak.myapplication.backend.myApi.model.MyBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by hamzaK on 27.5.2016.
 */
public class EndpointsAsyncTask extends AsyncTask<OnReceiveListener, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private OnReceiveListener listener;

    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(OnReceiveListener... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //              /*   .setRootUrl("http://10.0.2.2:8080/_ah/api/")

                    .setRootUrl("https://builditbigger-1294.appspot.com/_ah/api/");
                    /*.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });*/
            // end options for devappserver

            myApiService = builder.build();
        }
        listener = params[0];

       /* context = params[0].first;
        String name = params[0].second;*/

        try {
            return myApiService.sayHi(new MyBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

           // if(listener!=null)
        listener.OnReceive(result);
    }


}
