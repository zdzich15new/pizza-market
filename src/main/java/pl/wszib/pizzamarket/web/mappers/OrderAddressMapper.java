package pl.wszib.pizzamarket.web.mappers;

import pl.wszib.pizzamarket.data.entities.OrderAddressEntity;
import pl.wszib.pizzamarket.web.models.OrderAddressModel;

public class OrderAddressMapper {

    public static OrderAddressEntity toEntity(OrderAddressModel model) {
        OrderAddressEntity entity = new OrderAddressEntity();
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setStreet(model.getStreet());
        entity.setPostalCode(model.getPostalCode());
        entity.setCity(model.getCity());

        return entity;
    }
}
