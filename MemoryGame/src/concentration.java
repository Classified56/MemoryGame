import java.util.*;
import java.io.*;

public class concentration
	{
		static String guessArr[][] = new String[4][4];
		static String ansArr[][] = new String [4][4];
		static Scanner userGuess = new Scanner(System.in);
		static Scanner userTheme = new Scanner(System.in);
		static Scanner file;
		static int counter = 0;
		public static void main(String[] args)throws IOException, InterruptedException
			{
				chooseArrayTheme();
				for(int i = 0; i < 4; i++)
					{
						for(int j = 0; j < 4; j++)
							{
								ansArr[i][j] = "    ";
							}
					}
				makeGrid();
				while(true)
					{
						guessAndCheckGrid();
						int test = 0;
						for(int i = 0; i < 4; i++)
							{
								for(String bob: ansArr[i])
									{
										if(bob.equals("    "))
											{
												test++;
											}
									}
							}
						if(test == 0)
							{
								break;
							}
					}
				System.out.println("\nCongratulations. It took you " + counter + " times to match all of the words.");
			}

		public static void guessAndCheckGrid() throws InterruptedException
			{
				String guess1 = "a", guess2 = "b";
				if(counter == 0)
					System.out.print("Please choose a position. (i.e. b3, a1) ");
				else
					System.out.print("Please choose a position. ");
				String gridGuess1 = userGuess.nextLine();
				char row1 = gridGuess1.charAt(1);
				char col1 = gridGuess1.charAt(0);
				if(col1 > 96)
					{
						ansArr[row1 - 49][col1 - 97] = guessArr[row1 - 49][col1 - 97];
						guess1 = ansArr[row1 - 49][col1 - 97];
						makeGrid();
					}
				else
					{
						ansArr[row1 - 49][col1 - 65] = guessArr[row1 - 49][col1 - 65];
						guess1 = ansArr[row1 - 49][col1 - 97];
						makeGrid();
					}
				System.out.print("Please choose a position. ");
				String gridGuess2 = userGuess.nextLine();
				char row2 = gridGuess2.charAt(1);
				char col2 = gridGuess2.charAt(0);
				if(col2 > 96)
					{
						ansArr[row2 - 49][col2 - 97] = guessArr[row2 - 49][col2 - 97];
						guess2 = ansArr[row2 - 49][col2 - 97];
						makeGrid();
					}
				else
					{
						ansArr[row2 - 49][col2 - 65] = guessArr[row2 - 49][col2 - 65];
						guess2 = ansArr[row2 - 49][col2 - 97];
						makeGrid();
					}
				if(guess1.equals(guess2))
					{
						counter++;
						System.out.print("Good job. ");
					}
				else
					{
						counter++;
						Thread.sleep(2500);
						System.out.println("\n \n \nThat was wrong.");
						ansArr[row1 - 49][col1 - 97] = "    ";
						ansArr[row2 - 49][col2 - 97] = "    ";
						makeGrid();
					}
			}
		
		public static void makeGrid()
			{
				System.out.println("\n     A       B      C      D ");
				for(int i = 0; i < 3; i++)
					{
						System.out.println((i + 1 ) + " | " + ansArr[i][0] + " | " + ansArr[i][1] + " | " + ansArr[i][2] + " | " + ansArr[i][3] + " |");
						System.out.println("  -----------------------------");
					}
				System.out.println("4 | " + ansArr[3][0] + " | " + ansArr[3][1] + " | " + ansArr[3][2] + " | " + ansArr[3][3] + " |");
			}
		
		public static void chooseArrayTheme() throws IOException
			{
				System.out.print("What theme would you like? \na. Animals b. Household Items c. Names d. Actions ");
				String themeSel = userTheme.next();
				char userLetter = themeSel.charAt(0);
				switch(userLetter)
					{
						case 'a': 
							file = new Scanner(new File("animals.txt")); 
							break;
						case 'b': 
							file = new Scanner(new File("housethings.txt"));
							break;
						case 'c':
							file = new Scanner(new File("names.txt"));
							break;
						case 'd':
							file = new Scanner(new File("Actions.txt"));
							break;
					}
				for(int i = 0; i < 4; i++)
					{
						for(int j = 0; j < 4; j++)
							{
								guessArr[i][j] = "a";
							}
					}
				int fill = 0;
				while(true)
					{
							int row = (int)(Math.random() * 4);
							int col = (int)(Math.random() * 4);
							if(guessArr[row][col].equals("a"))
								{
									fill++;
									guessArr[row][col] = file.nextLine();
								}
							if(fill == 16)
								{
									break;
								}
					}
			}
	}
