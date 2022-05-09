
import java.util.Scanner;
public class SuthakarGajanDecoderGame
{
    private static Scanner scan = new Scanner (System.in);

    

    public static void main (String[] args){
        do{ // a loop that always runs once
            game(); // the whole "game" is in the game method
        } while (playAgain()); // call the playAgain () method to check
    }
    
    public static void game()
    {
        
        System.out.println(" Welcome to   Decoder  ");
        System.out.println(" Unfortunately,our enemies ave hundreads of rocket Artillery aimed at our Aircraft Carrier");
        System.out.println(" The Aircraft carrier not only carries 10,000 thousand troops, but also carries helicopters and weapons storages");
        System.out.println(" The aircraft carrier is extremely vital in us winning the war against our enemy as it can also help carry offensive tanks. Losing it would be devasting");
        System.out.println(" That is why we are calling on you, our expert in cryptography, to deactivate the enemy artillery and save our aircraft carrier and troops ");
        System.out.println(" Deactivating the enemy system won't be easy. There are 3 stages and the whole thing must be completed in 5 mins");
        System.out.println(" You also get a 3 chances if you get a question wrong. If you run out of chances or time, the system automatically locks and our aircraft carrier will be destroyed");
        System.out.println(" Good luck !");
        System.out.println(""); // Create new lines to prevent clumping of text
        System.out.println("");
        
        if (questionOne())
        {
             
             if (questionTwo())
             {
                 
                 if (questionThree())
                 {
                     gameSuccessful();
                 }
                 else
                 {
                     gameEnd();
                 }
             }
             else
             {
                 gameEnd();
             }
        }
        else
        {
            gameEnd();
        }
        
    } 
    
    public static boolean playAgain() { // Method which allows user to either play the game again or quit
        System.out.println("Would you like to play again? (Y/n)");
        String answer = scan.next();
        char result = answer.toUpperCase().charAt(0);
        if (result == 'N')
        {
        System.out.println("Thanks for playing !");
        
        }
        return (result == 'Y'); 

    }
    
    public static boolean questionOne()
    {
        boolean resultQ1 = false ;
        int tries = 0 ;
        int chance = 8 ; // Number of chances
        System.out.println(""); // Create new lines to prevent clumping of text
        System.out.println("");
        System.out.println(" Welcome to stage 1 , where you guess a number within 6 guesses.");
        
        int secretNumber = (int)(Math.random() * 100) ; // Generate a number between 1 and 99
        
        int attempt = 0 ;
        int smallHints = 2 ;
        int largeHints = 1 ;
        int wantHint ; // Seeing if user wants a hint
        boolean saidSmallHint1 = false ; // Seeing if any hints have been said
        boolean saidLargeHint1 = false ;
        String smallHint1 ;
        String smallHint2 ;
        
        int n = secretNumber ;
        
        
        if (secretNumber % 2 == 0) // Determining if number is odd or even
        {
            smallHint1 = " This is an even number " ;
        }
        else
        {
            smallHint1 = " This is an odd number " ;
        }
        int lastDigit = secretNumber % 10 ; // Finding last digit
        if (lastDigit <= 5 ) 
        {
          smallHint2 = " The last digit of this number is less or equal to 5";
        }
        else
        {
          smallHint2 = " The last digit of this number is greater than 5";
        }
        
       
        while (n >= 10) // Finding the first digit of the number
        {
            n/= 10;
        }
        String largeHint1 = " The first digit of this number is " + n + " . " ;
        while (chance > 0) // Fix once hints are needed
        {   
            
            tries +=1 ;
            System.out.println(" This is guess # " + tries + " and you have " + chance + " chances left . Please guess a number between 1 - 99");
            attempt = scan.nextInt(); 
            if (attempt == secretNumber)// User guessed correctly
            {
                System.out.println(" Congrats, you win ! ");
                
                resultQ1 = true ;
                return resultQ1 ;
            }
            else
            {
                if(chance <= 0)
                {
                    break;
                }
                System.out.println(" You currently have " + smallHints + " small hints and " + largeHints + " large hints ");
                System.out.println("Would you like to use a small hint(1) , a large hint(2), or no hint (3) ");
              System.out.println(" If you use a big hint, you lose 2 guesses.");
              
              
              System.out.print("Enter your choice");
                wantHint = scan.nextInt();
                chance -- ;
                if (wantHint == 1)// Small Hint
                {
                    while( smallHints > 0)
                    {
                        
                        
                        if (saidSmallHint1 == false)
                        {
                           System.out.println(smallHint1);
                           saidSmallHint1 = true ; // Make sure this hint is not said again
                           smallHints--;
                           
                           break ;
                                
                        }
                        
                        else
                        {
                            smallHints-- ;
                           
                            System.out.println(smallHint2);
                            break ;
                        }
                    }
                        
                        
               }
                
                else if (wantHint == 2) // Large Hint
                {
                    while( largeHints > 0)
                    {    
                        
                        if (saidLargeHint1 == false)
                        {
                           System.out.println(largeHint1);
                           saidLargeHint1 = true ; // Make sure this hint is not said again
                           largeHints--;
                           chance -= 1;
                           break ;
                                
                        }
                        
    
                    }
                }
                else
                {
                    System.out.println(" Okay, good luck then ! ");
                    
                }
            }
            
            
            
        }
        
        if (lifeSaver())
        {
            
            System.out.println(" You got bailed out by a life saver, but congrats anyway !"); 
            resultQ1 = true ;
            
        }
        else{
            System.out.println("You lose ...");
        }
        return resultQ1 ;
        
        
        

        
   
    }
    
