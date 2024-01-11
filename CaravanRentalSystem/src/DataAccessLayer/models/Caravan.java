package DataAccessLayer.models;

public class Caravan {
    private int caravanId;
    private float rentalPrice;
    private int isAvaliable;
    private String manufacturer;
    private String modelName;

    public int getCaravanId() {
        return caravanId;
    }

    public void setCaravanId(int caravanId) {
        this.caravanId = caravanId;
    }

    public float getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(float rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getIsAvaliable() {
        return isAvaliable;
    }

    public void setIsAvaliable(int isAvaliable) {
        this.isAvaliable = isAvaliable;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Caravans{" +
                "caravanId=" + caravanId +
                ", rentalPrice=" + rentalPrice +
                ", isAvaliable=" + isAvaliable +
                ", manufacturer='" + manufacturer +
                ", modelName='" + modelName +
                '}';
    }
}
