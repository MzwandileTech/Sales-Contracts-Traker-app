package datacontracts;

import java.util.Scanner;

public class DataContracts {

    public static void main(String[] args) {
        
         Scanner input = new Scanner(System.in);

        double[] vContract = new double[6];
        double[] mContract = new double[6];
        double[] cContract = new double[6];
        double[] tContract = new double[6];
        double[] avgSales = new double[6];

        populateContract(vContract, "Vehicle");
        populateContract(mContract, "Mobile");
        populateContract(cContract, "Computer");

        while (true) {
            int userOption = getUserOption(input);

            switch (userOption) {
                case 1:
                    displayAllContracts(vContract, mContract, cContract, tContract);
                    break;
                case 2:
                    int highestSalesMonth = getHighestSalesMonth(tContract);
                    System.out.println("Month " + (highestSalesMonth + 1) + " had the highest sales of $" + tContract[highestSalesMonth]);
                    break;
                case 3:
                    calcAvgSales(vContract, mContract, cContract, tContract, avgSales);
                    System.out.println("Average sales for each month:");
                    for (int i = 0; i < avgSales.length; i++) {
                        System.out.println("Month " + (i + 1) + ": $" + avgSales[i]);
                    }
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
            }
        }
    }

    public static void populateContract(double[] contract, String type) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < contract.length; i++) {
            boolean isValid = false;
            double salesAmount = 0;

            while (!isValid) {
                System.out.print("Enter monthly sales amount for " + type + " contract in month " + (i + 1) + ": ");
                salesAmount = input.nextDouble();

                if (salesAmount > 0 && salesAmount < 1000000) {
                    isValid = true;
                } else {
                    System.out.println("Invalid amount. Please enter a value between 0 and 1,000,000.");
                }
            }

            contract[i] = salesAmount;
        }
    }

    public static int getUserOption(Scanner input) {
        System.out.println("Select an option:");
        System.out.println("1. Display all contract deals");
        System.out.println("2. Check highest sales contract");
        System.out.println("3. Average sales for each month");
        System.out.println("4. Exit");

        return input.nextInt();
    }

    public static void displayAllContracts(double[] vContract, double[] mContract, double[] cContract, double[] tContract) {
        System.out.println("All contract deals:");

        for (int i = 0; i < vContract.length; i++) {
            double totalSales = vContract[i] + mContract[i] + cContract[i] + tContract[i];
            System.out.println("Month " + (i + 1) + ":");
            System.out.println("\tVehicle contract: $" + vContract[i]);
            System.out.println("\tMobile contract: $" + mContract[i]);
            System.out.println("\tComputer contract: $" + cContract[i]);
            System.out.println("\tTotal sales: $" + totalSales);
        }
    
            
         }
      public static int getHighestSalesMonth(double[] tContract) {
        double highestSales = 0;
        int highestSalesIndex = 0;

        for (int i = 0; i < tContract.length; i++) {
            if (tContract[i] > highestSales) {
                highestSales = tContract[i];
                highestSalesIndex = i;
            }
        }

        return highestSalesIndex;
    }

}