    public static boolean questionTwo()
    {
        System.out.println(""); // Create new lines to prevent clumping of text
        System.out.println("");
        System.out.println("");
        System.out.println(" Congrats on making it past stage 1. Unfortunately, it just keeps getting harder from here. ");
        System.out.println(" In this level, you need to guess a word within 6 guesses ");
        
        boolean resultQ2 = false ; // boolean variable which determines if user won or loss
        String[] strAr1={
        "ABUSE", "ADULT", "AGENT", "APPLE", "AWARD", 
        "BEACH", "BLOCK", "BRAIN", "BOARD", "BROWN",
        "CANNOT","CAMERA","CENTRE","CASUAL","CAREER",
        "DANGER", "DEMAND", "DEPEND", "DESERT", "DETAIL",
        "EXPRESS", "EXPENSE","EXPLORE", "EXHIBIT", "EXCITED"
        }; // Array of possible words for the game
        
        String placeHolder = "#"; 
        int low = 0;
        int high = 24;
        int b = (int) (Math.random() * (high - low)) + low; // Randomizing a number between 0 and 24. This number will be used to determine which word out of the array will be picked
        String secretWord = strAr1[b] ; // Used the randomized index to find our secret word
        String input;
        
        int guessesLeft = 6;
        String lettersLeft = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // All possible guesses
        String userGuess = "" ;
        char firstLetter = secretWord.charAt(0); // Getting first letter
        char lastLetter = secretWord.charAt(secretWord.length()-1); // Getting last letter
        char guess ;
        String largeHint1 = " The first letter of the word is " + firstLetter ;
        String smallHint1 = " The last letter of the word is " + lastLetter ;
        int numVowels = 0;
        String smallHint2 ;
        int numSmallHint = 2 ;
        int numLargeHint = 1 ;
        int wantHint; 
        boolean saidSmallH1 = false ; // Seeing if hints have already been said
        boolean saidSmallH2 = false ;
        boolean saidLargeH = false ;
        
        
        
        
        
        
        for (int i = 0; i < secretWord.length(); i ++) // Finding the number of vowels
        {
            if (secretWord.charAt(i) == 'A' || secretWord.charAt(i) == 'E' || secretWord.charAt(i) == 'I' || secretWord.charAt(i) == 'O' || secretWord.charAt(i) == 'U')
            {
                numVowels ++ ;
            }
        }
        
        smallHint2 = " This letter has " + numVowels + " vowels .";
        
        for (int i = 0; i < secretWord.length(); i ++) // Creating a string which will slowly become the secret word if user guesses a correct letter
        {
          userGuess+= placeHolder ;     
        }
        
        
        while (!userGuess.equals(secretWord) && guessesLeft > 0){ // While user has not guessed correctly and has guesses remaining
            System.out.println("The Word you guessed so far is : " + userGuess + " and you have " + lettersLeft + " letters left ");
            System.out.println("Guesses Remaining: " + guessesLeft + "   Enter a letter: ");

            guess = scan.next().toUpperCase().charAt(0);
            String temp = Character.toString(guess);
            
            

            while (!lettersLeft.contains(temp)){ // user has guessed an invalid letter
                System.out.println("Invalid guess. Please guess again");
                System.out.print("Enter your guess: ");
                guess = scan.next().toUpperCase().charAt(0);
                temp = Character.toString(guess);
            }

           
            
            if (secretWord.contains(temp)){ 
                String tempUserGuess = "";
                
                for (int i = 0; i < secretWord.length(); i++){
                    // if this is the guess, change it
                    if (secretWord.charAt(i) == guess){// Comparing specific letter of the secret word and letter we guessed
                        tempUserGuess += guess;
                        
                    } else {
                        tempUserGuess += userGuess.charAt(i);
                    }
                }
                userGuess = tempUserGuess;
            } else {
                guessesLeft--;
                System.out.println(" Would you like a small hint(1) or a large hint(2) or no hint(3) "); // Seeing if user wants a hint
                System.out.print(" Please enter your choice : ");
                wantHint = scan.nextInt(); // User Input on loop
                if (wantHint == 1)//Small Hint
                {
                    while ( numSmallHint > 0)
                    {
                        if (saidSmallH1 == false)
                        {
                            System.out.println(smallHint1);
                            saidSmallH1 = true ; // Making sure hint is not said again
                            numSmallHint -- ; // User used up a hint
                            break ;
                        }
                        else if (saidSmallH2 == false)
                        {
                            System.out.println(smallHint2);
                            saidSmallH2 = true ;
                            numSmallHint -- ; 
                            break ;
                        }
                    }
                    
                }
                
                else if(wantHint == 2) // Large Hint
                {
                    while (numLargeHint > 0)
                    {
                        if (saidLargeH == false)
                        {
                        
                            System.out.println(largeHint1);
                            saidLargeH = true ;
                            numLargeHint -- ;
                            
                        }
                        
                    }
                
                
                }
                
                
                
                
                
                
            }
            
            
            
            String tempLettersLeft = "";
            for (int i = 0; i < lettersLeft.length(); i++){
                if (lettersLeft.charAt(i) == guess){ // the new guess
                    tempLettersLeft += "-";
                } else { // don't change anythin
                    tempLettersLeft += lettersLeft.charAt(i);
                }
            }
            lettersLeft = tempLettersLeft;
        }
        
        if (userGuess.equals(secretWord)){// Seeing if user guessed the entire word correctly
           
            System.out.println("Congrats! The secret word was " + secretWord);
               
            resultQ2 = true ;
            return resultQ2 ;
        }
        else
        {
            
            if (lifeSaver())// Life saver, which gives user a redemption oppurtunity to win the game
            {
            
                System.out.println(" You got bailed out by a life saver, but congrats anyway !"); 
                resultQ2 = true ;
                return resultQ2 ;
                               
            }
            else
            {
            
                System.out.println(" You lose ");
                
                
            }
            
        
        }
        return resultQ2 ;
        
        
            
            
    }
    
