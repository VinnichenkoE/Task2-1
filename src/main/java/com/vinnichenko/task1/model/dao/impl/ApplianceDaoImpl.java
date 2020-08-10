package com.vinnichenko.task1.model.dao.impl;

import com.vinnichenko.task1.exception.DaoException;
import com.vinnichenko.task1.model.dao.ApplianceDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ApplianceDaoImpl implements ApplianceDao {

    @Override
    public List<String> findByType(String type) throws DaoException {
        String path = null;
        List<String> appliances = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            ResourceBundle resource = ResourceBundle.getBundle("file");
            path = resource.getString("file.path");
        } catch (MissingResourceException ex) {
            System.err.println("can not find properties file");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.contains(type)) {
                    appliances.add(line);
                }
            }
        } catch (IOException ex) {
            throw new DaoException(ex);
        } finally {
            closeBufferReader(bufferedReader);
        }
        return appliances;
    }

    @Override
    public List<String> findByParameter(String parameter, String value) {
        return null;
    }
}
