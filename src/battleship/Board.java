package battleship;

import java.io.IOException;
import static java.lang.System.in;
import java.util.Scanner;

public class Board {
    BattleShip Program = new BattleShip();
		public static void Set_Board(char[][] board, int x, int y)
		{
			for (int i = 0; i < y; i++)
			{
				for (int j = 0; j < x; j++)
					board[j][i] = ' ';
			}
		}

		public static boolean CheckGame(char[][] board, int x, int y)
		{
			for (int i = 0; i < y; i++)
			{
				for (int j = 0; j < x; j++)
				{
					if (board[j][i] == '#')
					{
						return true;
					}
				}
			}
			return false;
		}

		public static void Set_ship(char[][] board, int arrx, int arry)
		{
                    Scanner in = new Scanner(System.in);
			boolean Broken = false;
			int Ship5 = BattleShip.Ships[0];
			int Ship4 = BattleShip.Ships[1];
			int Ship3 = BattleShip.Ships[2];
			int Ship2 = BattleShip.Ships[3];
			int veiw = 0;
			int coorx = 0;
			int coory = 0;

			while(Ship5 >= 1)
			{
				Player.Display_Board(board, arrx, arry);

				do
				{
					Broken = false;

					do
					{
						Broken = false;

                                                System.out.println("Where do you want to place your '# # # # #' ship? (x)");
                                                coorx = in.nextInt() - 1;
                                                System.out.println();
					}while(Broken);

					do
					{
						Broken = false;

						try
						{
							System.out.println("Where do you want to place your '# # # # #' ship? (y)");
							coory = in.nextInt() - 1;
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("Hey! That is not allowed. Try again.");
							Broken = true;
						}
					}while(Broken);


					do
					{
						Broken = false;

						try
						{
							System.out.println("How would you like your ship placed?");
							System.out.println("Top to Bottom: 1");
							System.out.println("Left to Right: 2");
							veiw = in.nextInt() - 1;
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("Hey! That is not allowed. Try again.");
							Broken = true;
						}
					}while(Broken);

					if (!Check_Placement(board, coorx, coory, veiw, 5))
					{
						System.out.println("This is invalid placement.");
						Broken = true;
					}

					if ((coorx >= arrx) || (coorx < 0) || (coorx - 4 >= arry))
					{
						System.out.println("Your length value (X) is invalid. Try again.");
						Broken = true;
					}

					if ((coory >= arry) || (coory < 0) || (coory - 4 >= arry))
					{
						System.out.println("Your height value (Y) is invalid. Try again.");
						Broken = true;
					}

					if ((veiw != 1) && (veiw != 2))
					{
						System.out.println("Invalid rotation");
						Broken = true;
					}

				}while(Broken);

				if (veiw == 1)
				{
					board[coorx][coory] = '#';
					board[coorx][coory + 1] = '#';
					board[coorx][coory + 2] = '#';
					board[coorx][coory + 3] = '#';
					board[coorx][coory + 4] = '#';
				}
				else
				{
					board[coorx][coory] = '#';
					board[coorx + 1][coory] = '#';
					board[coorx + 2][coory] = '#';
					board[coorx + 3][coory] = '#';
					board[coorx + 4][coory] = '#';
				}

				Ship5--;
				BattleShip.clearScreen();
			}

			while(Ship4 >= 1)
			{
				Player.Display_Board(board, arrx, arry);

				do
				{
					Broken = false;

					do
					{
						Broken = false;

						try
						{
							System.out.println("Where do you want to place your '# # # #' ship? (x)");
							coorx = (int) System.in.read() - 1;
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("There was a problem with that input. Try again.");
							Broken = true;
						}
					}while(Broken);

					do
					{
						Broken = false;

						try
						{
							System.out.println("Where do you want to place your '# # # #' ship? (y)");
							coory = (int) System.in.read() - 1;
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("There was a problem with that input. Try again.");
							Broken = true;
						}
					} while (Broken);

					do
					{
						Broken = false;

						try
						{
							System.out.println("How would you like your ship placed?");
							System.out.println("Top to Bottom: 1");
							System.out.println("Left to Right: 2");
							veiw = (int) System.in.read();
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("There was a problem with that input. Try again.");
							Broken = true;
						}
					} while (Broken);

					if (!Check_Placement(board, coorx, coory, veiw, 4))
					{
						System.out.println("This is invalid placement.");
						Broken = true;
					}

					if ((coorx >= arrx) || (coorx < 0) || (coorx - 3 >= arry))
					{
						System.out.println("Your length value (X) is invalid. Try again.");
						Broken = true;
					}

					if ((coory >= arry) || (coory < 0) || (coory - 3 >= arry))
					{
						System.out.println("Your height value (Y) is invalid. Try again.");
						Broken = true;
					}

					if ((veiw != 1) && (veiw != 2))
					{
						System.out.println("Invalid rotation");
						Broken = true;
					}

				} while (Broken);

				if (veiw == 1)
				{
					board[coorx][coory] = '#';
					board[coorx][coory + 1] = '#';
					board[coorx][coory + 2] = '#';
					board[coorx][coory + 3] = '#';
				}
				else
				{
					board[coorx][coory] = '#';
					board[coorx + 1][coory] = '#';
					board[coorx + 2][coory] = '#';
					board[coorx + 3][coory] = '#';
				}

				Ship4--;
				BattleShip.clearScreen();
			}

			while(Ship3 >= 1)
			{
				Player.Display_Board(board, arrx, arry);

				do
				{
					Broken = false;

					do
					{
						Broken = false;

						try
						{
							System.out.println("Where do you want to place '# # #' ship? (x)");
							coorx = (int) System.in.read() - 1;
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("There was a problem with that input. Try again.");
							Broken = true;
						}
					} while (Broken);

					do
					{
						Broken = false;

						try
						{
							System.out.println("Where do you want to place your '# # #' ship? (y)");
							coory = (int) System.in.read() - 1;
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("There was a problem with that input. Try again.");
							Broken = true;
						}
					} while (Broken);

					do
					{
						Broken = false;

						try
						{
							System.out.println("How would you like your ship placed?");
							System.out.println("Top to Bottom: 1");
							System.out.println("Left to Right: 2");
							veiw = (int) System.in.read();
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("There was a problem with that input. Try again.");
							Broken = true;
						}
					} while (Broken);

					if (!Check_Placement(board, coorx, coory, veiw, 3))
					{
						System.out.println("This is invalid placement.");
						Broken = true;
					}

					if ((coorx >= arrx) || (coorx < 0) || (coorx - 2 >= arry))
					{
						System.out.println("Your length value (X) is invalid. Try again.");
						Broken = true;
					}

					if ((coory >= arry) || (coory < 0) || (coory - 2 >= arry))
					{
						System.out.println("Your height value (Y) is invalid. Try again.");
						Broken = true;
					}

					if ((veiw != 1) && (veiw != 2))
					{
						System.out.println("Invalid rotation");
						Broken = true;
					}
				} while (Broken);

				if (veiw == 1)
				{
					board[coorx][coory] = '#';
					board[coorx][coory + 1] = '#';
					board[coorx][coory + 2] = '#';
				}
				else
				{
					board[coorx][coory] = '#';
					board[coorx + 1][coory] = '#';
					board[coorx + 2][coory] = '#';
				}

				Ship3--;
				BattleShip.clearScreen();
			}

			while(Ship2 >= 1)
			{
				Player.Display_Board(board, arrx, arry);

				do
				{
					Broken = false;

					do
					{
						Broken = false;

						try
						{
							System.out.println("Where do you want to place your '# #' ship? (x)");
							coorx = (int) System.in.read() - 1;
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("There was a problem with that input. Try again.");
							Broken = true;
						}
					} while (Broken);

					do
					{
						Broken = false;

						try
						{
							System.out.println("Where do you want to place your '# #' ship? (y)");
							coory = (int) System.in.read() - 1;
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("There was a problem with that input. Try again.");
							Broken = true;
						}
					} while (Broken);

					do
					{
						Broken = false;

						try
						{
							System.out.println("How would you like your ship placed?");
							System.out.println("Top to Bottom: 1");
							System.out.println("Left to Right: 2");
							veiw = (int) System.in.read();
							System.out.println();
						}
						catch(Exception e)
						{
							System.out.println("There was a problem with that input. Try again.");
							Broken = true;
						}
					} while (Broken);

					if (!Check_Placement(board, coorx, coory, veiw, 2))
					{
						System.out.println("This is invalid placement.");
						Broken = true;
					}

					if ((coorx >= arrx) || (coorx < 0) || (coorx - 1 >= arry))
					{
						System.out.println("Your length value (X) is invalid. Try again.");
						Broken = true;
					}

					if ((coory >= arry) || (coory < 0) || (coory - 1 >= arry))
					{
						System.out.println("Your height value (Y) is invalid. Try again.");
						Broken = true;
					}

					if ((veiw != 1) && (veiw != 2))
					{
						System.out.println("Invalid rotation");
						Broken = true;
					}
				} while (Broken);

                                if (veiw == 1)
				{
					board[coorx][coory] = '#';
					board[coorx][coory + 1] = '#';
				}
				else
				{
					board[coorx][coory] = '#';
					board[coorx + 1][coory] = '#';
				}

				Ship2--;
				BattleShip.clearScreen();
			} 

		}

