package com.example.hw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO Относится ко всему проекту
// распределить по пакетам,
// какие пакеты относятся к книгам,
// какие к подгрузке файлов,
// какие к авторизации
// на всех слоях
// включая html
// также исправьте все варнинги
// CustomErrorController 27,13
// FileController 30,18
// FileDownloadController 34,62
// LoginController 41,30
@SpringBootApplication
public class Hw2Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw2Application.class, args);
	}

}
