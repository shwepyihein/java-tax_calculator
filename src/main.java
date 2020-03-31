import javax.management.Descriptor;
import java.text.DecimalFormat;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
         int MonthlySalary,annualSalary,personalRelief,parentRelief,spouseRelief,childrenRelief,deductibles,taxableIncome,totalTax,monthlyTax;
         int months,twelvemonth,taxable;
         personalRelief=0;
         parentRelief=0;
         spouseRelief=0;
         childrenRelief=0;
         deductibles=0;
         int percentage;

        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter Monthly Salary(MMK):");
        MonthlySalary=Sc.nextInt();
        System.out.print("Enter the months:");
        months=Sc.nextInt();
        twelvemonth=12*MonthlySalary;
        annualSalary=months*MonthlySalary;
        personalRelief=(annualSalary)*20/100;
        Sc.nextLine();
        while(true){
                System.out.print("Do You Have A Father ( Yes / No ) :");
                String father=Sc.nextLine();
            if (father.equals("Yes") ) {
                parentRelief+=1000000;
                break;
            }
            else if(father.equals("No")){
                break;
            }
            else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        while(true){
            System.out.print("Do You Have A mother ( Yes / No )  :");
            String mother=Sc.nextLine();
            if (mother.equals("Yes") ) {
                parentRelief+=1000000;
                break;
            }
            else if(mother.equals("No")){
                break;
            }
            else {
                System.out.println("Invalid Input Pls Try Again ");
            }

        }
        while(true){
            System.out.print("Do You Have A Spouse ( Yes / No )  :");
            String Spouse=Sc.nextLine();
            if (Spouse.equals("Yes") ) {
                parentRelief+=1000000;
                while(true){
                    System.out.print("Do You Have A Children ( Yes / No ) :");
                    String Children = Sc.nextLine();
                    if (Children.equals("Yes")) {
                        System.out.print("How Many Children Do You Have :");
                        int nunOfChildren=Sc.nextInt();
                        childrenRelief=nunOfChildren*500000;
                        break;
                    }
                    else if(Children.equals("No")){
                        break;
                    }
                    else {
                        System.out.println("Invalid Input Pls Try Again ");
                    }
                }
                break;
            }
            else if(Spouse.equals("No")){
                break;
            }
            else {
                System.out.println("Invalid Input ");
            }
        }


        while(true){
            System.out.print("Do You Have Other Deductibles(Yes/No)  ");
            String insurance = Sc.nextLine();
            if (insurance.equals("Yes")) {
                System.out.print("Enter Amount For Other Deductibles in MMK : ");
                deductibles+=Sc.nextDouble();
                break;
            }
            else if(insurance.equals("No")){
                break;
            }
            else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }
        DecimalFormat df =new DecimalFormat("#,###");
        System.out.println("\u001B[31m \n\n\nRESULT");
        System.out.println("Monthly salary                   "+df.format(MonthlySalary));
        System.out.println("Annual Salary                    "+df.format(twelvemonth));
        System.out.println("Income for" + months + "months             "+df.format(annualSalary));
        System.out.println("Personal Relief                  -"+df.format(personalRelief));
        System.out.println("Parent Relief                    -"+df.format(parentRelief));
        System.out.println("Spouse Relief                    -"+df.format(spouseRelief));
        System.out.println("Children Relief                  -"+df.format(childrenRelief));
        System.out.println("Other deductibles                -"+df.format(deductibles));
        int totalmoney=personalRelief+parentRelief+spouseRelief+childrenRelief+deductibles;

        taxableIncome=annualSalary-totalmoney;
        if(taxableIncome<2000000){
            totalTax=taxableIncome;
        }
        else if(taxableIncome>2000000 && taxableIncome< 5000000){
            totalTax= (int) ((taxableIncome-2000000)*0.05);
        }
        else if(taxableIncome>5000000 && taxableIncome< 10000000){
            totalTax= (int) (150000+((taxableIncome-5000000)*0.1));
        }
        else if(taxableIncome>10000000 && taxableIncome< 20000000){
            totalTax= (int) (150000+500000+((taxableIncome-1000000)*0.15));
        }
        else{
            totalTax= (int) (150000+500000+1500000+((taxableIncome-1000000)*0.2));
        }


        monthlyTax=totalTax/months;

        System.out.println("Taxable Income                   "+df.format(taxableIncome));
        System.out.println("Total Tax                        "+df.format(totalTax));
        System.out.println("Monthly Tax                      "+df.format(monthlyTax));

        System.out.println("Descripton              Rate            Taxable             taxamount");
        System.out.println("Up to 20 Lakh           0%            2000000                 0");

        if(taxableIncome>2000000 &&taxableIncome<5000000){
            taxable=taxableIncome-2000000;
            int taxamount= (taxable)*5/100;
            if(taxable>3000000){
                System.out.println("20 Lakh - 50 Lakh       5%        3000000                "+df.format(150000));
            }else {
                System.out.println("20 Lakh - 50 Lakh       5%        "+df.format(taxable)+"     "+df.format(taxamount));
            }
        }else {
            System.out.println("                                                            "+totalTax);
        }
        if(taxableIncome>5000000 && taxableIncome<10000000) {
            taxable = (taxableIncome - 5000000);
            int taxamount = (taxable) * 10 / 100;

            if (taxable > 5000000) {
                System.out.println("20 Lakh - 50 Lakh       10%        5,000,000         " + df.format(500000));
            } else {
                System.out.println("20 Lakh - 50 Lakh       10%        " + df.format(taxable) + "            " + df.format(taxamount));
            }
        }else {
            System.out.println("                                                            "+totalTax);
        }

        if(taxableIncome>10000000 && taxableIncome< 20000000){
            taxable = (taxableIncome - 10000000);
            int taxamount = (taxable) * 15 / 100;

            if (taxable > 10000000) {
                System.out.println("100 Lakh - 200 Lakh      15%        10,000,000           " + df.format(1500000.));
            } else {
                System.out.println("100 Lakh - 200 Lakh      15%        " + df.format(taxable) + "        " + df.format(taxamount));
            }
        }else {
            System.out.println("                                                            "+totalTax);
        }

    }
}
