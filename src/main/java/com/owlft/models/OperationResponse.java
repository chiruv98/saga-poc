package main.java.com.owlft.models;

public class OperationResponse {

    private boolean success;
    private Object response;

    public boolean getSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }
    
    public Object getResponse(){
        return response;
    }

    public void setResponse(Object response){
        this.response = response;
    }
}