    public static boolean questionThree()
    {
        int myHP = 120; // Monster and player's HP
        int opponentHP = 100 ;
        System.out.println(""); // Create new lines to prevent clumping of text
        System.out.println(""); // Create new lines to prevent clumping of text
        System.out.println("");
        System.out.println(" Welcome to stage 3 !");
        System.out.println(" Here, you will be in a combat game again a monster. You start with 120 HP and the monster starts with 100 HP");
        System.out.println(" You can throw your spear, use poisonous gas, or use a fire shield");
        System.out.println( " The enemy has a shield a gas mask and a flame thrower as their moves ");
        System.out.println(" You spear and poisonous gas do 20 damage, while the flame thrower of the enemy does 30, good luck !");
        System.out.println(" Click  (S) for spear, (P) for poisonous gas, and (F) for fire shield ");
        char input ;
        String playerInput ;
        int damageDoneEnemy = 0;
        int damageDonePlayer = 0 ;
        boolean gameResult = false ;
        while (true)
        {
            
            
                 
            System.out.println("Enter your choice: ");
            playerInput = scan.next();
            input = playerInput.toUpperCase().charAt(0);
            
            
            
             
                  
             
            int enemyChoice = (int)(Math.random() * 10) - 4 ; // Randomizing enemies move
            
            if( input == 'S')
            {
                if (enemyChoice == 1 || enemyChoice == 2 || enemyChoice == 3 ) // 1 or 2 will represent a shield, in which case the entire attack is deflected
                {
                    
                    opponentHP -= 5 ;
                    System.out.println(" You used a spear, but the opponent used a shield. You lost no HP, hence your HP is " + myHP + " and opponent lost 5 HP, hence their HP is " + opponentHP + " . ");
                }
                
                else if (enemyChoice == 4 || enemyChoice == 5) // a gas mask
                {
                    opponentHP -= 20 ;
                    System.out.println(" You used a spear, and the opponent used a gas mask. You lost no HP, hence your  HP is " + myHP + " and opponent lost 20 HP, hence their HP is " + opponentHP + " . ");
                }
                
                else // Flame thrower
                {
                    opponentHP -= 20 ;
                    myHP -= 30 ;
                    System.out.println(" You used a spear, and the opponent used a flame thrower. You lost 30 HP, hence your HP is " + myHP + " and opponent lost 20 HP and their  HP is " + opponentHP + " . ");
                }
            }
            
            else if (input == 'P')
            {
                if (enemyChoice == 1 || enemyChoice == 2 || enemyChoice == 3 ) // 1,2 or 3 will represent a shield
                {
                    
                    opponentHP -= 20 ;
                    System.out.println(" You used poisonous gas, and the opponent used a shield. You lost no HP, hence your HP is " + myHP + " and opponent lost 20 HP, hence their HP is " + opponentHP + " . ");
                }
                
                else if (enemyChoice == 4 || enemyChoice == 5) // a gas mask
                {
                    opponentHP -= 5;
                    System.out.println(" You used poisonous gas, and the opponent used a gas mask. You lost no HP, hence your HP is " + myHP + " and opponent lost 5 HP, hence their  HP is " + opponentHP + " . ");
                }
                
                else // Flame thrower
                {
                    opponentHP -= 20 ;
                    myHP -= 30 ;
                    System.out.println(" You used poisonous gas, and the opponent used a flame thrower. You lost 30 HP, hence your HP is " + myHP + " and the opponent lost 20 HP, hence their HP is " + opponentHP + " . ");
                
                }
            }
            
            else 
            {
                if (enemyChoice == 1 || enemyChoice == 2 || enemyChoice == 3)// We both are using defensive weapons(shields), hence no damage is done
                {
                    myHP += 0 ;
                    System.out.println(" You used a fire shield but the opponent used a shield as well You lost no HP, hence your HP is " + myHP + " and opponent HP is " + opponentHP + " . ");
                }
                else if (enemyChoice == 4 || enemyChoice == 5)
                {
                    myHP+= 0 ;
                    System.out.println(" You used a fire shield but the opponent used a gas mask. You lost no HP, hence your HP is " + myHP + " and opponent HP is " + opponentHP + " . ");
                }
                else // you use a fire shield and enemy uses flame thrower, you deflect half of the damage
                {
                    myHP -= 15 ;
                    System.out.println(" You used a fire shield, and the opponent used a flame thrower. You lost 15 HP, hence your HP is " + myHP + " and opponent HP is " + opponentHP + " . ");
                }
                
                
                
            
            
                
            }
            
            
            if (myHP <= 0 && opponentHP <= 0)// A tie where you both have less than 0 HP. Whoever does more damage on the next move wins
            {
                
                System.out.println(" It is a tie. The winner will be decided by seeing who does more damage on their next move.");
                enemyChoice = (int)(Math.random() * 10) - 4 ;
                System.out.print("Enter your choice: ");
                scan.nextLine();
                playerInput = scan.nextLine();
                input = playerInput.toUpperCase().charAt(0);
                if (enemyChoice == 1 || enemyChoice == 2 || enemyChoice == 3 || enemyChoice == 4 || enemyChoice == 5) // Shield or gas mask, in both cases, not damage is done
                {
                    damageDoneEnemy += 0 ;
                    
                }
                else if (enemyChoice == 6)
                {
                    damageDoneEnemy += 30 ;
                }
                 if (input == 'F') // A fire shield does no damage.
                 {
                     damageDonePlayer += 0;
                 }
                 else if (input == 'P' || input == 'S') // Both the poisonous gas and the spear do 20 damage
                 {
                     damageDonePlayer += 20 ;
                 }
                 if (damageDoneEnemy < damageDonePlayer)
                 {
                     System.out.println(" Phew, you won !. That was close, but you pulled through");
                     gameResult = true ;
                     break ;
                 }
                 else
                 {
                     System.out.println(" Nice try, but you lost. You gave it your all but it was not enough. The enemy used a flame thrower, which does 30 damage. ");
                   
                   break ;
                 }
                 
                 
                
                
            }
            
            else if (opponentHP <= 0)
            {
                System.out.println(" Congrats, you beat the enemy  . ");
                gameResult = true ;
                break ;
            }
            
            else if(myHP <= 0)
            {
                System.out.println(" You lost !");
                break ;
            }
            
            
            
        
        }
        return gameResult ;
   }     
        
        
        
   
    
