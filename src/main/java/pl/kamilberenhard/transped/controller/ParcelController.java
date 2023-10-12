package pl.kamilberenhard.transped.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.kamilberenhard.transped.model.Parcel;
import pl.kamilberenhard.transped.service.ParcelService;

import java.util.List;

@RestController
public class ParcelController {

    private ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @GetMapping("/parcels")
    public List<Parcel> getParcels() {
        return parcelService.getParcels();
    }

    @GetMapping("/parcels/{id}")
    public Parcel getSingleParcel(@PathVariable Long id) {
        return parcelService.getSingleParcel(id);
    }
}
