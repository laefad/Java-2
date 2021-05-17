package com.company.pr6.FabricMethod;

public class BookFactory {

    public enum BOOK_TYPES {
        HARDCOVER,
        PHONE
    }

    public static Book makeBook(BOOK_TYPES type){
        switch (type) {
            case PHONE:
                return new PhoneBook();
            case HARDCOVER:
                return new HardcoverBook("Crime and punishment");
        }

        throw new NullPointerException();
    }
}
