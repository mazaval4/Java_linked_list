// Assignment #: 10
//         Name: Miguel Zavala
//    StudentID: 1204402766
//      Lecture: MWF 1030
//  Description: The Assignment 10 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;

public class Assignment10
{
   public static void main(String[] args)
   {
      char input1;
       String inputInfo = new String();
       int operation2;
       String line = new String();

       //create a linked list to be used in this method.
       LinkedList list1 = new LinkedList();

       try
        {
         // print out the menu
         printMenu();

         // create a BufferedReader object to read input from a keyboard
         InputStreamReader isr = new InputStreamReader (System.in);
         BufferedReader stdin = new BufferedReader (isr);

         do
          {
        	//asks the user to enter a choice from the menu
           System.out.print("What action would you like to perform?\n");
           
           //the user input is read 
           line = stdin.readLine().trim();  
           input1 = line.charAt(0);
           //makes the input upper case so it can be compared to the menu choices
           input1 = Character.toUpperCase(input1);

           if (line.length() == 1)   //check if a user entered only one character
            {
             switch (input1)
              {
               case 'A'://Add String
            	   
            	   //asks the user for the string to be added to the linked list
                 System.out.print("Please enter a string to add:\n");
                 String str1 = stdin.readLine().trim();
                 
                 //asks the user at what index point they want the string entered
                 System.out.print("Please enter an index to add:\n");
                 inputInfo = stdin.readLine().trim();
                 int addIndex = Integer.parseInt(inputInfo);
                 
                 
                 //try catch to see if the users index is out of bounds 
                 
                 try
                  {
                   list1.addElement(addIndex, str1);
                  }
                 catch(IndexOutOfBoundsException ex)
                  {
                    System.out.print("The index is out of bounds\n");
                  }
                 
                 try
                 {
                	 list1.addElement(addIndex, str1);
                 }
                 catch(NumberFormatException ex)
                 {
                	 System.out.print("The is not a valid index\n");
                 }
                 break;
                 
                 
               case 'B':   //Remove a few of the specified object at the beginning of the linked list
                 System.out.print("Please enter a number of elements to be removed at the beginning of the linked list:\n");
                 inputInfo = stdin.readLine().trim();
                 int howMany = Integer.parseInt(inputInfo);
                 list1.removeFirstFew(howMany);
                 break;
                 
                 
               case 'E':   //Check if the list is empty
                 if (list1.isEmpty())
                  System.out.print("The list is empty.\n");
                 else
                  System.out.print("The list contains some element(s).\n");
                 break;
               case 'L':   //List Strings
                 System.out.print(list1.toString());
                 break;
               case 'Q':   //Quit exits the program
                 break;
               case 'R':  //Remove String removes the string at the index the user enters
                 System.out.print("Please enter the index of a string to remove:\n");
                 inputInfo = stdin.readLine().trim();
                 try
                  {
                 int removeIndex = Integer.parseInt(inputInfo);
                 System.out.println(list1.removeElement(removeIndex) + " was removed");
                  }
                 catch(IndexOutOfBoundsException ex)
                  {
                    System.out.print("The index is out of bounds\n");
                  }
                 break;
               case 'S':  //Set String changes the string at the index given by the user
                 System.out.print("Please enter a string to set:\n");
                 String str2 = stdin.readLine().trim();
                 System.out.print("Please enter an index to set:\n");
                 inputInfo = stdin.readLine().trim();
                 int setIndex = Integer.parseInt(inputInfo);
                 try
                  {
                   list1.setElement(setIndex, str2);
                  }
                 catch(IndexOutOfBoundsException ex)
                  {
                    System.out.print("The index is out of bounds\n");
                  }
                 break;
               case 'T':   //Find the largest string in the linked list
                 if (!list1.isEmpty())
                   System.out.print("The largest is: " + list1.findLargest()
                                   + "\n");
                 else
                   System.out.print("The list is empty\n");
                 break;
               case 'U':   //Remove all the occurrence of a given string
                 System.out.print("Please enter a string to remove:\n");
                 inputInfo = stdin.readLine().trim();
                 list1.removeAllOccurrences(inputInfo);
                 System.out.print("All occurrences of " + inputInfo
                                + " removed\n");

                 break;
               case '?':   //Display Menu displays the options the user has to choose from
                 printMenu();
                 break;
               default:
                 System.out.print("Unknown action\n");
                 break;
              }
           }
          else
           {
             System.out.print("Unknown action\n");
            }
          } while (input1 != 'Q' || line.length() != 1);
        }
       catch (IOException exception)
        {
          System.out.print("IO Exception\n");
        }
    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu()
     {
       System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd String\n" +
                        "B\t\tRemove A Few At the Beginning\n" +
                        "E\t\tCheck if Empty\n" +
                        "L\t\tList Strings\n" +
                        "Q\t\tQuit\n" +
                        "R\t\tRemove String\n" +
                        "S\t\tSet String\n" +
                        "T\t\tFind Largest\n" +
                        "U\t\tRemove Occurrences\n" +
                        "?\t\tDisplay Help\n\n");
    } //end of printMenu()
}