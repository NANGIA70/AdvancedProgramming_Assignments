package assignment3;

import java.util.Scanner;

public class GAME {
	static private Scanner sc = new Scanner(System.in);
	
	static private Floor [] floors = new Floor[14];
	
	static private int position = 0;
	
	static private boolean started = false;
	
	static private boolean first12 = true;
	
	static private int totalPoints = 0;
	
	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.print("Enter the player name and hit enter: ");
		String name = sc.nextLine();
		System.out.println("The game setup is ready");
		System.out.println("========================================");
		
//		Initialize Floors
		for (int i = 0; i < floors.length; i++) {
			if (i == 2) {
				floors[i] = new Elevator(name);
			}
			else if (i == 5) {
				floors[i] = new Snake(name);
			}
			else if (i == 8) {
				floors[i] = new Ladder(name);
			}
			else if (i == 11) {
				floors[i] = new KingCobra(name);
			}
			else {
				floors[i] = new Empty(name);
			}
			floors[i].setFloorNumber(i);
			
		}
		
		while(position != 13) {
			Dice Die = new Dice(2);
			
			System.out.println("========================================");
			System.out.print("Hit enter to roll the dice");
			sc.nextLine();

			diceWork(Die);
			floorSelector(Die, true);

		}
		
		System.out.println("GAME OVER!!");
		System.out.println(name + " accumulated " + totalPoints + " points!!");
		System.out.println("========================================");
	}

	
	public static void floorSelector(Dice Die, boolean firstSelect) {
		// TODO Auto-generated method stub
		switch(position) {
			case 0: {
				if (started) {
					position += Die.getFaceValue();
				
					System.out.println("Player Position Floor -> " + position);
				
					floorWork(Die);
				}
				else {
//					START				
					if(Die.getFaceValue() == 2) {
						System.out.println("Game cannot start until you get 1");
					}
					else if(Die.getFaceValue() == 1) {
						started = true;
						
						System.out.println("Player Position Floor -> " + position);
						
						floorWork(Die);
					}
				}
				break;
			}
		
			case 12: {
				if(!firstSelect) {
					System.out.println("Player Position Floor -> " + position);
					
					floorWork(Die);
				}
				
				System.out.println("========================================");
				System.out.print("Hit enter to roll the dice");
				sc.nextLine();
				
				diceWork(Die);
				
				while (Die.getFaceValue() != 1) {
					System.out.println("Player Cannot Move");
					
					System.out.println("========================================");
					System.out.print("Hit enter to roll the dice");
					sc.nextLine();
					
					diceWork(Die);
				}
				
				if(Die.getFaceValue() == 1) {
					position += Die.getFaceValue();
					
					System.out.println("Player Position Floor -> " + position);
					
					floorWork(Die);
				}

				break;
			}
			default : {
				if (firstSelect) {
					position += Die.getFaceValue();
				}
			
				System.out.println("Player Position Floor -> " + position);
			
				floorWork(Die);
			}
		}
	}


	public static void diceWork(Dice Die) {
		// TODO Auto-generated method stub
		Die.roll();
		
		System.out.println("Dice gave " + Die.getFaceValue());
	}


	public static void floorWork(Dice Die) {
		// TODO Auto-generated method stub
//		Display Floor
		floors[position].Display();
		
//		Change total points
		setTotalPoints(getTotalPoints() + floors[position].getPoint());
		
//		Show total points
		System.out.println("Total Points " + getTotalPoints());
		
		if (floors[position].getFloorType().equals("Empty")) {
			return;
		}
		else {
			position = floors[position].getNewPos();
			floorSelector(Die, false);
		}
	}


//	Getters and Setters
//	Position
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		GAME.position = position;
	}

//	Total Points
	public static int getTotalPoints() {
		return totalPoints;
	}

	public static void setTotalPoints(int points) {
		GAME.totalPoints = points;
	}


	public static boolean isStarted() {
		return started;
	}


	public static void setStarted(boolean started) {
		GAME.started = started;
	}


	public static boolean isFirst12() {
		return first12;
	}


	public static void setFirst12(boolean first12) {
		GAME.first12 = first12;
	}
}
