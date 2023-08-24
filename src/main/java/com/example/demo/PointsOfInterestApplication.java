package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PointsOfInterestApplication {

	public static void showMenu() {
		Scanner scanner = new Scanner(System.in);
		int option;

		for(int i=0; i != 4; i++){
			System.out.println("Selecione uma opção:");
			System.out.println("1. CRIAR ponto de interesse");
			System.out.println("2. LISTAR TODOS pontos de interesse");
			System.out.println("3. LISTAR pontos de interesse por proximidade");
			System.out.println("4. Sair");
			System.out.print("Digite o número da opção desejada: ");

			option = scanner.nextInt();
			scanner.nextLine(); // limpar o buffer

			switch (option) {
				case 1:
					System.out.println("Você escolheu a Opção CRIAR ponto de interesse.");
					// Adicione a lógica para a Opção 1 aqui
					break;
				case 2:
					System.out.println("Você escolheu a Opção LISTAR TODOS pontos de interesse.");
					// Adicione a lógica para a Opção 2 aqui
					break;
				case 3:
					System.out.println("Você escolheu a Opção LISTAR pontos de interesse por proximidade.");
					// Adicione a lógica para a Opção 3 aqui
					break;
				case 4:
					System.out.println("Saindo do menu...");
					break;
				default:
					System.out.println("Opção inválida. Por favor, escolha novamente.");
					break;
			}

			System.out.println(); // linha em branco para separar iterações
		}

		scanner.close();
	}

	public static void main(String[] args) {
		SpringApplication.run(PointsOfInterestApplication.class, args);
		showMenu();
	}
}
