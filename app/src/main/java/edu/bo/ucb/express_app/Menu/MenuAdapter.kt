package edu.bo.ucb.express_app.Menu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.bo.ucb.express_app.R

class MenuAdapter(val list: ArrayList<Int>,val list2: ArrayList<String>,val list3: ArrayList<Intent>,val applicationContext: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_row, parent, false)
        return UserListViewHolder(view)

    }

    class UserListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.get(position)
        val item2= list2.get(position)
        val item3= list3.get(position)
        holder.itemView.findViewById<ImageView>(R.id.rv_option1).setImageResource(item)
        holder.itemView.findViewById<TextView>(R.id.textView1).text= item2
        holder.itemView.setOnClickListener{
            item3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            applicationContext?.startActivity(item3) }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}
