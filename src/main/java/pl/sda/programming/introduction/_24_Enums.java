package pl.sda.programming.introduction;

final class _24_Enums {
    public static void main(String[] args) {
        Status status = Status.IN_PROGRESS;
        status = Status.SENT;
        status = Status.DELIVERED;

        // status is ordinal and string
        // avoid ordinal when you persisting data!!!
        int i1 = status.ordinal();
        System.out.println(status + " ordinal is " + i1);

        String name = status.name();
        System.out.println("status name " + name);

        // how to compare enums
        Status status2 = Status.IN_PROGRESS;
        System.out.println("equals = " + status.equals(status2));
        status = Status.IN_PROGRESS;
        System.out.println("equals = " + status.equals(status2));
        System.out.println("equals == " + (status == status2));

        // how to convert string to enum
        Status statusFromString = Status.valueOf("SENT");
        System.out.println("status from string " + statusFromString);

        // enum can be used in switch
        switch (statusFromString) {
            case IN_PROGRESS:
                System.out.println("it's in progress");
                break;
            case SENT:
                System.out.println("it's sent");
                break;
            case DELIVERED:
                System.out.println("it's delivered");
                break;
        }
    }
}

enum Status {
    IN_PROGRESS(1) {
        @Override
        void doSomething() {
            System.out.println("in progress");
        }
    }, SENT(2) {
        @Override
        void doSomething() {
            System.out.println("sent");
        }
    }, DELIVERED(3) {
        @Override
        void doSomething() {
            System.out.println("delivered");
        }
    };

    private int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    abstract void doSomething();
}