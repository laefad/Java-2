package com.company.pr6.FabricMethod;

public class Test {
    public static void main(String[] args) {
        Book b1 = BookFactory.makeBook(BookFactory.BOOK_TYPES.HARDCOVER);
        Book b2 = BookFactory.makeBook(BookFactory.BOOK_TYPES.PHONE);

        System.out.println(b1.getTitle());
        System.out.println(b2.getTitle());
    }
}
