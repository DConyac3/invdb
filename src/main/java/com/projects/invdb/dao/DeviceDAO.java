package com.projects.invdb.dao;

import com.projects.invdb.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceDAO {

    int insertDevice(String serialNumber, Device device);

    List<Device> selectAllDevices();

    int deleteDeviceBySerialNumber(String serialNumber);

    int updateDeviceOsBySerialNumber(String serialNumber, Device device);

    Optional<Device> selectDeviceBySerialNumber(String serialNumber);
}
