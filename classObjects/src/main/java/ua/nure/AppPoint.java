package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppPoint
{
    public static void main( String[] args )
    {
        MyPoint myPoint = new MyPoint(115,6);

        log.error("{} {} {}", myPoint.x(), myPoint.y(), myPoint.hashCode());

        myPoint = new MyPoint(15,26);

        log.error("{} {} {}", myPoint.x(), myPoint.y(), myPoint.hashCode());
        log.error("{}", myPoint);
        MyPoint myPoint2 = MyPoint.create();
        log.error("{}", myPoint2);
    }
}
