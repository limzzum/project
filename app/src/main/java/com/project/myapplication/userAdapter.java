//package com.project.myapplication;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//
//import java.util.ArrayList;
//
//public class userAdapter extends RecyclerView.Adapter<userAdapter.CustomViewHolder> {
//
//    private ArrayList<user1> arrayList;
//    private Context context;
//
//    public userAdapter(ArrayList<user1> arrayList, Context context) {
//        this.arrayList = arrayList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public userAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
//        CustomViewHolder holder= new CustomViewHolder(view);
//
//
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull userAdapter.CustomViewHolder holder, int position) {
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).profile)
//                .into(holder.iv_profile);
//        holder.tv_userId.setText(arrayList.get(position).userId);
//        holder.tv_username.setText(arrayList.get(position).username);
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).postImg)
//                .into(holder.iv_post_img);
//        holder.tv_post_content.setText(arrayList.get(position).postContent);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return (arrayList!=null? arrayList.size():0);
//    }
//
//    public class CustomViewHolder extends RecyclerView.ViewHolder {
//        ImageView iv_profile;
//        TextView tv_userId;
//        TextView tv_username;
//        ImageView iv_post_img;
//        TextView tv_post_content;
//        public CustomViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.iv_profile=itemView.findViewById(R.id.profile);
//            this.tv_userId=itemView.findViewById(R.id.userId);
//            this.tv_username=itemView.findViewById(R.id.username);
//            this.iv_post_img=itemView.findViewById(R.id.postImg);
//            this.tv_post_content=itemView.findViewById(R.id.postContent);
//
//        }
//    }
//}
