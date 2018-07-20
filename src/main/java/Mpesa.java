import java.util.HashMap;
import java.util.Date;

public class Mpesa{
    private HashMap<String,String> requestMetadata;
    private String sourceType;
    private String source;
    private String provider;
    private String destinationType;
    private String description;
    private String providerChannel;
    private String direction;
    private String transactionFee;
    private String providerRefId;
    private HashMap<String,String> providerMetadata;
    private String origin;
    private String status;
    private String productName;
    private String category;
    private String transactionDate;
    private String destination;
    private String value;
    private String transactionId;
    private Date createdAt;


    public Mpesa(){}
    public Mpesa(String transactionId,String value,String destination,String transactionDate,String category,
                 String productName,String status,String origin,HashMap<String,String> providerMetadata,String providerRefId,
                 String transactionFee,String direction,String providerChannel,String description,String destinationType,
                 String provider,String source,String sourceType,HashMap<String,String> requestMetadata,Date createdAt){
        this.transactionId=transactionId;
        this.value=value;
        this.destination=destination;
        this.transactionDate=transactionDate;
        this.category=category;

        this.productName=productName;
        this.status=status;
        this.origin=origin;
        this.providerMetadata=providerMetadata;
        this.providerRefId=providerRefId;

        this.transactionFee=transactionFee;
        this.direction=direction;
        this.providerChannel=providerChannel;
        this.description=description;
        this.destinationType=destinationType;

        this.provider=provider;
        this.source=source;
        this.sourceType=sourceType;
        this.requestMetadata=requestMetadata;
        this.createdAt=createdAt;
    }
    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getTransactionId(){
        return transactionId;
    }

    public void setTransactionId(String transactionId){
        this.transactionId = transactionId;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public String getTransactionDate(){
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate){
        this.transactionDate = transactionDate;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getOrigin(){
        return origin;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }

    public HashMap<String,String> getProviderMetadata(){
        return providerMetadata;
    }

    public void setProviderMetadata(HashMap<String,String> providerMetadata){
        this.providerMetadata = providerMetadata;
    }

    public String getProviderRefId(){
        return providerRefId;
    }

    public void setProviderRefId(String providerRefId){
        this.providerRefId = providerRefId;
    }

    public String getTransactionFee(){
        return transactionFee;
    }

    public void setTransactionFee(String transactionFee){
        this.transactionFee = transactionFee;
    }

    public String getDirection(){
        return direction;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public String getProviderChannel(){
        return providerChannel;
    }

    public void setProviderChannel(String providerChannel){
        this.providerChannel = providerChannel;
    }

    public String getdescription(){
        return description;
    }

    public void setdescription(String description){
        this.description = description;
    }

    public String getdestinationType(){
        return destinationType;
    }

    public void setdestinationType(String destinationType){
        this.destinationType = destinationType;
    }

    public String getProvider(){
        return provider;
    }

    public void setProvider(String provider){
        this.provider = provider;
    }

    public String getSource(){
        return source;
    }

    public void setSource(String source){
        this.source = source;
    }

    public String getSourceType(){
        return sourceType;
    }

    public void setSourceType(String sourceType){
        this.sourceType = sourceType;
    }

    public HashMap<String,String> getRequestMetadata(){
        return requestMetadata;
    }

    public void setRequestMetadata(HashMap<String,String> requestMetadata){
        this.requestMetadata = requestMetadata;
    }

}