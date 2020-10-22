package com.example.affirmations.adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
import kotlinx.android.synthetic.main.list_item.view.*

class ItemAdapter(private val context: Context, private val dataSet: List<Affirmation>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {




    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)

        // fetch the cardView from list_item layout

        var card: CardView = view.findViewById(R.id.card)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

        //setting an onClickListener to each cardView
        holder.card.setOnClickListener {
            //fetch the item_alert layout and set it on the dialog window
            val alert = Dialog(context)
            alert.setContentView(R.layout.item_alert)
            alert.window!!.setType(WindowManager.LayoutParams.TYPE_TOAST)

            // fetch the views from item_alert layout

            var imageAlert: ImageView = alert.findViewById(R.id.image_alert)
            var textAlert: TextView = alert.findViewById(R.id.text_alert)
            var goBack: Button = alert.findViewById(R.id.go_back_btn)

            //bind the views

            imageAlert.setImageResource(item.imageResourceId)
            textAlert.text = context.resources.getString(item.stringResourceId)

            alert.show()

            goBack.setOnClickListener {
                alert.dismiss()
            }

        }


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}