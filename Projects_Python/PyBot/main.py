import telebot
import random
from telebot import types
from config import TOKEN
# Создаем бота
bot = telebot.TeleBot(TOKEN)
# Команда start
@bot.message_handler(commands=["start"])
def start(m, res=False):
        markup=types.ReplyKeyboardMarkup(resize_keyboard=True)
        item1=types.KeyboardButton("Upload")
        item2=types.KeyboardButton("Check")
        markup.add(item1)
        markup.add(item2)
        bot.send_message(m.chat.id,'Submit',  reply_markup=markup)
@bot.message_handler(content_types=["text"])
def handle_text(message):
    if message.text.strip() != 'ВишМат_C':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        item1=types.KeyboardButton("Лекції_C")
        item2=types.KeyboardButton("Практики_C")
        item3=types.KeyboardButton("ДКР_C")
        markup.add(item1)
        markup.add(item2)
        markup.add(item3)
        bot.send_message(message.chat.id,'Submit',reply_markup=markup)
    elif message.text.strip() == 'ВишМат_U':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        item1=types.KeyboardButton("Лекції_U")
        item2=types.KeyboardButton("Практики_U")
        item3=types.KeyboardButton("ДКР_U")
        markup.add(item1)
        markup.add(item2)
        markup.add(item3)
        bot.send_message(message.chat.id,'Submit', reply_markup=markup)
    elif message.text.strip() == 'Upload':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        item1=types.KeyboardButton("ВишМат_U")
        item2=types.KeyboardButton("Англа_U")
        item3=types.KeyboardButton("Фізика_U")
        markup.add(item1)
        markup.add(item2)
        markup.add(item3)
        bot.send_message(message.chat.id,'Submit', reply_markup=markup)
    elif message.text.strip() == 'Check':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        item1 = types.KeyboardButton("ВишМат_C")
        item2 = types.KeyboardButton("Англа_C")
        item3 = types.KeyboardButton("Фізика_C")
        markup.add(item1)
        markup.add(item2)
        markup.add(item3)
        bot.send_message(message.chat.id,'Submit', reply_markup=markup)
    elif message.text.strip() == 'Лекції_U':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        bot.send_message(message.chat.id,"Forward message to Bot/Перешлите сообщение боту",reply_markup=markup)
    elif message.text.strip() == 'Практики_U':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        bot.send_message(message.chat.id, "Forward message to Bot/Перешлите сообщение боту", reply_markup=markup)
    elif message.text.strip() == 'ДКР_U':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        bot.send_message(message.chat.id, "Forward message to Bot/Перешлите сообщение боту", reply_markup=markup)
    elif message.text.strip() == 'Лекції_C':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        bot.send_message(message.chat.id, "*Список*", reply_markup=markup)
    elif message.text.strip() == 'Практики_C':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        bot.send_message(message.chat.id, "*Список*", reply_markup=markup)
    elif message.text.strip() == 'ДКР_C':
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        bot.send_message(message.chat.id, "*Список*", reply_markup=markup)
# Запускаем бота
bot.polling(none_stop=True, interval=0)
