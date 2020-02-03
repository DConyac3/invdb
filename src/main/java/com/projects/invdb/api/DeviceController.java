package com.projects.invdb.api;

import com.projects.invdb.model.Device;
import com.projects.invdb.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/device")
@RestController
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @PostMapping
    public void insertDevice(String serialNumber, @Valid @NonNull @RequestBody Device device){
        deviceService.insertDevice(serialNumber, device);
    }

    @DeleteMapping(path = "{serialNumber}")
    public int deleteDeviceBySerialNumber(@PathVariable String serialNumber){
        return deviceService.deleteDeviceBySerialNumber(serialNumber);
    }

    @GetMapping
    public List<Device> selectAllDevices(){
        return deviceService.selectAllDevices();
    }

    @PutMapping (path = "{serialNumber}")
    public int updateDeviceBySerialNumber(@PathVariable String serialNumber, @Valid @NonNull @RequestBody Device device){
        return deviceService.updateDeviceBySerialNumber(serialNumber, device);
    }

    @GetMapping (path = "{serialNumber")
    public Optional<Device> selectDeviceBySerialNumber(@PathVariable String serialNumber){
        return deviceService.selectDeviceBySerialNumber(serialNumber);
    }
}
