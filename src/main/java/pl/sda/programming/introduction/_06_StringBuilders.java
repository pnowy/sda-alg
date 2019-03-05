package pl.sda.programming.introduction;

final class _06_StringBuilders {
    public static void main(String[] args) {
        // string builders are useful for optimizing memory

        // StringBuilder example
        StringBuilder builder = new StringBuilder();
        builder.append("ala");
        builder.append(" ");
        builder.append("ma");
        builder.append(" kotów ");
        builder.append(5);

        String result = builder.toString();
        System.out.println(result);

        // fluent api
        String sentence = new StringBuilder()
                .append(" ala ")
                .append(" miała ")
                .append(" pieska ")
                .toString();
        System.out.println(sentence);

        // StringBuffer - it's thread safe and methods are synchronized
        StringBuffer buffer = new StringBuffer()
                .append(" ala ")
                .append(" zgubiła ")
                .append(" chomika ");
        System.out.println(buffer); // .toString() call is not visible but it's called


    }
}
