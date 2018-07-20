import java.util.HashMap;
import com.africastalking.PaymentService;
import com.africastalking.AfricasTalking;
import com.africastalking.payment.response.CheckoutResponse;
public class checkout
{
    static final String username = "sandbox";
    static final String apiKey   = "115b5bd9e3d0a91cdf5626fe81216fbfcdb0d95ca1c15aeb5f44568ad977ea54";
    String productName = "My Online Store";
    String phoneNumber;
    String currencyCode = "KES";
    String price = "KES 10.50";
    public void setPhoneNumber(String phonenumber)
    {
        phoneNumber = phonenumber;
        return;
    }

    public void setPrice(String price) {
        this.price = "KES" + price;
    }

    public void initPayment()
    {
        AfricasTalking.initialize(username,apiKey);
        PaymentService mPay = AfricasTalking.getService(AfricasTalking.SERVICE_PAYMENT);
        HashMap<String, String> metadata = new HashMap<>();
        metadata.put("agentId", "654");
        metadata.put("productId", "321");
        try
        {
            CheckoutResponse paid;
            paid = mPay.mobileCheckout(productName, phoneNumber, price, metadata);
            System.out.println(paid);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Received error response: " + ex.getMessage());
        }
    }
}