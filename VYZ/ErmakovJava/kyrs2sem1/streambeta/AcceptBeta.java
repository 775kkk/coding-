package VYZ.ErmakovJava.kyrs2sem1.streambeta;

@FunctionalInterface
    public interface AcceptBeta<A, B> {

        void accept(A a, B b);
        // AcceptBeta<String, Integer> printRepeated = new AcceptBeta<>() {
        //     @Override
        //     public void accept(String s, Integer n) {
        //         for (int i = 0; i < n; i++) {
        //             System.out.println(s);
        //         }
        //     }
        // };
        // AcceptBeta<String, Integer> printRepeated = (s, n) -> {
        //     for (int i = 0; i < n; i++) {
        //         System.out.println(s);
        //     }
        // };
        // AcceptBeta<List<Integer>, Integer> addToList = (list, v) -> list.add(v);
    }