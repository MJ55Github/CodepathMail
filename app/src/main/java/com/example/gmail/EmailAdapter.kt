package com.example.gmail
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater


class EmailAdapter(private val mEmails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderTextView = itemView.findViewById<TextView>(R.id.Sender)
        val titleTextView = itemView.findViewById<TextView>(R.id.Title)
        val summaryTextView = itemView.findViewById<TextView>(R.id.Summary)
        // STRETCH: cache the two new views the same way as the three above
        val dateTextView = itemView.findViewById<TextView>(R.id.Date)
        val senderImageView = itemView.findViewById<ImageView>(R.id.SenderImage)
    }
    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int) : ViewHolder{
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val emailView = inflater.inflate(R.layout.email_item, parent, false)
        return ViewHolder(emailView)

    }
    override fun onBindViewHolder(viewHolder: EmailAdapter.ViewHolder, position: Int) {
        val email = mEmails.get(position)
        viewHolder.senderTextView.text = email.sender
        viewHolder.titleTextView.text= email.title
        viewHolder.summaryTextView.text = email.summary
        // STRETCH: show the sent date for this email
        viewHolder.dateTextView.text = email.date

        // STRETCH: unread emails are drawn bold, read ones normal, like real Gmail
        val style = if (email.isRead) Typeface.NORMAL else Typeface.BOLD
        viewHolder.senderTextView.setTypeface(null, style)
        viewHolder.titleTextView.setTypeface(null, style)
        viewHolder.dateTextView.setTypeface(null, style)

        // STRETCH: tapping a row marks it read, then redraws just that row un-bolded
        viewHolder.itemView.setOnClickListener {
            if (!email.isRead) {
                email.isRead = true
                notifyItemChanged(viewHolder.bindingAdapterPosition)
            }
        }
    }
    override fun getItemCount(): Int {
        return mEmails.size
    }
}
