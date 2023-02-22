/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelesstempconverterclient;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mybean.StatelessTempConverterBeanRemote;

/**
 *
 * @author siriya_s
 */
public class MyThread extends Thread {
    StatelessTempConverterBeanRemote counterBean = lookupStatelessTempConverterBeanRemote();
    private double fahrenheit;
    
    public MyThread(double f) {
        fahrenheit = f;
    }
    
    @Override
    public void run() {
        Random r = new Random();
        try {
            sleep(r.nextInt(10));
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(fahrenheit + " Fahrenheit = " + counterBean.fToC(fahrenheit) + " Celcius");
    }

    private StatelessTempConverterBeanRemote lookupStatelessTempConverterBeanRemote() {
        try {
            Context c = new InitialContext();
            return (StatelessTempConverterBeanRemote) c.lookup("java:comp/env/StatelessTempConverterBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
