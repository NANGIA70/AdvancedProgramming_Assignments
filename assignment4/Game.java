package assignment4;

import java.util.Random;
import java.util.Scanner;

public class Game {
	static private Scanner sc = new Scanner(System.in);
		
	static Random rand = new Random();
	
	static private Tiles [] tiles = new Tiles[20];
	
	static private Player player = new Player();
	
	static private Calculator<Object> calculator = new Calculator<Object>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Game Setup
		System.out.println("========================================");
		System.out.print("Hit enter to initialize the game: ");
		sc.nextLine();
		System.out.println("The game setup is ready");
		System.out.println("========================================");
		
//		Tiles Setup
		tiles[0] = new Tiles("Donald Duck");
		tiles[1] = new Tiles("Mickey Mouse");
		tiles[2] = new Tiles("Minnie Mouse");
		tiles[3] = new Tiles("Tom");
		tiles[4] = new Tiles("Jerry");
		tiles[5] = new Tiles("Shinchan");
		tiles[6] = new Tiles("Doremon");
		tiles[7] = new Tiles("Power Puff Girls");
		tiles[8] = new Tiles("Mr. Bean");
		tiles[9] = new Tiles("Pikachu");
		tiles[10] = new Tiles("Dora The Explorer");
		tiles[11] = new Tiles("Chotta Bheem");
		tiles[12] = new Tiles("Little Mermaid");
		tiles[13] = new Tiles("Courage The Cowardly Dog");
		tiles[14] = new Tiles("Ninja Hattori");
		tiles[15] = new Tiles("Noddy");
		tiles[16] = new Tiles("Bob The Builder");
		tiles[17] = new Tiles("Nobita");
		tiles[18] = new Tiles("Phineas");
		tiles[19] = new Tiles("Ferb");
		
		int hop = 1;
		
		while (hop <= 5) {
			System.out.println("========================================");
			System.out.print("Hit enter for your " + hop + " hop: ");
			sc.nextLine();
			
			int tile_num = rand.nextInt(21);
			
			if(tile_num == 20) {
				System.out.println("You are too energetic and zoomed past all the tiles!! Muddy Puddle Splash!! :(");
			}
			else if((tile_num % 2) != 0) {
//				Odd Tile
				oddTile(tile_num);				
			}
			else {
//				Even tile
				evenTile(tile_num);
			}
			hop++;
		}
		System.out.println("========================================");
		System.out.println("Game Over!! :)");
		System.out.println("========================================");
		System.out.println("Soft Toys Won by you are: ");
		for (int i = 0; i < player.getBuck().getSt_List().size(); i++) {
			System.out.println((i + 1) + ". " + player.getBuck().getSt_List().get(i));
		}
	}

//	Work for odd tiles
	private static void oddTile(int index) {
		// TODO Auto-generated method stub
		boolean correct = false;
		
//		Question round
		System.out.println("Question Round!! ");
		System.out.println("Menu: ");
		System.out.println("1. Integer");
		System.out.println("2. String");
		System.out.print("Choose Question Type: ");
		int choice = sc.nextInt();
		
		if (choice == 1) {
//			Integer
			correct = intQ();
		}
		else if (choice == 2) {
//			String
			correct = strQ();
		}
		
		if (correct) {
			player.getBuck().getSt_List().add(tiles[index].win());
		}
		else {
			System.out.println("You did not win any Soft Toy");
		}
	}
	
	
//	Work for even tiles
	private static void evenTile(int index) {
		player.getBuck().getSt_List().add(tiles[index].win());
	}

	
//	Work for string questions
	private static boolean strQ() {
		// TODO Auto-generated method stub
//		Generate two random strings
		String str1 = generateRandomChars();
		calculator.setA(str1);
		String str2 = generateRandomChars();
		calculator.setB(str2);
		
//		Take answer input from user
		System.out.println("Calculate the concatenation of strings " + str1 + " and " + str2);
		String ans = sc.next();
		calculator.setAns(ans);
		
		if (calculator.calcuate()) {
//			Check using generic calculator
			System.out.println("Correct Answer");
			return true;
		}
		else {
			System.out.println("Incorrect Answer");
			return false;
		}
	}

	
//	Work for integer questions
	private static boolean intQ() {
		// TODO Auto-generated method stub
//		Generate two random integers
		int a = rand.nextInt(10000);
		calculator.setA(a);
		int b = rand.nextInt(a);
		calculator.setB(b);
		
//		Take answer input from user
		System.out.print("Calculate the result of " + a + " divided by " + b + ": ");
		int ans = sc.nextInt();	
		calculator.setAns(ans);
		
		if (calculator.calcuate()) {
//			Check using generic calculator
			System.out.println("Correct Answer");
			return true;
		}
		else {
			System.out.println("Incorrect Answer");
			return false;
		}
	}
	
	
//	Function to generate a random string of length 4
	private static String generateRandomChars() {
//		String of possible characters :- uppercase and lowercase
		String candidateChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
//		String builder
		StringBuilder sb = new StringBuilder();
	    
//		Loop to build the random string
		for (int i = 0; i < 4; i++) {
			/*1. Choose random index
			 *2. Get the char from candidateChars
			 *3. Append to string builder */
	        sb.append(candidateChars.charAt(rand.nextInt(candidateChars.length())));
	    }
		
	    return sb.toString();
	}
}