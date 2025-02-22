package ua.nure;

public class Test extends Thread  {
    public StringBuffer sbr;

    public Test() {
        sbr = new StringBuffer();
    }
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is running");
    }

    public String hello() {
        sbr.append("Hello World");
        return(sbr.toString());
    }
}
