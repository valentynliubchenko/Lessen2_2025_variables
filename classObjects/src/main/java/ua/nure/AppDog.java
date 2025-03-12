package ua.nure;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AppDog
{
    public static void main( String[] args )
    {
        MyDog dog = new MyDog("dog");
        log.info("{}", dog);
    }
}
