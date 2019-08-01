package io.khasang.gahelp.model;

public interface CreateTable {
    /**
     * Method required for adding table to DB
     * @return status with string
     */
    String tableCreationStatus();

    /**
     * @param name - specific name of cat's
     * @return count of cat'c with specific name
     */
    Integer getInfo(String name);

    Integer setUpdateHair(String name);
}
