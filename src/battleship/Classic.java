/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 956040525
 */
public class Classic
{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    BattleShip Program = new BattleShip();
    
    public void Game()
		{
			//Sets the defaults
			//there may be a way to use constructors for this instead
			boolean Player_Alive = true;
			boolean AI_Alive = true;

			//creates the Board arrays with default values
			char[][] Right_Board = new char[10][10];
			char[][] Left_Board = new char[Program.ArryValues[0]][Program.ArryValues[1]];
			char[][] AI_Board = new char[Program.ArryValues[0]][Program.ArryValues[1]];

			//sets all the Board arrays to spaces
			Board.Set_Board(Right_Board, Program.ArryValues[0], Program.ArryValues[1]);
			Board.Set_Board(Left_Board, Program.ArryValues[0], Program.ArryValues[1]);
			Board.Set_Board(AI_Board, Program.ArryValues[0], Program.ArryValues[1]);

			//lets them place there ships
			Board.Set_ship(Right_Board, Program.ArryValues[0], Program.ArryValues[1]);
			AI.AI_Setup(AI_Board, Program.ArryValues[0], Program.ArryValues[1]);

			//repeats until one of the players loses and runs out of ships
			do
			{
				//Console.Clear();
				Player.Attack(Left_Board, AI_Board, Right_Board, Program.ArryValues[0], Program.ArryValues[1]);
				Console.WriteLine();
				AI.Attack(AI_Board, Right_Board, Program.ArryValues[0], Program.ArryValues[1]);
				Player_Alive = Board.CheckGame(Right_Board, Program.ArryValues[0], Program.ArryValues[1]);
				AI_Alive = Board.CheckGame(AI_Board, Program.ArryValues[0], Program.ArryValues[1]);

			} while (Player_Alive && AI_Alive);

			if (!Player_Alive)
			{
                            try {
                                Program.clearScreen();
                                System.out.println();
                                Program.CenterText("LOSER!");
                                Program.CenterText("Press any key to continue...");
                                System.in.read();
                            } catch (IOException ex) {
                                Logger.getLogger(Classic.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
			if (!AI_Alive)
			{
                            try {
                                Program.clearScreen();
                                System.out.println();
                                Program.CenterText("YOU WIN!");
                                Program.CenterText("Press any key to continue...");
                                System.in.read();
                            } catch (IOException ex) {
                                Logger.getLogger(Classic.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		}
}
