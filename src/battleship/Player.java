/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author 956040525
 */
public class Player {
                public int[][] LastShots = new int[2, 5];
		public int[][] CurrentShot = new int[2, 1];

		public static void Display_Board(char[][] board, char[][] right_board, int arrx, int arry)
		{

			//This is the x part of the board (top part)
			for (int x = 0; x < 2; x++)
			{
				System.out.print("\t  |  ");

				for (int left = 1; left < arrx + 1; left++)
				{
					System.out.print(left + " ");

					if (left < 10)
						System.out.print(" ");
				}
			}

			System.out.println();

			for (int x = 0; x < 2; x++)
			{
				System.out.print("\t--|");

				for (int seperator = 1; seperator < arrx + 1; seperator++)
					System.out.print("---");
			}

			//End of top part

			//This is the y part of the board and the actual board
			System.out.println();

			for (int i = 0; i < arry; i++)
			{
				//the if statement adds a space to the left side numbers so it stays aligned
				if (i < 9)
					System.out.print("\t" + (i + 1) + " |  ");
				else
					System.out.print("\t" + (i + 1) + "|  ");

				//prints the Board array with a space between each char
				for (int j = 0; j < arrx; j++)
					System.out.print(board[j][i] + "  ");

				// space for the right Board
				System.out.print("\t");

				//same thing as above but for the right Board
				if (i < 9)
					System.out.print((i + 1) + " |  ");
				else
					System.out.print((i + 1) + "|  ");

				for (int j = 0; j < arrx; j++)
					System.out.print(right_board[j][i] + "  ");

				System.out.println();
			}
		}

		public static void Display_Board(char[][] board, int arrx, int arry)
		{

			//This is the x part of the board
			System.out.print("\t  |  ");

			for (int left = 1; left < arrx + 1; left++)
			{
				System.out.print(left + " ");

				if (left < 10)
					System.out.print(" ");
			}

			System.out.println();
			System.out.print("\t--|");

			for (int seperator = 1; seperator < arrx + 1; seperator++)
				System.out.print("---");

			//End of top part

			//This is the y part of the board and the actual board
			System.out.println();
			for (int i = 0; i < arry; i++)
			{
				if (i < 9)
					System.out.print("\t" + (i + 1) + " |  ");
				else
					System.out.print("\t" + (i + 1) + "|  ");

				for (int j = 0; j < arrx; j++)
					System.out.print(board[j][i] + "  ");

				System.out.println();
			}
		}

		public static void Attack(char[][] Player_Board, char[][] AI_Board, char[][] Right_Board, int dix, int diy)
		{
			boolean Repeat = false;
			boolean loaded = false;
			boolean Broken = false;
			int x = 1;
			int y = 1;

			do
			{
				Broken = false;
				Repeat = false;

				try
				{
					if (!loaded)
					{
						do
						{
							Player.Display_Board(Player_Board, Right_Board, dix, diy);
							char answer = Program.Options();
							Broken = false;

							if (answer == 'n')
							{
								Player.Display_Board(Player_Board, Right_Board, dix, diy);
								System.out.println();
								System.out.println("Where would you like to shoot (X)?");
								x = Convert.ToInt32(Console.ReadLine()) - 1;
								System.out.println("Where would you like to shoot (Y)?");
								y = Convert.ToInt32(Console.ReadLine()) - 1;

								CurrentShot[0][0] = x + 1;
								CurrentShot[1][0] = y + 1;

								loaded = true;
								Repeat = true;
								Console.Clear();

							}
							else if (answer == 'h')
							{
								Program.Rules();
							}
							else
							{
								Broken = true;
							}

						} while (Broken);
					}
					else
					{
						do
						{
							Repeat = false;
							Player.Display_Board(Player_Board, Right_Board, dix, diy);
							char answer = Program.Options(CurrentShot[0, 0], CurrentShot[1, 0]);
							Broken = false;

							if (answer == 'n')
							{
								Player.Display_Board(Player_Board, Right_Board, dix, diy);
								System.out.println();
								System.out.println("Where would you like to shoot (X)?");
								x = Convert.ToInt32(Console.ReadLine()) - 1;
								System.out.println("Where would you like to shoot (Y)?");
								y = Convert.ToInt32(Console.ReadLine()) - 1;

								CurrentShot[0, 0] = x + 1;
								CurrentShot[1, 0] = y + 1;
								Repeat = true;
								Console.Clear();

							}
							else if (answer == 'l')
							{
								bool validAI = Board.Check_Valid(AI_Board, x, y);
								bool validPL = Board.Check_Valid(Player_Board, x, y);
								bool hit = Board.Check_Hit(AI_Board, x, y);

								if (!validAI || !validPL)
								{
									System.out.println("Not a valid shot. Please choose new x, and y values.");
									Broken = true;
								}

								if (hit && validAI && validPL)
								{
									System.out.println("Hit");
									Player_Board[x, y] = 'H';
								}
								else if (!hit && validAI && validPL)
								{
									System.out.println("Miss");
									Player_Board[x, y] = 'X';
								}

								loaded = false;

								if (!Broken)
									return;

							}
							else if (answer == 'h')
							{
								Program.Rules();
							}
							else
							{
								Broken = true;
							}
						} while(Broken || Repeat);
					}
				}
				catch(Exception e)
				{
					Console.Clear();
					Program.CenterText("Something went wrong... Please try again.");
					Broken = true;
				}

			} while (Broken || Repeat);
		}
}
