package VYZ.ErmakovJava.kyrs2sem1.geometrics.figure.interfaces;


public interface GetLongs {
    public double getLong();
    public static double getLong(GetLongs getLongs) {
        return getLongs.getLong();
    }
}
