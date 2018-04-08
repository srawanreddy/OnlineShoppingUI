package com.example.sravanreddy.onlineshoppingui;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

/**
 * Created by sravanreddy on 4/7/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final  int TYPE_HEAD=0;
    private static final  int TYPE_LIST=1;
    public static int span;
    List<Products> myList;
    Context context;

    public MyAdapter(List<Products> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View headerLayout=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, null);
        span=2;
        return new MyViewHolder(headerLayout, viewType);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //if(holder.viewType==TYPE_LIST){
    final Products product=myList.get(position);
    holder.mainText.setText(product.getMainText());
    holder.subText.setText(product.getSubText());
    holder.imageView.setImageResource(product.getImage());//}
     if(holder.viewType==TYPE_HEAD){
         StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
         layoutParams.setFullSpan(true);
         holder.itemView.setLayoutParams(layoutParams);
        }

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, holder.mainText.getText().toString()+" is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return TYPE_HEAD;
        else
            return TYPE_LIST;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        int viewType;
        TextView mainText, subText;
        ConstraintLayout constraintLayout;
        ImageView imageView, headerImage;
        public MyViewHolder(View itemView, int viewType) {
            super(itemView);
            mainText=itemView.findViewById(R.id.main_textView);
                subText=itemView.findViewById(R.id.subText);
                imageView=itemView.findViewById(R.id.imageView);
                constraintLayout=itemView.findViewById(R.id.list_layout);
                 this.viewType=viewType;

        }
    }
}
