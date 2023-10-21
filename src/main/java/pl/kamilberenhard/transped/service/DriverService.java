package pl.kamilberenhard.transped.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kamilberenhard.transped.model.Driver;
import pl.kamilberenhard.transped.repository.DriverRepository;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }

    public Driver getSingleDriver(long id) {
        return driverRepository.findById(id).orElseThrow();
    }

    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Transactional
    public Driver editDriver(Driver driver) {
        Driver editedDriver = driverRepository.findById(driver.getDriverId()).orElseThrow();
        editedDriver.setFirstName(driver.getFirstName());
        editedDriver.setLastName(driver.getLastName());
        editedDriver.setTruckVolume(driver.getTruckVolume());
        return editedDriver;
    }

    public void deleteDriver(long id) {
        driverRepository.deleteById(id);
    }
}
