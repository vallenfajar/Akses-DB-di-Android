package com.example.konekdatabase

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fakultas_list.view.*
import java.security.AccessControlContext
import com.example.konekdatabase.MainActivity as MainActivity1




class RVAAdapterFakultas (private val context: Context, private val arrayList: ArrayList<Fakultas>):
        RecyclerView.Adapter<RVAAdapterFakultas.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.fakultas_list,parent, false))
    }

    override fun getItemCount(): Int = arrayList!!.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.label_idfakultas.text = this.arrayList?.get(position)?.id_fakultas
        holder.view.label_kodefakultas.text = this.arrayList?.get(position)?.kode_fakultas
        holder.view.label_namafakultas.text = "Nama Fakultas: "+arrayList?.get(position)?.nama_fakultas

        holder.view.cardview_list.setOnClickListener{
            val i = Intent(context, ManageFakultasActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("editmode","1")
            i.putExtra("txt_idfakultas",arrayList?.get(position)?.id_fakultas)
            i.putExtra("txt_kodefakultas",arrayList?.get(position)?.kode_fakultas)
            i.putExtra("txt_namafakultas",arrayList?.get(position)?.nama_fakultas)
            context.startActivity(i)
        }
    }
    class Holder(val view: View) : RecyclerView.ViewHolder(view)
}


