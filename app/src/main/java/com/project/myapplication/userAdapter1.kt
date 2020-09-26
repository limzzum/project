package com.project.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProfileAdapter(val profileList:ArrayList<upload_view.user1>): RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):ProfileAdapter.CustomViewHolder{
        val view=LayoutInflater.from(parent.context).inflate(R.layout.itemview,parent,false)
        return CustomViewHolder(view)

    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.profile.setImageResource(profileList.get(position).profile)
        holder.userId.text=(profileList.get(position).userId)
        holder.username.text=(profileList.get(position).username)
        holder.postImg.setImageResource(profileList.get(position).postImg)
        holder.postContent.text=(profileList.get(position).postContent)


    }
    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val profile: ImageView =itemView.findViewById<ImageView>(R.id.profile)
        val userId: TextView =itemView.findViewById<TextView>(R.id.userId)
        val username: TextView =itemView.findViewById<TextView>(R.id.username)
        val postImg: ImageView =itemView.findViewById<ImageView>(R.id.postImg)
        val postContent: TextView =itemView.findViewById<TextView>(R.id.postContent)

    }

}