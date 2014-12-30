package com.o3dr.android.dp.wear.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.wearable.view.CircledImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.o3dr.android.client.Drone;
import com.o3dr.android.dp.wear.R;

/**
 * Created by fhuya on 11/17/14.
 */
public abstract class BaseActionFragment extends Fragment implements View.OnClickListener {


    protected Drone getDrone(){
        return null;
    }

    protected void showUser(String message){
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_action_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final CircledImageView faveImage = (CircledImageView) view.findViewById(R.id
                .listing_action_image);
        if (faveImage != null) {
            faveImage.setImageResource(getActionImageResource());
            faveImage.setOnClickListener(this);
        }

        final TextView faveLabel = (TextView) view.findViewById(R.id.listing_action_label);
        if (faveLabel != null) {
            faveLabel.setText(getActionLabelResource());
        }
    }

    protected abstract int getActionImageResource();

    protected abstract int getActionLabelResource();

    protected abstract void onActionClicked();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.listing_action_image:
                onActionClicked();
                break;
        }
    }

}