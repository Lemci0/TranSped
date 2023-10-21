package pl.kamilberenhard.transped.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kamilberenhard.transped.model.Delivery;
import pl.kamilberenhard.transped.model.Parcel;
import pl.kamilberenhard.transped.repository.DeliveryRepository;
import pl.kamilberenhard.transped.repository.ParcelRepository;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private ParcelRepository parcelRepository;

    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery addDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Transactional
    public void addParcelToDelivery(long parcelId, long deliveryId) {
        Parcel parcel = parcelRepository.findById(parcelId).orElseThrow();
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow();

        if (parcel != null && delivery != null) {
            parcel.setDelivery(delivery);
            parcelRepository.save(parcel);
        }
    }
}
