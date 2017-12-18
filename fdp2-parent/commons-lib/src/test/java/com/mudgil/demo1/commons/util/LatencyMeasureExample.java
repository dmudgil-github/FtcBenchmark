package com.mudgil.demo1.commons.util;


public class LatencyMeasureExample  {
    public static void main(String[] args) throws InterruptedException{

    	
    	measure1();
    }
    
    

    
    public static void measure1() throws InterruptedException{
    	
        LatencyMeasure lm = new LatencyMeasure(1000000);
        
        for (int i = 0; i < 100000; i++) {
            lm.startMeasure();
        	randomSleep();
            lm.endMeasure();
        }
        long stats [] = lm.prepareStats();
        
        lm.showWithMethod(stats);
        
        System.out.println("****** head ******");
        lm.statsHead(stats);
        System.out.println("****** tail ******");
        lm.statsTail(stats);


    	
    }
    
    
    public static void randomSleep() throws InterruptedException{
    	
    	
        Thread.sleep((long)Math.random()*10);
        
    }
    
    
    public static void origMeasure() throws InterruptedException{
    	
        //Below are a couple of examples
        LatencyMeasure lm = new LatencyMeasure(1000000);
 
        System.out.println("Thread.sleep() random");
        for (int i = 0; i < 100000; i++) {
            lm.startMeasure();
            Thread.sleep((long)Math.random()*10);
            lm.endMeasure();
        }
        long stats [] = lm.prepareStats();
        
        lm.showWithMethod(stats);
        
        System.out.println("****** head ******");
        lm.statsHead(stats);
        System.out.println("****** tail ******");
        lm.statsTail(stats);

 
        lm = new LatencyMeasure(1000000);
 
        double d = 0;
        System.out.println("\nMath.sqrt");
        for (int i = 0; i < 100000; i++) {
            lm.startMeasure();
            d+=Math.sqrt(i);
            lm.endMeasure();
        }
 
        stats  = lm.prepareStats();
        
        lm.showWithMethod(stats);
        
        System.out.println("****** head ******");
        lm.statsHead(stats);
        System.out.println("****** tail ******");
        lm.statsTail(stats);

    }    
}