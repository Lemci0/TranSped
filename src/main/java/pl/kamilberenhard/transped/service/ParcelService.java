package pl.kamilberenhard.transped.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kamilberenhard.transped.model.Parcel;
import pl.kamilberenhard.transped.repository.ParcelRepository;

import java.util.List;

@Service
public class ParcelService {

    private ParcelRepository parcelRepository;

    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }


    public List<Parcel> getParcels() {
        return parcelRepository.findAll();
    }

    public Parcel getSingleParcel(Long id) {
        return parcelRepository.findById(id)
                .orElseThrow();
    }

    public Parcel addParcel(Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    @Transactional
    public Parcel editParcel(Parcel parcel) {
        Parcel editedParcel = parcelRepository.findById(parcel.getNumber()).orElseThrow();
        editedParcel.setDeliveryStreet(parcel.getDeliveryStreet());
        editedParcel.setDeliveryCity(parcel.getDeliveryCity());
        editedParcel.setDeliveryPostalCode(parcel.getDeliveryPostalCode());
        editedParcel.setLength(parcel.getLength());
        editedParcel.setWidth(parcel.getWidth());
        return editedParcel;
    }

    public void deleteParcel(Long id) {
        parcelRepository.deleteById(id);
    }
}
