package model.entity;

/**
 * Created by Администратор on 15.05.2017.
 */
public class Address {
    private String index;
    private String city;
    private String street;
    private String buildingNumber;
    private String apartmentNumber;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getAppartmentNumber() {
        return apartmentNumber;
    }

    public void setAppartmentNumber(String appartmentNumber) {
        this.apartmentNumber = appartmentNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                '}';
    }
}
