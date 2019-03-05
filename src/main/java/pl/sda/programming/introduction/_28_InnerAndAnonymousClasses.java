package pl.sda.programming.introduction;

import pl.sda.programming.introduction.shop.model.Customer;
import pl.sda.programming.introduction.shop.model.DiscountPolicy;
import pl.sda.programming.introduction.shop.model.Person;

final class _28_InnerAndAnonymousClasses {
    public static void main(String[] args) {
        // inner classes
        Outer outer = new Outer();
        Outer.InnerA innerA = outer.new InnerA();
        innerA.increase();

        System.out.println("i is " + outer.getI());

        Outer.InnerB innerB = outer.new InnerB();
        innerB.decrease();

        System.out.println("i is " + outer.getI());

        Outer outer1 = new Outer();
        Outer.InnerA innerA1 = outer1.new InnerA();
        innerA1.increase();

        System.out.println("inner a1 = " + outer1.getI());

        // static classes
        StaticClassExample.InnerStatic innerStatic = new StaticClassExample.InnerStatic();
        innerStatic.increase();


        // anonymous classes
        DiscountPolicy policy = new DiscountPolicy() {
            @Override
            public float getDiscount(String code) {
                return 0.9f;
            }
        };

        // anonymous class from Customer
        Customer customer = new Customer() {
            @Override
            public String getName() {
                return null;
            }
        };

        Person person = new Person("Jan", "Kowalski") {
            // you can have fields but must be initialized
            private int i = 0;

            @Override
            public String getFirstName() {
                return prefix() + super.getFirstName();
            }

            private String prefix() {
                return "Mrs.";
            }
        };
        System.out.println("first name " + person.getFirstName());


        // you can define class in method
        class AA {

        }

        abstract class BB {

        }

        AA a = new AA();
        BB bb = new BB() {};
    }

    public static void test() {
        // AA
    }
}


class StaticClassExample {
    private int i = 0;

    static class InnerStatic {
        private int i = 0;

        void increase() {
            i++;
            // StaticClassExample.this.i++;
        }
    }
}


class Outer {
    private int i = 0;

    class InnerA {
        // shadowing
        private int i = 0;
        void increase() {
            //i++;
            Outer.this.i++;
        }

        class InnerC {
            void increase() {
                Outer.this.i++;
                InnerA.this.i++;
            }
        }
    }

    class InnerB {
        void decrease() {
            i--;
        }
    }

    public int getI() {
        return i;
    }
}