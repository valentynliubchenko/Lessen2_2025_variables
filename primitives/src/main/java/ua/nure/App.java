package ua.nure;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExamplePrimitiv examplePrimitiv = new ExamplePrimitiv();
        examplePrimitiv.method();
        System.out.println("instanceVar" + examplePrimitiv.instanceVar);
        System.out.println("staticVar" + examplePrimitiv.staticVar);
        System.out.println("staticVar" + ExamplePrimitiv.staticVar);
        ExamplePrimitiv examplePrimitiv2 = new ExamplePrimitiv();
        ExamplePrimitiv.staticVar = 123;
        System.out.println("staticVar" + examplePrimitiv2.staticVar);
        System.out.println("staticVar" + examplePrimitiv2.staticVarFinal);
        System.out.println("global value" + Config.MAX_USERS);

        double a = 2.5654;
        int i = (int)a;
        System.out.println(i);
    }
}
