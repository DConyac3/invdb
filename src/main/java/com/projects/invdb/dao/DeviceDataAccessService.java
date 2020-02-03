package com.projects.invdb.dao;

import com.projects.invdb.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository("postgresDevice")
public class DeviceDataAccessService implements DeviceDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DeviceDataAccessService(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate; }

    @Override
    public int insertDevice(String serialNumber, Device device) {
        final String sql = "INSERT INTO device (serialNumber, os, model, dop) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql, device.getSerialNumber(), device.getOs(), device.getModel(), device.getDop());
    }

    @Override
    public List<Device> selectAllDevices() {
        final String sql = "SELECT serialNumber, model, os, dop FROM device";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String serialNumber = resultSet.getString("serialNumber");
            String model = resultSet.getString("model");
            String os = resultSet.getString("os");
            Date dop = resultSet.getDate("dop");
            return new Device(serialNumber, os, model, dop);
        });
    }

    @Override
    public int deleteDeviceBySerialNumber(String serialNumber) {
        final String sql = "DELETE FROM device WHERE serialNumber = ?";
        return jdbcTemplate.update(sql, serialNumber);
    }

    @Override
    public int updateDeviceOsBySerialNumber(String serialNumber, Device device) {
        final String sql = "UPDATE device SET os = ? WHERE serialNumber = ?";
        return jdbcTemplate.update(sql, device.getOs(), serialNumber);
    }

    @Override
    public Optional<Device> selectDeviceBySerialNumber(String serialNumber) {
        final String sql = "SELECT * FROM device WHERE serialNumber = ?";
        Device device = jdbcTemplate.queryForObject(sql, new Object[]{serialNumber}, (resultSet, i) -> {
            String serialNumberid = resultSet.getString("serialNumber");
            String model = resultSet.getString("model");
            String os = resultSet.getString("os");
            Date dop = resultSet.getDate("dop");
            return new Device(serialNumberid, os, model, dop);
        });
        return Optional.ofNullable(device);
    }
}
