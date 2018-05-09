package com.codingblocks.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.widget.Toast;

public class DemoJob extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        Toast.makeText(this,"Hello, I'm a scheduled Job",Toast.LENGTH_SHORT).show();

        //Execute an Async job

//        jobFinished(params,false);

        return false;  //This true means that there is work still going on, so don't finish this Service just yet
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
