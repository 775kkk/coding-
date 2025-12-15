package VYZ.ErmakovJava.kyrs2sem1.karate;

final class LegStrike implements Strike {
    @Override
    public void execute(Karatist kid) {
        kid.kick();
    }
}
