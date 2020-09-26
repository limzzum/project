package com.project.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

//private lateinit var database: DatabaseReference
//database=Firebase.database.reference

class upload_view : AppCompatActivity() {
private lateinit var recyclerView:RecyclerView
    private lateinit var userAdapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager:RecyclerView.LayoutManager
  //  private lateinit var adapter:userAdapter
    private lateinit var arrayList:ArrayList<user1>
    private lateinit var database:FirebaseDatabase
    private lateinit var databaseReference:DatabaseReference


    class user1 {

        var profile: Int=1
        var userId: String="1"
        var username: String="1"
        var postImg: Int=1
        var postContent: String="1"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_view)


          recyclerView=findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        layoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        arrayList = ArrayList<user1>()

        database= FirebaseDatabase.getInstance()
        databaseReference=database.getReference("user")
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                arrayList?.clear()

               val post: user1 = dataSnapshot.value as user1
               arrayList?.add(post)
                // ...
            }


            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                //Log.w(tag, "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        }
        databaseReference.addValueEventListener(postListener)
        recyclerView.adapter =ProfileAdapter(arrayList)






        //upload_button.setOnClickListener {
          //  getPicture()
        //}
    }


//    class Adapter(
//        val postlist:ArrayList<Post>,
//        val inflater:LayoutInflater):RecyclerView.Adapter<Adapter.ViewHolder>(){
//        class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
//            val profile:ImageView
//            val userId:TextView
//            val username:TextView
//            val post_img:ImageView
//            val post_content:TextView
//
//            init{
//                profile=itemView.findViewById(R.id.profile)
//            }
//            }
//        }


    private fun getPicture(){
        val intent= Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent, 1000)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1000){
            val uri: Uri =data!!.data!!
        }
    }
    fun getImageFilePath(contentUri:Uri):String{
        var columnIndex=0
        val projection=arrayOf(MediaStore.Images.Media.DATA)
        val cursor=contentResolver.query(contentUri,projection,null,null,null)
        if(cursor!!.moveToFirst()){
            columnIndex=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)

    }

    }