    public static String gameEnd()
    {
        String answer = " Unfortunately, you were not successful. " ;
        return answer ;
    }
    
    public static String gameSuccessful()
    {
        String response = " Congrats, you were successful " ; 
        return response;   
    }
    
    public static boolean lifeSaver() // Life saver method, generates a math question to give user 2nd chance to win the game if they can't guess the number
        {
                
                int answer = 0, userAnswer ;
                String sign = "";
                System.out.println(" A life saver will help you bypass a round if you cannot pass it. The issue is, you need to answer a arithmetic question correctly to activate it.");
                
                
                int Val1 = (int)(Math.random() *  (10 - 1)) + 1; // Generating random number between 1 and 10
                int Val2 = (int) (Math.random() * (20 - 11)) + 11; // Generating random number between 11 and 20
                
                int operation = (int)(Math.random() * (3 -1 )) + 1 ; // Either add, multiply or subtract
                
                if (operation == 1) // Addition
                {
                    answer = Val1 + Val2 ;
                    sign = "+";
                
                }
                else if (operation == 2) // Subtraction
                {
                    sign = "-";
                    answer = Val2 - Val1 ;
                }
                
                else if (operation == 3) // Multiplication
                {
                    sign = "*";
                    answer = Val2 * Val1 ;
                    
                
                }
                System.out.print(Val2 + sign + Val1 + " =  : "); 
                userAnswer = scan.nextInt(); // User input which is the soloution to the math problem
                scan.nextLine(); 
        
                return (userAnswer == answer);
                
        
        
        }
    
    
    
    

}
