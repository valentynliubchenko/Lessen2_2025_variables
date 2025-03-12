package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppClassObjects
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int a=6;
        int b=7;
        log.info("Hello World! a={} b ={}", a, b);
        log.debug("Hello World! a={} b ={}", a, b);
        log.error("Hello World! a={} b ={}", a, b);
    }
}
