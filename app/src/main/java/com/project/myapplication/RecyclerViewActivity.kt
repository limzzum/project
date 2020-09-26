package com.project.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_upload_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val itemList=ArrayList<Post>()
        for(i in 0 until 50){
            itemList.add(Post(1,"zzum","임정현" ,1,"좋은하루" ))
        }
        val adapter=RecyclerViewAdapter(itemList,LayoutInflater.from(this))
        recyclerview.adapter=adapter
        recyclerview.layoutManager=LinearLayoutManager(this)
    }
    class Post(val profile: Int,
               val userId: String,
               val username: String,
               val postImg: Int,
               val postContent: String
    )

    class RecyclerViewAdapter(
        val itemList:ArrayList<RecyclerViewActivity.Post>,
        val inflater: LayoutInflater
    ): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
        class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
             val profile:ImageView = TODO()
             val userId:TextView
             val username:TextView
             val postimg:ImageView
             val postcontent:TextView

            init{
                profile=itemView.findViewById(R.id.profile)
                userId=itemView.findViewById(R.id.userId)
                username=itemView.findViewById(R.id.username)
                postimg=itemView.findViewById(R.id.postImg)
                postcontent=itemView.findViewById(R.id.postContent)

            }

        }
        override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):ViewHolder{
            val view=inflater.inflate(R.layout.itemview,parent,false)
            return ViewHolder(view)
        }
        override fun getItemCount():Int{
            return itemList.size
        }
        override fun onBindViewHolder(holder:ViewHolder,position:Int){
            holder.profile.setImageResource(itemList.get(position).profile)
            holder.userId.setText(itemList.get(position).userId)
            holder.username.setText(itemList.get(position).username)
            holder.postimg.setImageResource(itemList.get(position).postImg)
            holder.postcontent.setText(itemList.get(position).postContent)

        }
    }
}