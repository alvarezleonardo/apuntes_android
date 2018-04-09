package com.example.digitalhouse.testtwitternoche;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.twitter.sdk.android.tweetcomposer.TweetUploadService;

/**
 * Created by digitalhouse on 08/11/16.
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        if (TweetUploadService.UPLOAD_SUCCESS.equals(intent.getAction())) {
            // success
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            final Long tweetId = intentExtras.getLong(TweetUploadService.EXTRA_TWEET_ID);
        } else {
            // failure
            Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
            final Intent retryIntent = intentExtras.getParcelable(TweetUploadService.EXTRA_RETRY_INTENT);
        }
    }

}
