package com.alevel.trucking.error.exception;

public class TransportExistException extends Exception {

    public TransportExistException(String LicensePlateNumber) {
        super("Transport with LicensePlateNumber=" + LicensePlateNumber + " exist");
    }
}
