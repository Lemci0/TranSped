package pl.kamilberenhard.transped.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kamilberenhard.transped.model.Parcel;
import pl.kamilberenhard.transped.service.ParcelService;

import java.util.List;

@RestController
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @GetMapping("/parcels")
    public List<Parcel> getParcels() {
        return parcelService.getParcels();
    }

    @GetMapping("/parcels/{id}")
    public Parcel getSingleParcel(@PathVariable Long id) {
        return parcelService.getSingleParcel(id);
    }

    @PostMapping("/parcels")
    public Parcel addParcel(@RequestBody Parcel parcel) {
        return parcelService.addParcel(parcel);
    }

    @PutMapping("/parcels")
    public Parcel editParcel(@RequestBody Parcel parcel) {
        return parcelService.editParcel(parcel);
    }

    @DeleteMapping("parcels/{id}")
    public void deleteParcel(@PathVariable Long id) {
        parcelService.deleteParcel(id);
    }
}
