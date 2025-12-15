package VYZ.ErmakovJava.kyrs2sem1.karate;

final class HandStrike implements Strike {
    @Override
    public void execute(Karatist kid) {
        kid.punch();
    }
}
