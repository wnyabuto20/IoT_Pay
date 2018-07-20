import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class mqttClient implements MqttCallback
{
    MqttClient myClient;
    MqttConnectOptions connOpt;
    static final String BROKER_URL = "tcp://sungura1-angani-ke-host.africastalking.com:10883";
    static final String subTopic = "wayne/phoneNumber1";//"Peaches_27/payload/request";
    static final String pubTopic = "wayne/ok";
    static final String cId = "PNO";
    static final String MY_USERNAME = "wayne";
    static final String MY_PASSWORD = "waynenyabuto";
    static String phoneNumberandamount;
    static final boolean subscriber = true;
    static final boolean publisher = false;
    /**
     *
     * connectionLost
     * This callback is invoked upon losing the MQTT connection.
     *
     */
    @Override
    public void connectionLost(Throwable t)
    {
        System.out.println("connection lost!");
    }
    /**
     *
     * deliveryComplete
     * This callback is invoked when a message published by this client
     * is successfully received by the broker.
     *
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken token)
    {
        try
        {
            System.out.println("Pub complete" + new String(token.getMessage().getPayload()));
        }
        catch (MqttException e)
        {
            e.printStackTrace();
        }
    }
    /**
     *
     * messageArrived
     * This callback is invoked when a message is received on a subscribed topic.
     * PhoneNumbers and payment amounts are received as here as messages checkouts are initiated and the a Callback gateway is invoked.
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception
    {
        phoneNumberandamount = new String(message.getPayload());
        System.out.println("-------------------------------------------------");
        System.out.println("| Topic:" + topic);
        System.out.println("| Message: " + phoneNumberandamount);
        System.out.println("-------------------------------------------------");
        checkout mobpay = new checkout();
        String[] parts = phoneNumberandamount.split(",");
        String phoneNumber = parts[0];
        String amount = parts[1];
        mobpay.setPhoneNumber(phoneNumber);
        mobpay.setPrice(amount);
        new CallbackHost();
        try
        {
            mobpay.initPayment();
            System.out.println("payment request made");
        }
        catch(Exception failure)
        {
            System.out.println("request failed");
        }
    }
    /**
     *
     * MAIN
     *
     */
    public static void main(String[] args)
    {
        mqttClient smc = new mqttClient();
        smc.runClient();
    }
    /**
     *
     * runClient
     *
     * Creates an MQTT client, connects to broker, pub/sub, remains connected waiting to receive messages and publish the status of a transaction.
     *
     */
    public void runClient()
    {
       String clientID = cId;
        connOpt = new MqttConnectOptions();
        connOpt.setCleanSession(true);
        connOpt.setKeepAliveInterval(30);
        connOpt.setUserName(MY_USERNAME);
        connOpt.setPassword(MY_PASSWORD.toCharArray());

        try
        {
            myClient = new MqttClient(BROKER_URL, clientID);
            myClient.setCallback(this);
            if(myClient.isConnected() == false)
            {
                myClient.connect(connOpt);
                System.out.println("MQTT Connected? : " + myClient.isConnected());
            }
        }
        catch (MqttException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("Connected to " + BROKER_URL);
        String myTopic = subTopic;
        String otherTopic = pubTopic;
        MqttTopic topic = myClient.getTopic(myTopic);
        MqttTopic topic2 = myClient.getTopic(otherTopic);
        if (subscriber)
        {
            try
            {
                int subQoS = 2;
                myClient.subscribe(myTopic, subQoS);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (publisher)
        {
            String pubMsg = "ok";
            int pubQoS = 0;
            MqttMessage message = new MqttMessage(pubMsg.getBytes());
            message.setQos(pubQoS);
            message.setRetained(false);
            System.out.println("Publishing to topic \"" + topic2 + "\" qos " + pubQoS);
            IMqttDeliveryToken token = null;
            try
            {
                token = topic2.publish(message);
                token.waitForCompletion();
                Thread.sleep(100);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        try {
            if (subscriber) {
                Thread.sleep(Long.MAX_VALUE);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}