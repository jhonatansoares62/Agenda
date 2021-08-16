package com.jhonatan.agenda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Teste {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDateTime data = LocalDateTime.of(2020, 9, 5, 10, 10);
		
		
		System.out.println(formatter.format(data));
		System.out.println(formatter2.format(data));
		System.out.println(formatter3.format(data));
	}

}
