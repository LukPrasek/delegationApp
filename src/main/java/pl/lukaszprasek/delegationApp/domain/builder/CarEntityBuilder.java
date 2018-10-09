package pl.lukaszprasek.delegationApp.domain.builder;

import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;

public class CarEntityBuilder implements EntityBuilder<CarEntity> {

    private CarEntity carEntity;

    public CarEntityBuilder(String brand, String model, int seatsNumber) {
        carEntity = new CarEntity();
        carEntity.setBrand(brand);
        carEntity.setModel(model);
        carEntity.setSeatsNumber(seatsNumber);
    }
    @Override
    public CarEntity build() {
        return carEntity;

    }
}
