public class ti {
public static void main(String[] args) {
    float ShirtPrice = 25f;
    float PantsPrice = 30f;
    float discount = 0.15f;
    float discountpant = PantsPrice*(1-discount);
    float discountshirt = ShirtPrice*(2-discount);
    float totalprice = (discountpant+discountshirt);
    System.out.println(totalprice);
    int CantShirt = 2;
    int CantPant = 2;
    float AditionalDiscount = discountshirt*(1-0.05f);   
    System.out.println(discountpant*CantPant+discountshirt+AditionalDiscount);
    
}    
}


