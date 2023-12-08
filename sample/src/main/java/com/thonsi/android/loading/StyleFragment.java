package com.thonsi.android.loading;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thonsi.android.spinkit.SpinKitView;
import com.thonsi.android.spinkit.SpriteFactory;
import com.thonsi.android.spinkit.Style;
import com.thonsi.android.spinkit.sprite.Sprite;

public class StyleFragment extends Fragment implements Colors {

    public static StyleFragment newInstance() {
        return new StyleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_style, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.list);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new RecyclerView.Adapter<Holder>() {
            @NonNull
            @Override
            public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_style, null);
                return new Holder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull Holder holder, int position) {
                holder.bind(position);
            }

            @Override
            public int getItemCount() {
                return Style.values().length;
            }
        });
    }

    static class Holder extends RecyclerView.ViewHolder {

        SpinKitView spinKitView;

        public Holder(View itemView) {
            super(itemView);
            spinKitView = itemView.findViewById(R.id.spin_kit);
        }

        public void bind(int position) {
            itemView.setBackgroundColor(colors[position % colors.length]);
            final int finalPosition = position;
            itemView.setOnClickListener(v -> DetailActivity.start(v.getContext(), finalPosition));
            position = position % 15;
            Style style = Style.values()[position];
            Sprite drawable = SpriteFactory.create(style);
            spinKitView.setIndeterminateDrawable(drawable);
        }
    }

}
