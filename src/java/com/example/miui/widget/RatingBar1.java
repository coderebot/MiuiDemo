/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget;

import miui.app.Activity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.miui.R;

/**
 * Demonstrates how to use a rating bar
 */
public class RatingBar1 extends Activity implements RatingBar.OnRatingBarChangeListener {
    RatingBar mSmallRatingBar;
    RatingBar mIndicatorRatingBar;
    TextView mRatingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ratingbar_1);

        mRatingText = (TextView) findViewById(R.id.rating);

        // We copy the most recently changed rating on to these indicator-only
        // rating bars
        mIndicatorRatingBar = (RatingBar) findViewById(R.id.indicator_ratingbar);
        mSmallRatingBar = (RatingBar) findViewById(R.id.small_ratingbar);

        // The different rating bars in the layout. Assign the listener to us.
        ((RatingBar)findViewById(R.id.ratingbar1)).setOnRatingBarChangeListener(this);
        ((RatingBar)findViewById(R.id.ratingbar2)).setOnRatingBarChangeListener(this);
    }

    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromTouch) {
        final int numStars = ratingBar.getNumStars();
        mRatingText.setText(
                getString(R.string.ratingbar_rating) + " " + rating + "/" + numStars);

        // Since this rating bar is updated to reflect any of the other rating
        // bars, we should update it to the current values.
        if (mIndicatorRatingBar.getNumStars() != numStars) {
            mIndicatorRatingBar.setNumStars(numStars);
            mSmallRatingBar.setNumStars(numStars);
        }
        if (mIndicatorRatingBar.getRating() != rating) {
            mIndicatorRatingBar.setRating(rating);
            mSmallRatingBar.setRating(rating);
        }
        final float ratingBarStepSize = ratingBar.getStepSize();
        if (mIndicatorRatingBar.getStepSize() != ratingBarStepSize) {
            mIndicatorRatingBar.setStepSize(ratingBarStepSize);
            mSmallRatingBar.setStepSize(ratingBarStepSize);
        }
    }

}
