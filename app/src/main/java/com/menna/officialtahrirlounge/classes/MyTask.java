package com.menna.officialtahrirlounge.classes;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by menna on 9/13/2017.
 */

public class MyTask extends AsyncTask<Void,Integer,String>
{
    Context context;
    TextView textView;
    ProgressBar progressBar;

    MyTask(Context context, TextView textView, ProgressBar progressBar)
    {
        this.context=context;
        this.textView=textView;
        this.progressBar=progressBar;
    }


    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        progressBar.setMax(10);

    }

    @Override
    protected String  doInBackground(Void... params)
    {
        int i =0;
        synchronized (this)
        {
            while(i<10)
            {
                try
                {
                wait(1500);
                   i++;
                    publishProgress(i);
                }
                catch (InterruptedException e)
                {

                    e.printStackTrace();
                }
            }
        }
        return "Loading Compelete";
    }



    @Override
    protected void onPostExecute(String Result)
    {
        textView.setText(Result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
        textView.setText("Loading...");
    }
}
