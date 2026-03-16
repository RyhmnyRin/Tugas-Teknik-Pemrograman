// Type data T hanya boleh diisi dengan A atau inheritance nya (B atau C).
class Bound<T extends A> {

    private T objRef;

    public Bound(T obj) {
        this.objRef = obj;
    }

    public void doRunTest() {
        // T sudah pasti memiliki displayClass
        this.objRef.displayClass();
    }
}
// Superclass
class A {

    public void displayClass() {
        System.out.println("Inside super class A");
    }
}

// B dan C sebagai Subclass dari A
class B extends A {

    public void displayClass() {
        System.out.println("Inside sub class B");
    }
}

class C extends A {

    public void displayClass() {
        System.out.println("Inside sub class C");
    }
}

public class BoundedClass {

    public static void main(String a[]) {

        // Creating object of sub class C and
        // passing it to Bound as a type parameter.
        // valid, karena C keturunan A
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest();

        // Creating object of sub class B and
        // passing it to Bound as a type parameter.
        // valid, karena B keturunan A
        Bound<B> beb = new Bound<B>(new B());
        beb.doRunTest();

        // similarly passing super class A
        // valid, karena A.
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();
    }
}
