package battleship;
import java.util.Random;

public class AI {
                BattleShip Program = new BattleShip();
                Random rand = new Random();

		private static int Hitx;
		private static int Hity;
		private static boolean Hit = false;
		private static int attempt = 0;
                
                
		public RandomCoordinates Something()
		{
                    int x = rand.nextInt(Program.ArryValues[0]);
                    int y = rand.nextInt(Program.ArryValues[1]);
                        
                    return new RandomCoordinates(x,y);

		}

		public int Random_View()
		{
			int view = rand.nextInt(2) + 1;
                        return view;
		}

		public static boolean Ship_Placement(char[][] board, int x, int y, int view, int ship_Size)
		{
			boolean valid = Board.Check_Placement(board, x, y, view, ship_Size);

			if (!valid)
				return false;

			if (view == 1)
			{
				board[x][y] = '#';
				board[x][y + 1] = '#';

				if (ship_Size >= 3)
				{
					board[x][y + 2] = '#';

					if (ship_Size >= 4)
					{
						board[x][y + 3] = '#';

						if (ship_Size == 5)
							board[x][y + 4] = '#';
					}
				}
				return true;
			}
			else
			{
				board[x][y] = '#';
				board[x + 1][y] = '#';

				if (ship_Size >= 3)
				{
					board[x + 2][y] = '#';

					if (ship_Size >= 4)
					{
						board[x + 3][y] = '#';

						if (ship_Size == 5)
							board[x + 4][y] = '#';
					}
				}
				return true;
			}
		}

		public void AI_Setup(char[][] board, int arrx, int arry)
		{
                    RandomCoordinates rand = Something();
			int Ship5 = Program.Ships[0];
			int Ship4 = Program.Ships[1];
			int Ship3 = Program.Ships[2];
			int Ship2 = Program.Ships[3];
			int x = 0;
                        int y = 0;
                        int view = 0;
			boolean worked = false;

			while (Ship5 > 0)
			{
				x = rand.getX();
                                y = rand.getY();
				view = Random_View();
				worked = Ship_Placement(board, x, y, view, 5);
				if (worked)
					Ship5--;
			}
			while (Ship4 > 0)
			{
				x = rand.getX();
                                y = rand.getY();
				view = Random_View();
				worked = Ship_Placement(board, x, y, view, 4);
				if (worked)
					Ship4--;
			}
			while (Ship3 > 0)
			{
				x = rand.getX();
                                y = rand.getY();
				view = Random_View();
				worked = Ship_Placement(board, x, y, view, 3);
				if (worked)
					Ship3--;
			}
			while (Ship2 > 0)
			{
				x = rand.getX();
                                y = rand.getY();
				view = Random_View();
				worked = Ship_Placement(board, x, y, view, 2);
				if (worked)
					Ship2--;
			}

		}

		public void Attack(char[][] AI_Board, char[][] Right_Board, int arrx, int arry)
		{
                        RandomCoordinates rand = Something();
			boolean Broken = false;
			boolean valid = false;
			boolean hit = false;
			int fu = 0;

			do
			{
				Broken = false;

				try
				{
					int x, y;
					if (Hit)
					{
						switch (attempt)
						{
							case 1:
								//testing to the north
								Hity++;
								valid = Board.Check_Valid(Right_Board, Hitx, Hity);
								hit = Board.Check_Hit(Right_Board, Hitx, Hity);
								if (hit && valid)
								{
									Right_Board[Hitx][Hity] = 'H';
									attempt = 1;
									return;
								}
								else if (!hit && valid)
								{
									Right_Board[Hitx][Hity] = 'X';
									Hity--;
									attempt++;
									return;
								}
								else
								{
									Hity--;
									throw new IllegalArgumentException();
								}

							case 2:
								//testing to the east
								Hitx++;
								valid = Board.Check_Valid(Right_Board, Hitx, Hity);
								hit = Board.Check_Hit(Right_Board, Hitx, Hity);
								if (hit && valid)
								{
									Right_Board[Hitx][Hity] = 'H';
									attempt = 2;
									return;
								}
								else if (!hit && valid)
								{
									Right_Board[Hitx][Hity] = 'X';
									Hitx--;
									attempt++;
									return;
								}
								else
								{
									Hitx--;
									throw new IllegalArgumentException();
								}
							case 3:
								//testing to the south
								Hity--;
								valid = Board.Check_Valid(Right_Board, Hitx, Hity);
								hit = Board.Check_Hit(Right_Board, Hitx, Hity);
								if (hit && valid)
								{
									Right_Board[Hitx][Hity] = 'H';
									attempt = 3;
									return;
								}
								else if (!hit && valid)
								{
									Right_Board[Hitx][Hity] = 'X';
									Hity++;
									attempt++;
									return;
								}
								else
								{
									Hity++;
									throw new IllegalArgumentException();
								}
							case 4:
								//testing to the west
								Hitx--;
								valid = Board.Check_Valid(Right_Board, Hitx, Hity);
								hit = Board.Check_Hit(Right_Board, Hitx, Hity);
								if (hit && valid)
								{
									Right_Board[Hitx][Hity] = 'H';
									attempt = 4;
									return;
								}
								else if (!hit && valid)
								{
									Right_Board[Hitx][Hity] = 'X';
									Hitx++;
									attempt = 1;
									Hit = false;
									return;
								}
								else
								{
									Hitx++;
									attempt = 0;
									fu++;
									if (fu >= 2)
									{
										attempt = 5;
									}
									throw new IllegalArgumentException();
								}
							default:
								Hit = false;
								break;
						}
					}
                                        x = rand.getX();
                                        y = rand.getY();

					valid = Board.Check_Valid(Right_Board, x, y);
					hit = Board.Check_Hit(Right_Board, x, y);

					if (!valid)
						Broken = true;

					if (hit && valid)
					{
						System.out.println("AI Hit");
						Right_Board[x][y] = 'H';
						Hitx = x;
						Hity = y;
						Hit = true;
						attempt = 1;
					}
					else if (!hit && valid)
					{
						System.out.println("AI Missed");
						Right_Board[x][y] = 'X';
					}
				}
				catch(Exception e)
				{
					attempt++;
					Broken = true;
				}
			} while (Broken);
		}
}
