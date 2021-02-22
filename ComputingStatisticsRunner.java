import java.util.*;
import java.io.*;
import java.text.*;

public class ComputingStatisticsRunner {
   public static void main(String[] args) throws FileNotFoundException {
      // Specifies the data file to be used.
      String file = "kiva_loans_small.csv";
      
      // Creates an ArrayList to store the data and calls the readData() method. 
      ArrayList<Loan> list = readData(file);
      
      // Loop to print out the existing data to see how it is structured.
      //for(int i = 0; i < list.size(); i++) {
      //   System.out.println(list.get(i));
      //}
      
      //Use this code to test the methods in the ComputingStatistics class
      ComputingStatistics analysis = new ComputingStatistics(list);
      System.out.println("Total amount: " + analysis.totalAmount());                  //Level 1 Question 1
//       System.out.println("Average loan amount: " + analysis.avgLoan());               //Level 1 Question 2
//       System.out.println("Largest loan amount: " + analysis.largestLoan());           //Level 1 Question 3
//       System.out.println("Smallest loan amount: " + analysis.smallestLoan());         //Level 1 Question 4
//       System.out.println("The country with the largest loan amount: " + analysis.largestLoanCountry());     //Level 1 Question 5
//       System.out.println("The country with smallest loan amount: " + analysis.smallestLoanCountry());       //Level 1 Question 6
      
//       System.out.println("Average days to fund loan request: " + analysis.avgDaysToFund());                 //Level 2 Question 1
//       System.out.println("The largest loan funded in Vietnam: " + analysis.largestLoan("Vietnam"));         //Level 2 Question 2
//       System.out.println("Average loan amount in the Philippines: " + analysis.avgLoan("Philippines"));     //Level 2 Question 3
//       System.out.println("The country with the longest to fund loan: " + analysis.longestToFundCountry());  //Level 2 Question 4
//       String mostLoans = "";
//       if (loansFunded("El Salvador") > loansFunded("Kenya"))
//           mostLoans = "El Salvador";
//       else
//           mostLoans = "Kenya";
//       System.out.println("The country with the most loans funded: " + mostLoans);   //Level 2 Question 5
      
//       System.out.println("Variance: " + analysis.variance());                       //Level 3 Question 1
//       System.out.println("Standard deviation: " + analysis.standardDeviation());    //Level 3 Question 2
//       System.out.println("Empirical rule (yes/no): " + analysis.empiricalRule());   //Level 3 Question 3
   }
   
   
   /**
    * Reads in the provided file and creates an ArrayList of the data.
    * @param file the name of the text file containing the data.
    * @return the ArrayList containing the data from the text file.
    */
   public static ArrayList<Loan> readData(String file) throws FileNotFoundException {
      // Scanner used to read in the data from the file.
      Scanner in = new Scanner(new File(file));
      // ArrayList to store the data.
      ArrayList<Loan> list = new ArrayList<Loan>();
      // Read in the header line so it is not added to the ArrayLists.
      String header = in.nextLine();
      // Check to see if the file still has data to be read in.
      while(in.hasNextLine()) {
      
         // Read in the line of data and 
         // use a space as a delimiter to separate the different columns.
         String[] line = in.nextLine().split(",");
         
         // Local variable containing the ID.
         int ID = Integer.parseInt(line[0]);
         
         // Local variable containing the amount.
         int amount = Integer.parseInt(line[1]);
         
         // Local variable containing the country.
         String country = line[2];
         
         // Local variable containing the lenders.
         int lenders = Integer.parseInt(line[5]);
         
         // Local variable containing the difference in days.
         int differenceInDays = Integer.parseInt(line[4]);
         
         // Add the loan to the arraylist.
        list.add(new Loan(ID, amount, country, differenceInDays, lenders));         
        
      }
      // Return the completed ArrayLists.
      return list;
   }

}
