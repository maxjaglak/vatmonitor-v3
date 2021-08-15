package oo.max.vatmonitor3.ui.history.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import oo.max.vatmonitor3.R
import oo.max.vatmonitor3.bl.DatePrinterService
import oo.max.vatmonitor3.databinding.ViewNipNumberBinding
import oo.max.vatmonitor3.ui.history.NipNumberDisplay

class NipNumbersAdapter(
    private val context: Context,
) : RecyclerView.Adapter<NipNumberViewHolder>() {

    private val items = mutableListOf<NipNumberDisplay>()
    private val layoutInflater = LayoutInflater.from(context)

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: List<NipNumberDisplay>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NipNumberViewHolder {
        val view = layoutInflater.inflate(R.layout.view_nip_number, parent, false)
        return NipNumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: NipNumberViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}

class NipNumberViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ViewNipNumberBinding.bind(view)

    fun bind(nipNumberDisplay: NipNumberDisplay) {
        with(binding) {
            nipNumberText.text = nipNumberDisplay.number
            createdText.text = nipNumberDisplay.createdDatePrinted
        }
    }

}