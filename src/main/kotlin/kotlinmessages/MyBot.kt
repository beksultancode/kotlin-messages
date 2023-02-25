package kotlinmessages

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class MyBot(val username: String, val token: String): TelegramLongPollingBot() {
    override fun getBotToken(): String {
        return this.token;
    }

    override fun getBotUsername(): String {
        return this.username;
    }

    fun sendMessage(chatId: String, messageText: String) {
        val response = SendMessage()
        response.chatId = chatId
        response.text = messageText
        try {
            execute(response)
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }

    override fun onUpdateReceived(update: Update?) {
        // Handle incoming messages here
    }
}