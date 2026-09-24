package com.example.gmail
class Email(
    val sender: String,
    val title: String,
    val summary: String,
    // STRETCH: the date the email was sent, shown on the right of the sender row
    val date: String,
    // STRETCH: tracks read/unread so the adapter knows whether to bold this row
    var isRead: Boolean = false) {
}
