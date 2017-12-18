package com.mudgil.demo1.commons.util;


import java.util.ArrayList;
import java.util.Arrays;


public class LatencyMeasure {
 
    private long[] times;
    private long time;
    private int index=0;
    private int maxCapacity;
 
    public LatencyMeasure(int maxCapacity) {
    	this.maxCapacity = maxCapacity;
        times = new long[maxCapacity];
 
        for (int i = 0; i < times.length; i++) {
            times[i] = -1;
        }
    }
 
    public void startMeasure(){
        time = System.nanoTime();
    }
 
    public void endMeasure() {
        times[index++] = System.nanoTime()-time;
    }
 
    public void printTimes(long [] stats) {
    	
    	for (int i = 0; i < stats.length; i++) {
    		
    		
    		System.out.println(i+" \t:" + stats[i] +" ns" +"\t:"+(stats[i]/1000) + " us"+ "\t:"+((stats[i]/1000))/1000 + "ms");
    	}
    	
    }
    
    public long[] prepareStats() {
        int filled = 0;
        System.out.println("filling...");
        for (int i = 0; i < times.length; i++) {
            if (times[i] == -1) {
                filled = i;
                System.out.println("breaking at i="+i);
                break;
            }
        }
 
        System.out.println("filled ="+filled + "\t times.length="+times.length);
        long[] popTimes = new long[filled];
        System.arraycopy(times, 0, popTimes, 0, filled);
 
        Arrays.sort(popTimes);
        System.out.println("popTimes.length ="+popTimes.length);

        return popTimes;
    }
    
    public void statsHead(long[] popTimes) {
    	
    	System.out.println("statsHead()");
    	
    	
    	for (int i =0; i <popTimes.length; i++) {
    	
    		if(i >10) {
    			break;
    		}
    		
    		printValues(popTimes[i]);    		
    	}
    }
    
    public void statsTail(long[] popTimes) {
    	
    	System.out.println("statsTail()");
    	
    	int last = popTimes.length -1;
    	for (int i = last; i > (last - 10); i--) {
    	
   		
    		printValues(popTimes[i]);    		
    	}
    }

    
    public void printValues(long values) {
    	System.out.println(values + " ns \t:"+values/1e3 + " us \t:"+values/(1e3 *1e3)+ " ms ");
    }
    
    public void printStats(long[] popTimes) {
        
        System.out.printf("Latency measured: \n" +
                        " %.2f us for 50 percentile\n" +
                        " %.2f us for 90 percentile\n" +
                        " %.2f us for 99 percentile\n" +
                        " %.2f us for 99.9 percentile\n" +
                        " %.2f us for 99.99 percentile\n" +
                        " %.2f us worst percentile\n",
                popTimes[popTimes.length / 2] / 1e3,
                popTimes[popTimes.length * 9 / 10] / 1e3,
                popTimes[popTimes.length - popTimes.length / 100] / 1e3,
                popTimes[popTimes.length - popTimes.length / 1000] / 1e3,
                popTimes[popTimes.length - popTimes.length / 10000] / 1e3,
                popTimes[popTimes.length - 1] / 1e3
        );
    }
    
    public void showWithMethod(long[] popTimes) {
    	System.out.println(" 50% \t:"+getXPercentile(popTimes,50));
    	System.out.println(" 90% \t:"+getXPercentile(popTimes,90));
    	System.out.println(" 99% \t:"+getXPercentile(popTimes,99));
    	System.out.println(" 99.9% \t:"+getXPercentile(popTimes,99.9));
    	System.out.println(" 99.99% \t:"+getXPercentile(popTimes,99.99));
    	System.out.println(" worst% \t:"+getXPercentile(popTimes,9999));
    	
    }
    
