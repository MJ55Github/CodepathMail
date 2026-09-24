package com.example.gmail
class EmailFetcher {
    companion object {
        val senders = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
        // STRETCH: one sent-date per sender, matched up by the same index
        val dates = listOf("Sep 23", "Sep 23", "Sep 22", "Sep 22", "Sep 21", "Sep 20", "Sep 18", "Sep 17", "Sep 15", "Sep 14", "Sep 12", "Sep 11", "Sep 9", "Sep 6", "Sep 2")
        val title = "Welcome to Kotlin!"
        val summary = "Welcome to the Android Kotlin Course! We're excited to have you join us and learn how to develop Android apps using Kotlin. Here are some tips to get started."
        fun getEmails(): MutableList<Email> {
            var emails : MutableList<Email> = ArrayList()
            for (i in 0..9) {
                val email = Email(senders[i], title, summary, dates[i])
                emails.add(email)
            }
            return emails
        }

        fun getNext5Emails(): MutableList<Email> {
            var newEmails : MutableList<Email> = ArrayList()
            for (i in 10..14) {
                val email = Email(senders[i], title, summary, dates[i])
                newEmails.add(email)
            }
            return newEmails
        }
    }
}
