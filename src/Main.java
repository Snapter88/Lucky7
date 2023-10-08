import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Lucky7 casino app
		
		int randomNumber[] = new int[3];
		String continueGame = "e".toLowerCase();
		int playerMoney = 0;
		
		System.out.println("Tervetuloa Lucky7 kasinolle!");
		System.out.println("Kone arpoo sinulle 3 numeroa välillä 1-10 ja 7 voittaa.");
		
		System.out.println("Paljonko rahaa haluat laittaa?");
		playerMoney = welcomeLoop();
		System.out.println("Haluatko jatkaa peliin (k/e)? ");
		continueGame = continueGame();
			
			while(playerMoney > 0 && continueGame.equals("k")) {
				
				// TODO voisiko loopin muuttaa metodiksi
				// for loop joka arpoo numerot randomGenerator metodia käyttäen
				for(int i = 0; i < 3; i++) {
					randomNumber[i] = randomGenerator();
				}
				System.out.println("Numerot ovat " + Arrays.toString(randomNumber));	

				playerMoney--;

				// TODO harkitse metodin käyttöä
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
				
				System.out.println("Sinulla on jäljellä " + playerMoney + "€");
				// if lause joka kertoo mitä tehdään kun pelaajalta loppuvat rahat
				
				
				if(playerMoney == 0) {
					System.out.println("Rahat loppuivat. Haluatko lisätä rahaa (k/e)?");
					continueGame = continueGame();
					if(continueGame.equals("k")) {
						while(playerMoney == 0) {
						System.out.println("Paljonko lisätään?");
						playerMoney = welcomeLoop();
						}	
					} else {
						break;
					}
				}
				

				System.out.println("Haluatko pelata uudestaan (k/e)?");
				continueGame = continueGame();
				
			}			
	} // End main
		
	public static int randomGenerator() {
		// Metodi joka luo 
		Random random = new Random();
		int randomGenerate = random.nextInt(10) + 1;
		return randomGenerate;
	
	}
	// TODO nimeä metodi selkeämmin
	// Metodi jossa pelaajalta kysytään paljonko aloitus rahaa laitetaan.
	// While loopissa jossa virheen korjaus
	public static int welcomeLoop() {

		Scanner scanner = new Scanner(System.in);
		int playerMoney = 0;
		while(playerMoney == 0) {
			try {
			System.out.println("Syötä summa: ");
			playerMoney = scanner.nextInt();
			if(playerMoney == 0) {
				System.out.println("Arvon pitää olla yli 0");
				continue;
			}
			} catch(Exception e) {
				System.out.println("Arvon pitää olla kokonaisluku");
				scanner.next();
			}
		}
		return playerMoney;
	} // End welcomeLoop()

	// Metodi joka tarkistaa haluaako pelaaja jatkaa peliä
	public static String continueGame() {
		
		Scanner scanner = new Scanner(System.in);
		String playerContinue = "";
		while(!playerContinue.equals("k")) {
			playerContinue = scanner.next();
			if(playerContinue.equals("k")) {
			} else if(playerContinue.equals("e")) {
				System.out.println("Kiitos että pelasit Lucky7 kasinolla");
				break;
			} else {
				System.out.println("Arvon pitää olla k/e");
				continue;
			}
		}
		return playerContinue;
	} // End continueGame()
}
