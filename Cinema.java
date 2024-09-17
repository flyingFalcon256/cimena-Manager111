package cinema;
import java.util.Scanner;

public class Cinema {

    public static Scanner scan = new Scanner(System.in);
    public static int currentIncome = 0;
    public static int seatsSold = 0;
    public static void main(String[] args) {
        
        System.out.println("Enter the number of rows:");
        int totalRows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int totalSeats = scan.nextInt();  // seats here means the columns.
        char[][] cinema = new char[totalRows][totalSeats];

        for(int i = 0; i < totalRows; i++){
            for(int j = 0; j < totalSeats; j++) {
                cinema[i][j] = 'S';
            }
        }

        showMenu(cinema,totalRows,totalSeats);
        

    }

    public static void showMenu(char[][] cinema, int totalRows, int totalSeats){
        while(true) {
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int option = scan.nextInt();
            switch(option) {
                case 1: displayingSeats(cinema,totalRows,totalSeats); break;
                case 2: buyingTicket(cinema,totalRows,totalSeats); break;
                case 3: showingStatistics(totalRows,totalSeats); break;
                case 0: scan.close(); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
        
    }

    public static void showingStatistics(int totalRows, int totalSeats) {
        float percentage = (float) (seatsSold) / (float) (totalSeats * totalRows) * 100.0f;
        System.out.printf("Number of purchased tickets: %d\n", seatsSold);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%d\n",currentIncome);
        if (totalRows * totalSeats <= 60) {
            System.out.printf("Total income: $%d\n", totalRows * totalSeats * 10);
        }
        else {
            int frontRows = totalRows/2;
            int backRows = totalRows - frontRows;
            System.out.printf("Total income: $%d\n", (frontRows*totalSeats*10) + (backRows*totalSeats*8));
        }
        return;
    }

    public static void displayingSeats(char[][] cinema, int totalRows, int totalSeats){
        System.out.println("Cinema:");
        for(int i = 0; i <= totalSeats; i++) {
            if (i == 0) {
                System.out.print("  ");
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0, k = 1; i < totalRows; i++,k++) {
            System.out.print(k + " ");
            for(int j = 0; j < totalSeats; j++) {
                System.out.print(cinema[i][j]+ " ");
            }
            System.out.println();
        } 
        System.out.println();
    }
    
        public static void buyingTicket(char[][] cinema, int totalRows, int totalSeats){


            while (true) {
                
                System.out.println("Enter a row number: ");
                int desiredRow = scan.nextInt();
                System.out.println("Enter a seat number in that row:");
                int desiredSeat = scan.nextInt();
                
                int frontRows = totalRows/2;
                int backRows = totalRows - frontRows;
    
                
                if (desiredRow < 0 || desiredSeat < 0 || desiredRow > totalRows || desiredSeat > totalSeats) {
                    System.out.println("Wrong Input!");
                    continue;
                }
                else {
                    if (cinema[desiredRow-1][desiredSeat-1] == 'B') {
                        System.out.println("That ticket has already been purchased!");
                        continue;
                    } 
                    else {
                        if (totalRows * totalSeats <= 60) {
                            System.out.println("Ticket Price: $10");
                            cinema[desiredRow-1][desiredSeat-1] = 'B';
                            currentIncome += 10;
                            seatsSold++;
                            return;
                        } 
                        else {
                            if (desiredRow <= frontRows) {
                                System.out.println("Ticket Price: $10");
                                cinema[desiredRow-1][desiredSeat-1] = 'B';
                                currentIncome += 10;
                                seatsSold++;
                                return;
                            }
                            else {
                                System.out.println("Ticket Price: $8");
                                cinema[desiredRow-1][desiredSeat-1] = 'B';
                                currentIncome += 8;
                                seatsSold++;
                                return;
                            }
                        } 
                    }
                }
            }

        }
    
}
