package es.duero4.headfirst.singleton.stat;

/**
 * 
 * @author ramon
 */
public class Singleton {
   private static Singleton uniqueInstance = new Singleton();
   
   private Singleton() {}
   
   public static Singleton getInstance() {
       return uniqueInstance;
   }
}
