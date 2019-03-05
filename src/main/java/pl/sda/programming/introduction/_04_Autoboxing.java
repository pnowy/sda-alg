package pl.sda.programming.introduction;

final class _04_Autoboxing {

    public static void main(String[] args) {

        int i1 = 0;
        // boxed classes
        Integer i2 = new Integer(0);

        Long l1 = new Long(10);

        // i2 is unwrapped to primitive int
        long y = i1 + i2 + l1;
        System.out.println("y is " + y);

        Long l2 = i2.longValue() + i1;

        // Boxed types
        byte b0 = 0;
        Byte b1 = new Byte(b0);

        Short s1 = 10;
        s1 = null;

        Integer ii1 = new Integer(1);

        Long lo1 = new Long(1);

        Boolean bool1 = new Boolean(true);

        Float f1  = new Float(3.55);
        Double d1 = new Double(12.00);

        Character c1 = new Character('2');

        // null watch out!!!!!!
        Integer nullable = null;
        // int j1 = 10 + nullable; -> will throw exception

        int y1 = 10;
        y1 = 40;
        Integer y2 = 10;
        y2 = 40;

        boolean isEqual = (y1 == y2);
        System.out.println("is equal " + isEqual);

        Integer w1 = 5;
        Integer w2 = 5;
        isEqual = (w1 == w2);
        System.out.println("w1 is equal w2 " + isEqual);

        System.out.println(new Integer(10).equals(new Integer(10)));
    }
}
