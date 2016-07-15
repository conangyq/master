
//The basic idea to solve this problem is to take advantage of the reminders of column number. When colNum between (0.26), the colName is directly associated with colNum. When colNum between (27,702), the colName is consist of two letters in alphabetic orders. When colNum>702, the colName will be consist of more letters in the same way.  
//Mathematical formula
//Step 1 : n%26 e.g. 27 % 26 gives reminder of 1, and the column name for the column number 1 is ¡®A¡¯
//Step 2 : (n-1)/26 e.g (27-1) / 26 give reminder of 0, Now n=1, continue step 1 until n>0


package com.column;
 
import javax.swing.JOptionPane;
 
public class Excel {
 
public static void main(String args[])
{
 //Input the column number in the pop up window
    String input = JOptionPane.showInputDialog("Enter any column number: "); // Enter the colmn number you want
 //Pass the column number to variable colNum
    int colNum=Integer.parseInt(input);
 //Print out the column name accordingly
    System.out.println("The according column name for the given number "+colNum+ "  is   " + FindColumnName(colNum));
 
 
}
 //Define the method FindColumnName

   private static  String FindColumnName(int colNum) {
        int BaseNum = 26; //Establish the base value 
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//Build a string to store the correct order of alphabet
        String colName = "";
 
        while (colNum > 0) {
           int position = colNum % BaseNum;//This is to figure out the relative position of the number in alphabet
           colName = (position == 0 ? 'Z' : alphabet.charAt(position > 0 ? position - 1 : 0)) + colName;
           //The principle of this method is to continuously get the reminder of input divided 26 until the n>0
           colNum = (colNum - 1) / BaseNum;
           //Since system starts counting with 0, we need to subtract 1 before continuing devide by 26
        }
        return colName;
        //The final colName is actually the reverse order of the calculation
    }
 
}