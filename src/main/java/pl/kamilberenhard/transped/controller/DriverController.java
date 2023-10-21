package pl.kamilberenhard.transped.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kamilberenhard.transped.model.Driver;
import pl.kamilberenhard.transped.service.DriverService;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers")
    public List<Driver> getDrivers() {
        return driverService.getDrivers();
    }

    @GetMapping("/drivers/{id}")
    public Driver getSingleDriver(@PathVariable long id) {
        return driverService.getSingleDriver(id);
    }

    @PostMapping("/drivers")
    public Driver addDriver(@RequestBody Driver driver) {
        return driverService.addDriver(driver);
    }

    @PutMapping("/drivers")
    public Driver editDriver(@RequestBody Driver driver) {
        return driverService.editDriver(driver);
    }

    @DeleteMapping("/drivers/{id}")
    public void deleteDriver(@PathVariable long id) {
        driverService.deleteDriver(id);
    }
}
