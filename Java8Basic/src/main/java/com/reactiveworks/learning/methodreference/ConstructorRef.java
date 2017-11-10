package com.reactiveworks.learning.methodreference;
interface Messagable{
	Message getMessage(String msg);
}

public class ConstructorRef {
	public static void main(String[] args) {
		Messagable messagable=Message::new;
		messagable.getMessage("Helloooo");
	}
}

class Message{
	public Message(String message){
		System.out.println(message);
	}
}