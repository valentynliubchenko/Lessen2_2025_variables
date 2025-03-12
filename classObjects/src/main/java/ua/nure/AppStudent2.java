package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppStudent2
{
    public static void main( String[] args )
    {
        Student2 student = new Student2("Mykola", 111);
        log.info("{}", student);
    }
}
