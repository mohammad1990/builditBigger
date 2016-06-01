package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

/**
 * Created by hamzaK on 27.5.2016.
 */
public class NonEmptyString extends AndroidTestCase {
    EndpointsAsyncTask endpointsAsyncTask;
    private static final String LOG_TAG = "NonEmptyStringTest";
    public void testResponseDate() {
        String result = null;
        endpointsAsyncTask= new EndpointsAsyncTask(getContext());
        endpointsAsyncTask.execute();
        try
        {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertNotNull(result);
        //endpointsAsyncTask = (EndpointsAsyncTask) new EndpointsAsyncTask(getContext()).execute();
    }
}