		public static boolean Check_Hit(char[][] board, int x, int y)
		{
			try
			{
				if (board[x][y] == '#')
					return true;
				else
					return false;
			}
			catch(Exception e)
			{
				return false;
			}
		}

		public static boolean Check_Valid(char[][] board, int x, int y)
		{
			try
			{
				if (board[x][y] == ' ')
					return true;
				else if (board[x][y] == 'X')
					return false;
				else if (board[x][y] == 'H')
					return false;
				else if (board[x][y] == '#')
					return true;
				return false;
			}
			catch(Exception e)
			{
				return false;
			}
		}

		public static boolean Check_Placement(char[][] board, int x, int y, int view, int size)
		{
			try
			{
				if (view == 1)
				{
					if (board[x][y] == ' ')
					{
						if (board[x][y + 1] == ' ')
						{
							if (size >= 3)
							{
								if (board[x][y + 2] == ' ')
								{
									if (size >= 4)
									{
										if (board[x][y + 3] == ' ')
										{
											if (size == 5)
											{
												if (board[x][y + 4] == ' ')
												{
													return true;
												}
												return false;
											}
											return true;
										}
										return false;
									}
									return true;
								}
								return false;
							}
							return true;
						}
						return false;
					}
					return false;
				}

				else if (view == 2)
				{
					if (board[x][y] == ' ')
					{
						if (board[x + 1][y] == ' ')
						{
							if (size >= 3)
							{
								if (board[x + 2][y] == ' ')
								{
									if (size >= 4)
									{
										if (board[x + 3][y] == ' ')
										{
											if (size == 5)
											{
												if (board[x + 4][y] == ' ')
												{
													return true;
												}
												return false;
											}
											return true;
										}
										return false;
									}
									return true;
								}
								return false;
							}
							return true;
						}
						return false;
					}
					return false;
				}

				else
					return false;
			}
			catch(Exception e)
			{
				return false;
			}
		}

	}
