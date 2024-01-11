package BusinessLayer.services;

import DataAccessLayer.models.Caravan;
import DataAccessLayer.repositories.CaravanRepository;

import java.util.ArrayList;
import java.util.List;

public class CaravanService {
    private static CaravanService instance = null;

    private final CaravanRepository caravanRepository;

    private CaravanService() {
        this.caravanRepository = CaravanRepository.getInstance();
    }

    public static CaravanService getInstance() {

        if (CaravanService.instance == null) {
            CaravanService.instance = new CaravanService();
        }

        return CaravanService.instance;
    }

    public String castCaravanToString(Caravan caravanModule){
        String caravan = "";
        caravan = caravanModule.toString();
        return caravan;
    }

    public Caravan mapValuesToCaravan(float price, int isAvaliable,String manufacturer,String modelName){
        Caravan caravan = new Caravan();

        caravan.setRentalPrice(price);
        caravan.setIsAvaliable(isAvaliable);
        caravan.setManufacturer(manufacturer);
        caravan.setModelName(modelName);

        return caravan;
    }

    public Caravan mapValuesToCaravan(int id, float price, int isAvaliable,String manufacturer,String modelName){
        Caravan caravan = new Caravan();
        caravan.setCaravanId(id);
        caravan.setRentalPrice(price);
        caravan.setIsAvaliable(isAvaliable);
        caravan.setManufacturer(manufacturer);
        caravan.setModelName(modelName);

        return caravan;
    }

    public List<String> getAllCaravans(){
        List<String> allCaravans = new ArrayList<>();
        List<Caravan> allCaravansModules = new ArrayList<>();
        allCaravansModules = caravanRepository.getAllCaravans();

        for (Caravan caravan : allCaravansModules ){
            allCaravans.add(castCaravanToString(caravan));
        }

        return allCaravans;
    }

    public String getCaravanById(int id){
        String caravan = "";

        caravan = castCaravanToString(caravanRepository.getCaravanById(id));

        return caravan;
    }

    public void addCaravan(float price, int isAvaliable,String manufacturer,String modelName){
        caravanRepository.addCaravan(mapValuesToCaravan(price,isAvaliable,manufacturer,modelName));
    }

    public void updateCaravan(int id, float price, int isAvaliable,String manufacturer,String modelName){
        caravanRepository.updateCaravan(mapValuesToCaravan(id, price,isAvaliable,manufacturer,modelName));
    }

    public void deleteCaravan(int id) {
        caravanRepository.deleteCaravanById(id);
    }
}
