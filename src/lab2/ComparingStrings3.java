package lab2;

public class ComparingStrings3 {

    public static void main(String[] args) {

        boolean a = "ZetCode" == "ZetCode";
        boolean b = "ZetCode" == new String("ZetCode");
        boolean c = "ZetCode" == "Zet" + "Code";
        boolean d = "ZetCode" == new String("ZetCode").intern();
        boolean e = "ZetCode" == " ZetCode ".trim();
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);            
    }
}