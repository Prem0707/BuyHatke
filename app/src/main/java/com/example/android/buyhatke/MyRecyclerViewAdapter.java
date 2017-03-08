package com.example.android.buyhatke;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by Prem on 22-01-2017.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    List<AnArticle> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context, List<AnArticle> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        AnArticle current = data.get(i);
        Uri uri = Uri.parse(current.imageUrl);
        Context context = myViewHolder.articleImage.getContext();
        Picasso.with(context).load(uri)
                .into(myViewHolder.articleImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView articleImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            articleImage = (ImageView) itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(HomeActivity.myOnClickListener);
        }

    }
}
