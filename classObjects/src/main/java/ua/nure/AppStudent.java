package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppStudent
{
    public static void main( String[] args )
    {
        Student student = new Student("Mykola", 18,"Math");
        log.info("{}", student);
        Student copy = new Student(student);
        log.info("{}", copy.getAge());
        log.info("total {}", copy.getCount());
    }
}
