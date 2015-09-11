import java.util.*;
import java.io.*;

public class concentration
	{
		static String guessArr[][] = new String[4][4];
		static Scanner userGuess = new Scanner(System.in);
		static Scanner file;
		public static void main(String[] args)throws IOException
			{
				//initializeTempTheme();
				arrayTheme();
				makeGrid();
			}
		public static void initializeTempTheme()throws IOException
			{
				file = new Scanner(new File("animals.txt"));
				for(int i = 0; i < 2; i++)
					{
						for(int j = 0; j < 4; j++)
							{
								guessArr[i][j] = file.nextLine();
							}
					}
				for(int i = 2; i < 4; i++)
					{
						for(int j = 0; j < 4; j++)
							{
								guessArr[i][j] = guessArr[i - 2][j];
							}
					}
			}
		public static void makeGrid()
			{
				for(int i = 0; i < 3; i++)
					{
						System.out.println("| " + guessArr[i][0] + " | " + guessArr[i][1] + " | " + guessArr[i][2] + " | " + guessArr[i][3] + " |");
						System.out.println("-----------------------------");
					}
				System.out.println("| " + guessArr[3][0] + " | " + guessArr[3][1] + " | " + guessArr[3][2] + " | " + guessArr[3][3] + " |");
			}
		public static void arrayTheme() throws IOException
			{
				System.out.print("What theme would you like? (a. Animals b. Household Items)");
				String themeSel = userGuess.next();
				char userLetter = themeSel.charAt(0);
				switch(userLetter)
					{
						case 'a': 
							file = new Scanner(new File("animals.txt")); 
							break;
						case 'b': 
							file = new Scanner(new File("housethings.txt"));
							break;
					}
				for(int i = 0; i < 2; i++)
					{
						for(int j = 0; j < 4; j++)
							{
								guessArr[i][j] = file.nextLine();
							}
					}
				for(int i = 2; i < 4; i++)
					{
						for(int j = 0; j < 4; j++)
							{
								guessArr[i][j] = guessArr[i - 2][j];
							}
					}
			}

	}