    public void show(long[] popTimes) {
        System.out.printf("Latency measured: \n" +
                " %.2f us for 50 percentile\n" +
                " %.2f us for 90 percentile\n" +
                " %.2f us for 99 percentile\n" +
//                " %.2f us for 99.9 percentile\n" +
//                " %.2f us for 99.99 percentile\n" +
                " %.2f us worst percentile\n",
                popTimes[popTimes.length / 2] / 1e3,
                popTimes[popTimes.length * 9 / 10] / 1e3,
                popTimes[popTimes.length - popTimes.length / 100] / 1e3,
//                popTimes[popTimes.length - popTimes.length / 1000] / 1e3,
//                popTimes[popTimes.length - popTimes.length / 10000] / 1e3,
                popTimes[popTimes.length - 1] / 1e3
                );
    	
    }
    
    public double getXPercentile( long[] popTimes, double percentile) {
    	 double result = -1.0; 
    	 
    	 double unit = 0;
    	 
    	 unit = 1e3 ;
    	 
    	 try {
    		 
    		 if (percentile == 50) {
    			 result = popTimes[popTimes.length / 2]/ 1e3 ;	 
    		 }
    		 
    		 if (percentile == 90) {
    			 result = popTimes[popTimes.length * 9 / 10]/ 1e3;	 
    		 }
    		 if (percentile == 99) {
    			 result = popTimes[popTimes.length - popTimes.length / 100]/ 1e3;	 
    		 }
    		 if (percentile == 99.9) {
    			 result = popTimes[popTimes.length - popTimes.length / 1000]/ 1e3;	 
    		 }
    		 if (percentile == 99.99) {
    			 result = popTimes[popTimes.length - popTimes.length / 10000]/ 1e3;	 
    		 }
    		 if (percentile == 9999) {
    			 result = popTimes[popTimes.length - 1]/ 1e3;	 
    		 }    		 
    		 
    	 } catch (ArrayIndexOutOfBoundsException e) {
    		 
    	 }
    	 
    	 
    	 return result;
    }
    
    public static void main(String[] args) throws InterruptedException {
		
    	System.out.println("starting ");
    	
    	measure1();
    	
//    	int maxCapacity = 1000000;
//    	long r = (long) ((maxCapacity / 2 )/ 1e3);
//    	
//    	System.out.println(" for 50 percentile ==> (maxCapacity / 2) / 1e3 = "+ (maxCapacity / 2) / 1e3);
//    	System.out.println(" for 90 percentile ==> (maxCapacity * 9 / 10) / 1e3 = "+ (maxCapacity * 9 / 10) / 1e3);
//    	System.out.println(" for 99 percentile ==> (maxCapacity - maxCapacity / 100) / 1e3 = "+ (maxCapacity - maxCapacity / 100) / 1e3);
//    	System.out.println(" for 99.9 percentile ==> (maxCapacity - maxCapacity / 100) / 1e3 = "+ (maxCapacity - maxCapacity / 1000) / 1e3);
//    	System.out.println(" for 99.99 percentile ==> (maxCapacity - maxCapacity / 100) / 1e3 = "+ (maxCapacity - maxCapacity / 10000) / 1e3);
//    	System.out.println(" for worst percentile ==> (maxCapacity -1) / 1e3 = "+ (maxCapacity -1) / 1e3);
    	
    	
    	    	
    	
//    	System.out.println(" 1e3 = "+1e3);
//    	System.out.println(" r = "+r);
    	
	}
    
   public static void measure1() throws InterruptedException{
    	
        LatencyMeasure lm = new LatencyMeasure(100000000);
        
        for (int i = 0; i < 10000; i++) {
            lm.startMeasure();
        	randomSleep();
            lm.endMeasure();
        }
        long stats [] = lm.prepareStats();
//        lm.printStats(stats);
        lm.showWithMethod(stats);
        
        System.out.println("****** head ******");
        lm.statsHead(stats);
        System.out.println("****** tail ******");
        lm.statsTail(stats);

    	
    }
    
    
    public static void randomSleep() throws InterruptedException{

    		for (int i =0;i<10; i++) {
    			
    			ArrayList l = new ArrayList();
    			l.add(""+i);
    		}
    	
        Thread.sleep((long)Math.random()*10);
//        Thread.sleep((long)Math.random()*10);
        
    }
    
    
}