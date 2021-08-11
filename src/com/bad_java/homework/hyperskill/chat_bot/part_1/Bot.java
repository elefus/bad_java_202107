package com.bad_java.homework.hyperskill.chat_bot.part_1;

public class Bot {

    public static void main(String[] args) {
        SimpleBot.SimpleBotAcquaintance.sayHello();
        SimpleBot.SimpleBotAcquaintance.sayDateOfBirthday();
        SimpleBot currentBot = new SimpleBot();

        User userToCommunicate = currentBot.registerUser();
    }

}
