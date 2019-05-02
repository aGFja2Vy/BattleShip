package battleship;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class BattleShip 
{
            Classic Classic = new Classic();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
            //Sets the default values for the board size and the default number for the ship sizes
            public int Ships[] = { 1, 1, 2, 1 };
            public int ArryValues[] = { 10, 10 };
            public void clearScreen() 
            {  
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
            } 
            //this runs the menus and essentually the order in which everything should be called 
            void Main()
            {

                    //sets the Windows console to a size that will work with the center text function
                    //Console.SetWindowSize(130, 30);

                    //Makes it so that by default the game quits instead of forcing the player to play again
                    boolean quit = true;

                    //Everything is broken so this will be changed any time user input is invalid or an exception is caught
                    boolean Broken = false;

                    //Makes it so that the player can choose to play agian if they want to (Possibly reduntant)
                    boolean PlayAgain = false;
                    //This will be changed with user input and if it == 1 it will close the game
                    int Continue = 2;

                    do
                    {
                            //Shows the Battleship intro screen
                            StartScreen();

                            //Shows the player what the rules are
                            Rules();

                            //gets the gamemode choice for the switch statment
                            int answer = MainMenu();

                            //sets the game to match the mode they chose (1 = classic 2 = classic++)
                            switch (answer)
                            {
                                    //This is the classic gamemode
                                    case 1:
                                            {
                                                    //This playes the game then repeats if the player wants to
                                                    do
                                                    {
                                                            //This is the game part (choosing/placing ships ect.)
                                                            Classic.Game();

                                                            //This do while loop offers the user the option to quit or to play again then forces the user to enter new input if they break something
                                                            do
                                                            {
                                                                    //Prevents infinate loops
                                                                    Broken = false;

                                                                    System.out.println("Would you like to...");
                                                                    System.out.println("1: Play Again");
                                                                    System.out.println("2: Quit");

                                                                    //trys and Catchs bad input because users cannot be trusted
                                                                    try
                                                                    {
                                                                            Continue = (int) System.in.read();
                                                                    }
                                                                    catch(Exception e)
                                                                    {
                                                                            System.out.println("Not a valid answer");
                                                                            Broken = true;
                                                                    }

                                                            }while(Broken);

                                                            //Player wants to play again
                                                            if (Continue == 1)
                                                                    PlayAgain = true;

                                                            //Player is done playing
                                                            else
                                                            {
                                                                    PlayAgain = false;
                                                                    quit = true;
                                                            }

                                                    }while(PlayAgain);

                                                    break;
                                            }

                                    case 2:
                                            {

                                                    do
                                                    {
                                                            //ClassicAdv.Game();

                                                            do
                                                            {
                                                                    Broken = false;

                                                                    System.out.println("Would you like to...");
                                                                    System.out.println("1: Play Again");
                                                                    System.out.println("2: Quit");

                                                                    try
                                                                    {
                                                                            Continue = (int) System.in.read();
                                                                    }
                                                                    catch(Exception e)
                                                                    {
                                                                            System.out.println("Not a valid answer");
                                                                            Broken = true;
                                                                    }

                                                            } while (Broken);


                                                            if (Continue == 1)
                                                                    PlayAgain = true;
                                                            else
                                                            {
                                                                    PlayAgain = false;
                                                                    quit = true;
                                                            }

                                                    } while (PlayAgain);

                                                    break;
                                            }
                                    case 3:
                                            {
                                                    //This playes the game then repeats if the player wants to
                                                    do
                                                    {
                                                            //This is the game part (choosing/placing ships ect.)
                                                            //AIGame.Game();

                                                            //This do while loop offers the user the option to quit or to play again then forces the user to enter new input if they break something
                                                            do
                                                            {
                                                                    //Prevents infinate loops
                                                                    Broken = false;
                                                                    System.out.println("Player:");
                                                                    //Player.Display_Board(AIGame.Left_Board, AIGame.Right_Board, 10, 10);
                                                                    System.out.println("Ai:");
                                                                   // Player.Display_Board(AIGame.AI_Board, 10, 10);
                                                                    System.out.println("Would you like to...");
                                                                    System.out.println("1: Play Again");
                                                                    System.out.println("2: Quit");

                                                                    //trys and Catchs bad input because users cannot be trusted
                                                                    try
                                                                    {
                                                                            Continue = (int) System.in.read();
                                                                    }
                                                                    catch(Exception e)
                                                                    {
                                                                            System.out.println("Not a valid answer");
                                                                            Broken = true;
                                                                    }

                                                            } while (Broken);

                                                            //Player wants to play again
                                                            if (Continue == 1)
                                                                    PlayAgain = true;

                                                            //Player is done playing
                                                            else
                                                            {
                                                                    PlayAgain = false;
                                                                    quit = true;
                                                            }

                                                    } while (PlayAgain);

                                                    break;
                                            }
                            }

                    } while (!quit);

                    //Temp ending while I debug that pauses what is going on and clears the terminal
                    System.out.println("Press ANY key to continue");
                try {
                    System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(BattleShip.class.getName()).log(Level.SEVERE, null, ex);
                }
                    clearScreen();
            }

            void StartScreen()
            {
                    clearScreen();
                    System.out.println("");
                    System.out.println("");
                    CenterText("  !!!!!!!        !!!       !!!!!!!!   !!!!!!!!!    !!         !!!!!!!     !!!!!!!     !!    !!     !!!!!     !!!!!!!   ");
                    CenterText("  !!!  !!!      !! !!         !!         !!!       !!         !!         !!!          !!    !!      !!!      !!   !!!  ");
                    CenterText("  !!!!!!       !!---!!        !!         !!!       !!         !!!!!!!     !!!!!!      !!!!!!!!      !!!      !!  !!!   ");
                    CenterText("  !!!  !!!    !!     !!       !!         !!!       !!         !!              !!!     !!    !!      !!!      !!        ");
                    CenterText("  !!!!!!     !!       !!      !!         !!!       !!!!!!     !!!!!!!     !!!!!       !!    !!     !!!!!     !!        ");
                    System.out.println("");
                    System.out.println("");
                    CenterText("Welcome to Battleship, the C# version");
                    CenterText("Press any button to continue...");
                try {
                    System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(BattleShip.class.getName()).log(Level.SEVERE, null, ex);
                }
                    clearScreen();
            }

            public void Rules()
            {
                    clearScreen();
                    CenterText("Help Screen");
                    System.out.println();
                    System.out.println("-If a question has a (Y/N) at the end, pressing y or Y will accept all other keys will automatically deny.");
                    System.out.println("-If a question has a (Y/N) at the end, DO NOT hit enter after you put your input.");
                    System.out.println();
                    CenterText("Rules and How to play:");
                    System.out.println("(1) The player (you) will begin by picking a game mode (press 10 for info on the game mode)");
                    System.out.println("(2) After you choose a game mode, you will setup the board by placing your ships");
                    System.out.println("(3) While you place your ships the AI will be setting up their ships");
                    System.out.println("(4) Once you place your ships the game will begin!)");
                    System.out.println("(5) To shoot enter the x and y coordinates and it will mark the board where you shot and tell you if you hit or miss.");
                    System.out.println("(6) once you shoot the ai will shoot and place a X for miss and a H for hit on your right board. ");
                    System.out.println("(7) The game will end when either all the player's ships are down or all of the AI's ships are down.");
                    System.out.println();
                    CenterText("Press the H key to return to this menu after any round.");
                    System.out.println();
                    CenterText("Press any button to continue...");
                    try {
                    System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(BattleShip.class.getName()).log(Level.SEVERE, null, ex);
                }
                    clearScreen();
            }

            public char Options(int coorx, int coory)
            {
                    boolean Broken = false;
                    boolean Repeat = false;
                    char answer = 'n';
                    int i = 10;

                    do
                    {
                            Repeat = false;
                            do
                            {
                                    Broken = false;

                                    System.out.println();
                                    System.out.println("Options Menu:");
                                    System.out.println();
                                    System.out.println("1: Fire torpedo at coordinates (" + coorx + "),(" + coory + ")");
                                    System.out.println("2: Set new coordinates for shot.");
                                    System.out.println("3: go to the rules and help menu.");
                                    System.out.println("4: exit and quit the game.");

                                    try
                                    {
                                            i = (int) System.in.read();
                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println("Input is invalid. Try again.");
                                            Broken = true;
                                            clearScreen();
                                    }
                            } while (Broken);

                            switch (i)
                            {
                                    case 1:
                                            {
                                                    clearScreen();
                                                    System.out.println("Launching Torpedoes!");
                                                    System.out.println();
                                                    return 'l';
                                            }
                                    case 2:
                                            {
                                                    clearScreen();
                                                    System.out.println("Setting new coordinates.");
                                                    System.out.println();
                                                    return 'n';
                                            }
                                    case 4:
                                            {
                                                    clearScreen();
                                                    CenterText("Are you sure you wish to close the game? (Y/N)");
                                                    try
                                                    {
                                                            answer = (char) System.in.read();
                                                            System.in.read();
                                                    }
                                                    catch(Exception e)
                                                    {
                                                            System.exit(1);
                                                    }
                                                    if (answer == 'y')
                                                    {
                                                            System.exit(1);
                                                    }
                                                    else
                                                    {
                                                            break;
                                                    }
                                                    return 'x';
                                            }
                                    case 3:
                                            {
                                                    Rules();
                                                    return 'h';
                                            }
                                    default:
                                            {
                                                    Repeat = true;
                                                    break;
                                            }
                            }
                    } while (Repeat);

                    return 'e';
            }

            public char Options()
            {
                    boolean Broken = false;
                    boolean Repeat = false;
                    char answer = 'n';
                    int i = 10;

                    do
                    {
                            Repeat = false;

                            do
                            {
                                    Broken = false;

                                    System.out.println();
                                    System.out.println("Options Menu:");
                                    System.out.println();
                                    System.out.println("1: Set coordinates for shot.");
                                    System.out.println("2: go to the rules and help menu.");
                                    System.out.println("3: exit and quit the game.");

                                    try
                                    {
                                            i = (int) System.in.read();
                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println("Input is invalid. Try again.");
                                            Broken = true;
                                            clearScreen();
                                    }
                            } while (Broken);

                            switch (i)
                            {
                                    case 1:
                                            {
                                                    clearScreen();
                                                    System.out.println("Setting new coordinates.");
                                                    return 'n';
                                            }
                                    case 3:
                                            {
                                                    clearScreen();
                                                    CenterText("Are you sure you wish to close the game? (Y/N)");
                                                    try
                                                    {
                                                            answer = (char) System.in.read();
                                                            //Console.ReadKey();
                                                    }
                                                    catch(Exception e)
                                                    {
                                                            System.exit(1);
                                                    }
                                                    if (answer == 'y' || answer == 'Y')
                                                    {
                                                            System.exit(1);
                                                    }
                                                    else
                                                    {
                                                            break;
                                                    }
                                                    return 'x';
                                            }
                                    case 2:
                                            {
                                                    return 'h';
                                            }
                                    default:
                                            {
                                                    Repeat = true;
                                                    break;
                                            }
                            }
                    } while (Repeat);

                    return 'e';
            }
            
            //Still trying to get to work correctly so for now it is just a pass through for the future
            public void CenterText(String str)
            {
                    System.out.println(str);
            }

            int MainMenu()
            {
                    //The choice they make gets stored as answer
                    int answer;

                    //this loop forces the player to pick a valid game mode before It will move on
                    while (true)
                    {
                            System.out.println("Choose a game mode.");
                            System.out.println("1: Classic (default)");
                            System.out.println("2: Classic++");
                            System.out.println("3: AI only mode");
                            System.out.println("10: Show rules and game mode explanations.");
                            try
                            {
                                    answer = (int) System.in.read();
                            }
                            catch(Exception e)
                            {
                                    System.out.println("Input is invalid. Defaulting to Classic game mode.");
                                    answer = 1;
                            }

                            switch (answer)
                            {
                                    case 1:
                                            //returns 1 for the Classic game mode
                                            clearScreen();
                                            System.out.println("You choose Classic game mode.");
                                            return 1;

                                    case 2:
                                            //returns 2 for the classic++ game mode
                                            clearScreen();
                                            System.out.println("You choose Classic++.");
                                            return 2;
                                    case 3:
                                            //returns 3
                                            return 3;


                                    case 10:
                                            //tells the player what the options are and what the differences are
                                            clearScreen();
                                            System.out.println("Classic: classic Battleship with a 10x10 board and 5 ships.");
                                            System.out.println();
                                            System.out.println("Classic++: classic Battleship but you get to choose the number of ships and the board size.");
                                            System.out.println();
                                            break;

                                    default:
                                            System.out.println("Fine don't pick one then. You are now playing Classic.");
                                            return 1;
                            }
                    }
            }

            public void SetUp()
            {
                    //setup for the answer
                    int answer_int = 0;
                    //if this is true something is not working right
                    boolean Broken = false;

                    System.out.println("Would you like to change the number of ships? (Default = 1(# # # # #) 1(# # # #) 2(# # #) 1(# #)) (Y/N)");

                    char answer = 'n';
                try {
                    answer = (char) System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(BattleShip.class.getName()).log(Level.SEVERE, null, ex);
                }
                    System.out.println();

                    //if they reply yes to changing the number of ships start this
                    if ((answer == 'Y') || (answer == 'y'))
                    {
                            //repeat this until there answer is valid
                            do
                            {
                                    //no longer broken until they answer again
                                    Broken = false;

                                    try
                                    {
                                            System.out.println("How many 5 long ships do you want?");
                                            Ships[0] = (int) System.in.read();
                                            System.out.println();
                                    }
                                    catch(Exception e)
                                    {
                                            //stops the player from breaking the game because they enter a char or something that is not valid
                                            System.out.println("Hey! That is not allowed. Try again.");
                                            Broken = true;
                                    }

                            } while (Broken);

                            //repeats the same thing as above but for the 4 long ship instead
                            //there may be a way to compact this code down
                            do
                            {
                                    Broken = false;

                                    try
                                    {
                                            System.out.println("How many 4 long ships do you want?");
                                            Ships[1] = (int) System.in.read();
                                            System.out.println();
                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println("Hey! That is not allowed. Try again.");
                                            Broken = true;
                                    }
                            } while (Broken);

                            do
                            {
                                    Broken = false;

                                    try
                                    {
                                            System.out.println("How many 3 long ships do you want?");
                                            Ships[2] = (int) System.in.read();
                                            System.out.println();
                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println("Hey! That is not allowed. Try again.");
                                            Broken = true;
                                    }
                            } while (Broken);

                            do
                            {
                                    Broken = false;

                                    try
                                    {
                                            System.out.println("How many 2 long ships do you want?");
                                            Ships[3] = (int) System.in.read();
                                            System.out.println();
                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println("Hey! That is not allowed. Try again.");
                                            Broken = true;
                                    }
                            } while (Broken);
                    }

                    do
                    {
                            Broken = false;

                            try
                            {
                                    System.out.println("Would you like to change the default board size? (Default = 10x10) (Y/N)");
                                    answer = (char) System.in.read();
                                    System.out.println();
                            }
                            catch(Exception e)
                            {
                                    System.out.println("Hey! That is not allowed. Try again.");
                                    Broken = true;
                            }
                    } while (Broken);

                    if ((answer == 'Y') || (answer == 'y'))
                    {
                            do
                            {
                                    Broken = false;

                                    try
                                    {
                                            System.out.println("What is the X dimension or the length of the new board size? (anything greater than 9 and less than 100 is accepted)");
                                            answer_int = (int) System.in.read();
                                            ArryValues[0] = answer_int;
                                            System.out.println();

                                            if ((ArryValues[0] <= 9) || (ArryValues[0] >= 100))
                                            {
                                                    System.out.println("Hey! That number is out of bounds.");
                                                    Broken = true;
                                            }

                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println("Hey! That is not allowed. Try again.");
                                            Broken = true;
                                    }

                            } while (Broken);

                            do
                            {
                                    Broken = false;

                                    try
                                    {
                                            System.out.println("What is the height of the new Board or the Y dimension? (anything greater than 9 and less than 100 is accepted)");
                                            answer_int = (int) System.in.read();
                                            ArryValues[1] = answer_int;
                                            System.out.println();

                                            if ((ArryValues[1] <= 9) || (ArryValues[1] >= 100))
                                            {
                                                    System.out.println("Hey! that number is out of bounds.");
                                                    Broken = true;
                                            }

                                    }

                                    catch(Exception e)
                                    {
                                            System.out.println("Hey! that is not allowed. Try again");
                                            Broken = true;
                                    }

                            } while (Broken);
                    }
            }
    }  
