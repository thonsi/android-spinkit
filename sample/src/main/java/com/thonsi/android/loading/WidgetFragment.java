package com.thonsi.android.loading;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.thonsi.android.spinkit.style.ChasingDots;
import com.thonsi.android.spinkit.style.Circle;
import com.thonsi.android.spinkit.style.DoubleBounce;
import com.thonsi.android.spinkit.style.Wave;

public class WidgetFragment extends Fragment implements Colors {

    private Wave mWaveDrawable;
    private Circle mCircleDrawable;
    private ChasingDots mChasingDotsDrawable;

    public static WidgetFragment newInstance() {
        return new WidgetFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_widget, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ProgressBar
        ProgressBar progressBar = view.findViewById(R.id.progress);
        DoubleBounce doubleBounce = new DoubleBounce();
        doubleBounce.setBounds(0, 0, 100, 100);
        doubleBounce.setColor(colors[7]);
        progressBar.setIndeterminateDrawable(doubleBounce);

        //Button
        Button button = view.findViewById(R.id.button);
        mWaveDrawable = new Wave();
        mWaveDrawable.setBounds(0, 0, 100, 100);
        mWaveDrawable.setColor(getResources().getColor(R.color.colorAccent));
        button.setCompoundDrawables(mWaveDrawable, null, null, null);

        //TextView
        TextView textView = view.findViewById(R.id.text);
        mCircleDrawable = new Circle();
        mCircleDrawable.setBounds(0, 0, 100, 100);
        mCircleDrawable.setColor(Color.WHITE);
        textView.setCompoundDrawables(null, null, mCircleDrawable, null);
        textView.setBackgroundColor(colors[2]);

        //ImageView
        ImageView imageView = view.findViewById(R.id.image);
        mChasingDotsDrawable = new ChasingDots();
        mChasingDotsDrawable.setColor(Color.WHITE);
        imageView.setImageDrawable(mChasingDotsDrawable);
        imageView.setBackgroundColor(colors[0]);
    }

    @Override
    public void onResume() {
        super.onResume();
        mWaveDrawable.start();
        mCircleDrawable.start();
        mChasingDotsDrawable.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mWaveDrawable.stop();
        mCircleDrawable.stop();
        mChasingDotsDrawable.stop();
    }
}
