package bank.stepDefinitions;

public class example {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	discountValueToGrandTotal("$130.00", "-$6.50");
    }
    
    public static void discountValueToGrandTotal(String subtotal, String discountValue) {
	String grandTotal = "";
	float grandTotalFloat = Float.parseFloat(subtotal.replace("$", "")) + Float.parseFloat(discountValue.replace("$", ""));	
	
	grandTotal = "$" + Float.toString(grandTotalFloat);
	grandTotal = grandTotal.replace(".0", ".00");
	System.out.println("============== totalValue: " + grandTotal);
    }

}
