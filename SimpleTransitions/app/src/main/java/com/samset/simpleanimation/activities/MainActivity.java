package com.samset.simpleanimation.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.os.Bundle;

import android.util.Pair;
import android.view.View;
import android.widget.TextView;


import com.samset.simpleanimation.R;

import java.util.List;


public class MainActivity extends Activity {

    View first, second, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = findViewById(R.id.hello);
        second = findViewById(R.id.sam);
        image = findViewById(R.id.img);
        setExitSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
                findViewById(R.id.hello).setTranslationZ(0);

            }
        });
    }

    public void clicked(View view) {

        /*Pair<View, String> pair1 = Pair.create(first, first.getTransitionName());
        Pair<View, String> pair2 = Pair.create(second, second.getTransitionName());
          // first options you can also use this class
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair1, pair2);*/

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                new Pair(first, getResources().getString(R.string.first_transition)),
                new Pair(first, getResources().getString(R.string.second_transition)),
                new Pair(image, getResources().getString(R.string.images_transition)));
        Intent intent = new Intent(this, TargetActivity.class);
        startActivity(intent, options.toBundle());
        first.setTranslationZ(16);
        second.setTranslationZ(16);
        //image.setTranslationZ(25);
    }
}
