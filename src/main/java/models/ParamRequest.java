package models;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "registration",
        "metod",
        "PhoneNumber",
        "clientID",
        "lastName"
})
@Generated("jsonschema2pojo")
public class ParamRequest {

    @JsonProperty("registration")
    private Boolean registration;

    @JsonProperty("metod")
    private String metod;

    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @JsonProperty("clientID")
    private String clientID;

    @JsonProperty("lastName")
    private String lastName;


    public ParamRequest() {
    }


    public Boolean getRegistration() {
        return registration;
    }

    public void setRegistration(Boolean registration) {
        this.registration = registration;
    }

    public String getMetod() {
        return metod;
    }

    public void setMetod(String metod) {
        this.metod = metod;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ParamRequest{" +
                "registration=" + registration +
                ", metod='" + metod + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", clientID='" + clientID + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}


