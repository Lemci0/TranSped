package pl.kamilberenhard.transped.service;

import org.springframework.stereotype.Service;
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
        parcel.calculatePalletSpace();
        return parcelRepository.save(parcel);
    }
}
