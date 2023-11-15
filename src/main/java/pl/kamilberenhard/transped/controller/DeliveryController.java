package pl.kamilberenhard.transped.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kamilberenhard.transped.model.Delivery;
import pl.kamilberenhard.transped.service.DeliveryService;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/deliveries")
    public List<Delivery> getDeliveries() {
        return deliveryService.getDeliveries();
    }

    @PostMapping("/deliveries")
    public Delivery addDelivery(@RequestBody Delivery delivery) {
        return deliveryService.addDelivery(delivery);
    }

    @DeleteMapping("/deliveries/{id}")
    public void deleteDelivery(@PathVariable long id) {
        deliveryService.deleteDelivery(id);
    }

    @PostMapping("/deliveries/addParcelToDelivery")
    public void addParcelToDelivery(@RequestParam long parcelId, @RequestParam long deliveryId) {
        deliveryService.addParcelToDelivery(parcelId, deliveryId);
    }

    @DeleteMapping("/deliveries/deleteParcelFromDelivery")
    public void deleteParcelFromDelivery(@RequestParam long parcelId, @RequestParam long deliveryId) {
        deliveryService.deleteParcelFromDelivery(parcelId, deliveryId);
    }
}
