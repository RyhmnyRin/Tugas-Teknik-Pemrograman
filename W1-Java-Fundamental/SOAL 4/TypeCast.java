public class TypeCast {
    static short methodONE(long l){
        int i = (int) l;
        return (short) i;
    }

    public static void main(String[] args){
        double d = 10.25;
        float f = (float) d;
        byte b = (byte) methodONE((long) f);
        System.out.println(b);
        System.out.println(f);
    }
}
