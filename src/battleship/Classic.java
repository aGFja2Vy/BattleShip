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
    
    public static void Game()
		{
        try {
            AI ai = new AI();
            Player player = new Player();
            //Sets the defaults
            //there may be a way to use constructors for this instead
            boolean Player_Alive = true;
            boolean AI_Alive = true;
            
            //creates the Board arrays with default values
            char[][] Right_Board = new char[BattleShip.ArryValues[0]][BattleShip.ArryValues[1]];
            char[][] Left_Board = new char[BattleShip.ArryValues[0]][BattleShip.ArryValues[1]];
            char[][] AI_Board = new char[BattleShip.ArryValues[0]][BattleShip.ArryValues[1]];
            
            //sets all the Board arrays to spaces
            Board.Set_Board(Right_Board, BattleShip.ArryValues[0], BattleShip.ArryValues[1]);
            Board.Set_Board(Left_Board, BattleShip.ArryValues[0], BattleShip.ArryValues[1]);
            Board.Set_Board(AI_Board, BattleShip.ArryValues[0], BattleShip.ArryValues[1]);
            Player.Display_Board(AI_Board, 10, 10);
            System.in.read();
            
            //lets them place there ships
            //Board.Set_ship(Right_Board, BattleShip.ArryValues[0], BattleShip.ArryValues[1]);
            ai.AI_Setup(AI_Board, BattleShip.ArryValues[0], BattleShip.ArryValues[1]);
            
            //repeats until one of the players loses and runs out of ships
            do
            {
                //Console.Clear();
                player.Attack(Left_Board, AI_Board, Right_Board, BattleShip.ArryValues[0], BattleShip.ArryValues[1]);
                System.out.println();
                ai.Attack(AI_Board, Right_Board, BattleShip.ArryValues[0], BattleShip.ArryValues[1]);
                Player_Alive = Board.CheckGame(Right_Board, BattleShip.ArryValues[0], BattleShip.ArryValues[1]);
                AI_Alive = Board.CheckGame(AI_Board, BattleShip.ArryValues[0], BattleShip.ArryValues[1]);
                
            } while (Player_Alive && AI_Alive);
            
            if (!Player_Alive)
            {
                try {
                    BattleShip.clearScreen();
                    System.out.println();
                    BattleShip.CenterText("LOSER!");
                    BattleShip.CenterText("Press any key to continue...");
                    System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(Classic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!AI_Alive)
            {
                try {
                    BattleShip.clearScreen();
                    System.out.println();
                    BattleShip.CenterText("YOU WIN!");
                    BattleShip.CenterText("Press any key to continue...");
                    System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(Classic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Classic.class.getName()).log(Level.SEVERE, null, ex);
        }
		}
}
