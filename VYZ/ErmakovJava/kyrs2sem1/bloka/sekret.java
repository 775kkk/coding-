package VYZ.ErmakovJava.kyrs2sem1.bloka;

import java.util.Random;

public final class sekret {

    private static final String RANDOM_CHARS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random RND = new Random();

    private final String holderName;
    private final String secretText;
    private final sekret prev;
    private sekret next;
    private final int order;

    public sekret(String holderName, String secretText) {
        if (holderName == null) throw new IllegalArgumentException("holderName == null");
        if (secretText == null) throw new IllegalArgumentException("secretText == null");

        this.holderName = holderName;
        this.secretText = secretText;
        this.prev = null;
        this.next = null;
        this.order = 1;
    }

    // передача секрета
    public sekret(sekret previous, String newHolderName) {
        if (previous == null) throw new IllegalArgumentException("previous == null");
        if (newHolderName == null) throw new IllegalArgumentException("newHolderName == null");

        if (previous.next != null) {
            throw new IllegalStateException(
                    "секрет уже был рассказан одному человеку; повторно рассказать нельзя."
            );
        }

        System.out.println(previous.holderName + " сказал что " + previous.secretText);

        // нью текст копия + x случайных символов в x случайных мест
        this.secretText = corrupt(previous.secretText);

        this.holderName = newHolderName;
        this.prev = previous;
        this.next = null;
        this.order = previous.order + 1;

        // только один следующий
        previous.next = this;
    }

    @Override
    public String toString() {
        return holderName + ": это секрет!";
    }

    // каким по очереди был данный хранитель
    public int getOrder() {
        return order;
    }

    // сколько еще человек узнали секрет после текущего хранителя
    public int countAfter() {
        int count = 0;
        sekret cur = this.next;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // имя ннго узнавшего ofst +1 следующи, -1 предыдущий 0 текущий
    public String getHolderNameByOffset(int offset) {
        sekret target = move(offset);
        return target.holderName;
    }

    // разница в количестве символов текста секрета с ным человеком offset
    public int diffTextLengthWithOffset(int offset) {
        sekret target = move(offset);
        return Math.abs(target.secretText.length() - this.secretText.length());
    }


    private sekret move(int offset) {
        sekret cur = this;

        if (offset > 0) {
            for (int i = 0; i < offset; i++) {
                if (cur.next == null) {
                    throw new IndexOutOfBoundsException("еет следующего хранителя на offset=" + offset);
                }
                cur = cur.next;
            }
        } else if (offset < 0) {
            for (int i = 0; i < -offset; i++) {
                if (cur.prev == null) {
                    throw new IndexOutOfBoundsException("еет предыдущего хранителя на offset=" + offset);
                }
                cur = cur.prev;
            }
        }

        return cur;
    }

    private static String corrupt(String src) {
        int len = src.length();
        int maxExtra = (int) Math.floor(len * 0.10); // н = 10% от длины
        int x = (maxExtra <= 0) ? 0 : RND.nextInt(maxExtra + 1); // 0-н

        StringBuilder sb = new StringBuilder(src);
        for (int i = 0; i < x; i++) {
            int pos = RND.nextInt(sb.length() + 1);
            char ch = RANDOM_CHARS.charAt(RND.nextInt(RANDOM_CHARS.length()));
            sb.insert(pos, ch);
        }
        return sb.toString();
    }
}
