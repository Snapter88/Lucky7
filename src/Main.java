import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Lucky7 casino app
		
		Scanner scanner = new Scanner(System.in);
		int randomNumber[] = new int[3];
		String continueGame = "e".toLowerCase();
		int playerMoney = 0;
		
		System.out.println("Tervetuloa Lucky7 kasinolle!");
		System.out.println("Kone arpoo sinulle 3 numeroa välillä 1-10 ja 7 voittaa");
		
		playerMoney = welcomeLoop();
		System.out.println("Haluatko jatkaa peliin (k/e)? ");
		continueGame = scanner.next();
			
			while(playerMoney > 0 && continueGame.equals("k")) {
				
				// for loop joka arpoo numerot randomGenerator metodia käyttäen
				for(int i = 0; i < 3; i++) {
					randomNumber[i] = randomGenerator();
				}
				System.out.println("Numerot ovat " + Arrays.toString(randomNumber));	

				playerMoney--;

				
				// if-else lause joka määrittää voittoehdot
				if(randomNumber[0] == 7 && randomNumber[1] == 7 && randomNumber[2] == 7) {
					System.out.println("Voitit 8€");
					playerMoney += 8;
				} else if(randomNumber[0] == 7 && randomNumber[1] == 7 || randomNumber[0] == 7 && randomNumber[2] == 7) {
					System.out.println("Voitit 4€");
					playerMoney += 4;
				} else if (randomNumber[0] == 7 || randomNumber[1] == 7 || randomNumber[2] == 7) {
					System.out.println("Voitit 2€");
					playerMoney += 2;
				} else {
					System.out.println("Ei voittoa");
				}

				// if lause joka kertoo mitä tehdään kun pelaajalta loppuvat rahat
				if(playerMoney == 0) {
					System.out.println("Rahat loppuivat. Haluatko lisätä rahaa (k/e)?");
					continueGame = scanner.next();
					if(continueGame.equals("k")) {
						System.out.println("Paljonko lisätään?");
						playerMoney = scanner.nextInt();						
					} else {
						System.out.println("Kiitos että pelasit Lucky7 kasinolla");
						break;
					}
				} 
				
				System.out.println("Sinulla on jäljellä " + playerMoney + "€");
				System.out.println("Haluatko pelata uudestaan (k/e)?");
				continueGame = scanner.next();
				
				// if lause joka keskeyttää pelin jos pelaaja syöttää e
				if(continueGame.equals("e")) {
					System.out.println("Kiitos että pelasit Lucky7 kasinolla");
					break;
				}
			}
	
	} // End main
		
	public static int randomGenerator() {
		Random random = new Random();
		int randomGenerate = random.nextInt(10) + 1;
		return randomGenerate;
	
	}
	public static int welcomeLoop() {
		Scanner scanner = new Scanner(System.in);
		int playerMoney = 0;
		while(playerMoney == 0) {
			System.out.println("Paljonko rahaa haluat laittaa? ");
			playerMoney = scanner.nextInt();
			if(playerMoney == 0) {
				System.out.println("Arvon pitää olla yli 0");
				continue;
			}
		}
		return playerMoney;
	}
}
