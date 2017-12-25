
package ftsunami;

import java.util.Scanner;

/**
 *
 * @author sarthak
 */
public class FTsunami {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        System.out.println("Enter Number of banks:");
        int banks = input.nextInt();
        
        System.out.println("Enter the limit:");
        int limit = input.nextInt();
        
        int bankasset[] = new int[banks];
        double borrowers [][]= new double[banks][banks];
        
        storeloandata(bankasset , borrowers);
        calculateloan(bankasset, borrowers, limit);
        check(bankasset, borrowers, limit);
    }

    public static void storeloandata(int[] bankasset, double[][] borrowers)
    {
       for (int i=0; i<bankasset.length; i++) 
       {
           System.out.println("Enter bank asset of "+ (i+1));
           bankasset[i]=input.nextInt();
           
           System.out.println("Lend to how many banks:");
           int lentbank= input.nextInt();
           
           for(int j=0; j<lentbank;j++)
           {
               System.out.println("Enter the bank no and amount lent to bank:");
               borrowers[i][input.nextInt()]= input.nextDouble();
           }
       }
    }

    private static void calculateloan(int[] bankasset, double[][] borrowers, int limit) 
    {
         for (int i=0; i<bankasset.length; i++) 
       {
           for (int j=0; j<bankasset.length; j++)
           {
               int total=0;
                
               for(int k=0; k<bankasset.length; k++)
               {
                   total += borrowers[j][k];
               }
               
               if(total+bankasset[j]<limit){
                   for (int m=0; m<bankasset.length; m++){
                       borrowers[m][j]=0;
                   }
                   
               }
           }
       }
    } 

    private static void check(int[] bankasset, double[][] borrowers, int limit) {
        System.out.print("Unsafe banks are:");
        for (int j=0; j<bankasset.length; j++)
           {
               int total=0;
                
               for(int k=0; k<bankasset.length; k++)
               {
                   total += borrowers[j][k];
               }
               
               if(total+bankasset[j]<limit){
                   
                   System.out.print(j+" ");
               }
           }
    }
}
