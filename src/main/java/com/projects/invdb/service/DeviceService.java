package com.projects.invdb.service;

import com.projects.invdb.dao.DeviceDAO;
import com.projects.invdb.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceDAO deviceDAO;

    @Autowired
    public DeviceService(@Qualifier("postgresDevice") DeviceDAO device){
        this.deviceDAO = device;
    }

    public int insertDevice(String serialNumber, Device device){
        return deviceDAO.insertDevice(serialNumber, device);
    }

    public int deleteDeviceBySerialNumber(String serialNumber){
        return deviceDAO.deleteDeviceBySerialNumber(serialNumber);
    }

    public List<Device> selectAllDevices(){
        return deviceDAO.selectAllDevices();
    }

    public int updateDeviceBySerialNumber(String serialNumber, Device device){
        return deviceDAO.updateDeviceOsBySerialNumber(serialNumber, device);
    }

    public Optional<Device> selectDeviceBySerialNumber(String serialNumber){
        return deviceDAO.selectDeviceBySerialNumber(serialNumber);
    }
}
