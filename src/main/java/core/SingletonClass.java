package core;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/* Different ways to achieve -
1. eager initialization
2. eager initialization using static block
3. double check locking mechanism
4. bill pugh implementation
5. using enum
 */
class Singleton implements Cloneable, Serializable {

    /*eager initialization -
     1. object is created when class is loaded, even if not used
     2. guaranteed thread safe
     3. use only if singleton class is light,
     4. exception handling not supported using this method
    */
    //private static Singleton instance = new Singleton();

    //exception handling can be done but other problem same as that of lazy initialization
    /*static {
        instance = new Singleton();
    }*/

    //volatile - makes sure object created by one thread is reflected to another thread immediately
    private static volatile Singleton instance = null;

    //private constructor so that can't be called from outside this class
    private Singleton() {
        //to prevent object creation using reflection. This can solve only if object is already created, otherwise use enum method
        if(instance != null) {
            throw new RuntimeException("Singleton object is already created");
        }
    }

    //static - can be called without instance
    //making method as synchronized make this method very expensive & decrease performance of the program since multiple threads cannot access simultaneously even when object is already created
    public static Singleton getInstance() {
        if(instance == null) {
            //to support multithreaded environment - so that minimum number of threads have to wait
            synchronized (SingletonClass.class) {
                //check again as multiple threads can reach here
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    //avoid cloning to create new object
    public Singleton clone() {
        return instance;
    }

    //avoid serialization to create new object
    //Note - return type is Object
    public Object readResolve() {
        return instance;
    }

}
/*Bill Plugh implementation
inner static class is loaded only when getInstance() is called - lazy initialization
simple and thread safe
*/
class Singleton1 {

    private Singleton1() {}

    private static class InnerStaticClass {
        private static Singleton1 instance = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return InnerStaticClass.instance;
    }

}
/*
Using ENUM
1. We cannot invoke enum constructor manually, handled internally. So, not possible to break using reflection
2. thread-safe
3. cannot be broken using serialization
4. do not support lazy loading
5. not flexible enough, if later we convert singleton to multi-ton i.e. n-ton, enum does not allow
 */
enum Singleton2 {
    instance
}

public class SingletonClass {

    public static void main(String args[]) throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*works with enum approach, since it gives below exception
        Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects*/
        /*Constructor[] declaredConstructors = Singleton2.class.getDeclaredConstructors();
        for(Constructor declaredConstructor : declaredConstructors) {
            declaredConstructor.setAccessible(true);
            Object o = declaredConstructor.newInstance();
            System.out.println((Singleton) o);
        }*/
        System.out.println(Singleton2.instance.hashCode());
        System.out.println(Singleton2.instance.hashCode());
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(Singleton.getInstance());
        System.out.println((Singleton) instance.clone());
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("file.txt"));
        objectOutput.writeObject(instance);
        objectOutput.close();
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("file.txt"));
        Singleton readObject = (Singleton) objectInput.readObject();
        objectInput.close();
        System.out.println(readObject);

    }

}
