package com.example.gmail

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    // STRETCH: MutableList (not List) so Load More can append to this same list
    lateinit var emails : MutableList<Email>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.rvEmail)
        // Fetch the list of emails
        emails = EmailFetcher.getEmails()
        // Attach the adapter to the recyclerView to populate items
        val adapter = EmailAdapter(emails)
        // set Layout Manager to position items
        emailsRv.adapter = adapter
        emailsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            // Fetch next 5 emails and display in RecyclerView
            val newEmails = EmailFetcher.getNext5Emails()
            // STRETCH: remember where the new rows start so we can tell the adapter
            val startPosition = emails.size
            // STRETCH: append to the same list the adapter is already holding
            emails.addAll(newEmails)
            // STRETCH: notify the adapter so it draws only the 5 newly added rows
            adapter.notifyItemRangeInserted(startPosition, newEmails.size)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}
