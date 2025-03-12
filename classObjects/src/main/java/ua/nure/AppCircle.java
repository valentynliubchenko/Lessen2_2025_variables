package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppCircle
{
    public static void main( String[] args )
    {
        Circle circle = new Circle(123);
        log.info(circle.toString());
    }
}
