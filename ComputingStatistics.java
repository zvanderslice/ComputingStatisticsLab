import java.util.ArrayList;

public class ComputingStatistics {
   /**
   * The ArrayList containing all of the loan data.
   */
   private ArrayList<Loan> data;
   
   /**
    * Creates a new ComputingStatistics object with an empty ArrayList 
    */
   public ComputingStatistics() {
      data = new ArrayList<Loan>();
   }
   
   /**
    * Creates a new ComputingStatistics object with the data passed in
    */
   public ComputingStatistics(ArrayList<Loan> d) {
      data = d;
   }
   
   /**
    * Calclates the total amount funded from all of the loans in the file.
    * @return the total loan amount.
    */
   public double totalAmount() {
      double amount = 0.0;
      Loan loan;
      for(int i = 0; i < data.size(); i++) {
         loan = data.get(i);
         amount = amount + loan.getLoanAmount();
      }
      return amount;
   }
   //finds the average loan in numerals
   public double avgLoan() {
      double amount = 0.0;
      Loan loan;
      for(int i = 0; i < data.size(); i++) {
         loan = data.get(i);
         amount = amount + loan.getLoanAmount();
      }
      return amount / data.size();
   }
   //finds the largest loan in numerals
   public double largestLoan() {
      double amount = 0.0;
      Loan loan;
      for(int i = 0; i < data.size(); i++) {
         loan = data.get(i);
         if (amount < loan.getLoanAmount()) amount = loan.getLoanAmount();
      }
      return amount;
   }
   //finds the country with the smallest loan
   public double smallestLoan(){
       double amount = Integer.MAX_VALUE;
       Loan loan;
       for(int i = 0; i < data.size(); i++) {
           loan = data.get(i);
           if(amount > loan.getLoanAmount()) {
               amount = loan.getLoanAmount();
           }
       }
       return amount;
   }
   //finds the country with the largest loan
   public String largestLoanCountry(){
       Loan loan;
       String country = "";
       double max = 0;
       double bigger = 0;
       double smaller = 0;
       for (int i=1 ; i < data.size(); i++){ 
           loan = data.get(i);
           bigger = loan.getLoanAmount();
           smaller = loan.getLoanAmount();
          
           if(smaller> max){
                max = smaller;
                country = loan.getCountry();
           }
           else if(bigger>max){
                  max=loan.getLoanAmount();
                  country = loan.getCountry();
           }
       }
       return country;
   }
   //finds the smallest loan from a country
   public String smallestLoanCountry()
    {
      Loan loan;
      String country = "";
      double min = 10000.0;
      double bigger = 0;
      double smaller = 0;
       for (int i=0 ; i < data.size(); i++){ 
          loan = data.get(i);
          bigger = loan.getLoanAmount();
          smaller = loan.getLoanAmount();
          
          if(smaller<min){
              min = smaller;
              country = loan.getCountry();
          }
          else if(bigger<min){
              min=loan.getLoanAmount();
              country = loan.getCountry();
          }
      }
       return country;
   }
   //finds the average days to fund a loan
   public double avgDaysToFund(){
       double averageSec = 0.0;
       int listSize = data.size();
       for (Loan l:data) {
           averageSec += l.getDaysToFund();
        }
       double averageMin = averageSec / 60;
       double avergeHour = averageMin / 60;
       double averageDay = avergeHour / 24;
       averageDay = averageDay / listSize;
       return averageDay;
   }
   //finds the largest loan for a specific country
   public double largestLoan(String countryNm) {
       double bigLoan = 0.0;
       for (Loan l:data) {
          String arrayCountry = l.getCountry(); 
          if (arrayCountry.equals(countryNm)) {
              if (bigLoan < l.getLoanAmount()) {
                  bigLoan = l.getLoanAmount();
                }
            }
       }
       return bigLoan;
   }
   //Finds the average loan for a specific country
   public double avgLoan(String countryNm) {
       double averageLoan = 0.0;
       for (Loan l:data) {
           String arrayCountry = l.getCountry();
           if (arrayCountry.equals(countryNm)) {
               averageLoan += l.getLoanAmount();
            }
        }
       return averageLoan; 
   }
    // Finds the country with the longest time to fund
   public String longestToFundCountry() {
       String longestCountry = "";
       int fundTime = 0;
       for (Loan l: data) {
           if (fundTime < l.getDaysToFund()) {
               longestCountry = l.getCountry();
               fundTime = l.getDaysToFund();
            }
        }
       return longestCountry;
   }
   //Finds the total amount of loans funded from a specific country
   public int loansFunded(String countryNm) {
       int loanFund = 0;
       for (Loan l:data) {
           String arrayCountry = l.getCountry();
           if (arrayCountry.equals(countryNm)) {
               loanFund += 1;
            }
        }
       return loanFund;
    }
}
