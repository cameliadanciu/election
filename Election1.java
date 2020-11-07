/*Maria Camelia Danciu - 21416657 & Gabriel Sison - 21408364 & Gavin
* Instructor: Dr Ikram Ur Rehman
* This program simulates an election: asks for input for votes and displays the winner.
*/
package election1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Election1 {
    public static void main(String[] args) {
        System.out.println("*************************************************"
                         + "\n*  WELCOME TO OUR STUDENT UNION ELECTION 2019"
                         + "\n*"                         
                         + "\n*  You must be atleast 18 years or over to vote."
                         + "\n*             Enter R for Results"
                         + "\n*************************************************");
        
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter Votes: ");
        
        ArrayList <String> names = new ArrayList <String>();
        
        while(true){
            String votes = input.next().toLowerCase();
            if(votes.equals("r")){                   //exits the loop when entered "R"
                System.out.println("\nCalculating Votes...");
                break;
            }
            if(names.contains(votes)){
                 System.out.println("Vote added \u2713");
            }
            else {
                System.out.println("New Candidate. Vote added \u2713");
            }
            names.add(votes);    //adds the input to the arraylist
        } 
        
        int highestVote = 0;                                        // To check who has the highest votes      
        Set<String> uniqueSet = new HashSet <String>(names);        // HashSet convert the arraylist into a set which
                                                                    // will get the uniqe names in the inputs       
        String[] uniqueNames = new String[uniqueSet.size()];        //create new array with the size of the unique names
        uniqueSet.toArray(uniqueNames);                             // convert HashSet back to a array
        
        for (int i = 0; i < uniqueNames.length; i++ ){                      //uniqueNames.length is the number of items to iterate
            
            int votes = Collections.frequency(names, uniqueNames[i]);       //counts the number of occurences
            
            if(votes > highestVote){                                        //figure out the highest votes
                highestVote = votes;
            }
            
            System.out.println(uniqueNames[i] + ": " + votes);
        } 
        
        System.out.println("*************************************************")
        System.out.println("\nTHE WINNER\\S FOR STUDENT UNION ELECTION 2019:");
        
        int numberOfWinners = 0;
        for (int i = 0; i < uniqueNames.length; i++ ){ 
            
            int votes = Collections.frequency(names, uniqueNames[i]);
            
            if(highestVote == votes){                                       //identify the names with highest votes
                numberOfWinners++;
                System.out.println(uniqueNames[i] + ": " + votes);
            }     
        }        
        if(numberOfWinners>1){                                              //if it's more than one re-election required
            System.out.println("RE-ELECTION REQUIRED");
        }
        System.out.println("*************************************************");   
    }
}