/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelesstempconverterclient;

import java.util.Scanner;

/**
 *
 * @author siriya_s
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter degree in Fahrenheit: ");
        double f = input.nextDouble();
        
        try {
            MyThread myThread = new MyThread(f);
            myThread.start();
        } catch(Exception e) {
            
        }
    }
    
}
