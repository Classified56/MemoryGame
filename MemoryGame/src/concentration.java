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
								ansArr[i][j] = "    ";
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
				String guess[] = new String[2];
				char row[] = new char[2];
				char col[] = new char[2];
				String gridGuess[] = new String[2];
				for(int i = 0; i < 2; i++)
					{
						if(counter == 0)
							System.out.print("Please choose a position. (i.e. b3, a1) ");
						else
							System.out.print("Please choose a position. ");
						gridGuess[i] = userGuess.nextLine();
						row[i] = gridGuess[i].charAt(1);
						col[i] = gridGuess[i].charAt(0);
						if(ansArr[row[i] - 49][col[i] - 97].equals("    "))
							{
								if(col[i] > 96)
									{
										ansArr[row[i] - 49][col[i] - 97] = guessArr[row[i] - 49][col[i] - 97];
										guess[i] = ansArr[row[i] - 49][col[i] - 97];
										makeGrid();
									}
								else
									{
										ansArr[row[i] - 49][col[i] - 65] = guessArr[row[i] - 49][col[i] - 65];
										guess[i] = ansArr[row[i] - 49][col[i] - 97];
										makeGrid();
									}
							}
						else
							{
								System.out.print("That spot is already solved. ");
								i--;
							}
					}
				if(guess[0].equals(guess[1]))
					{
						counter++;
						System.out.print("Good job. ");
					}
				else
					{
						counter++;
						Thread.sleep(2000);
						System.out.println("\n \n \nThat was wrong.");
						ansArr[row[0] - 49][col[0] - 97] = "    ";
						ansArr[row[1] - 49][col[1] - 97] = "    ";
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
