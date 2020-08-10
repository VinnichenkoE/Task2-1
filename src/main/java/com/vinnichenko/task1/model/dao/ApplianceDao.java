package com.vinnichenko.task1.model.dao;

import com.vinnichenko.task1.exception.DaoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface ApplianceDao {

    List<String> findByType(String type) throws DaoException;

    List<String> findByParameter(String parameter, String value);

    default void closeBufferReader(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("can't close bufferedReader" + e.getMessage());
            }
        }
    }
}
