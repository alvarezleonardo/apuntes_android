package com.example.leonardo.vacio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import com.twitter.sdk.android.tweetcomposer.TweetUploadService;

/**
 * Created by leona on 8/11/2016.
 */

public class MyReceiver extends BroadcastReceiver {
    Bundle intentExtras = new Bundle();
    @Override
    public void onReceive(Context context, Intent intent) {
        if (TweetUploadService.UPLOAD_SUCCESS.equals(intent.getAction())) {
            // success
            final Long tweetId = intentExtras.getLong(TweetUploadService.EXTRA_TWEET_ID);
        } else {
            // failure
            final Intent retryIntent = intentExtras.getParcelable(TweetUploadService.EXTRA_RETRY_INTENT);
        }
    }
}
