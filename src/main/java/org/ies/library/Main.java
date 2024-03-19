package org.ies.library;

import org.ies.library.model.Library;
import org.ies.library.reader.JsonLibraryReader;
import org.ies.library.reader.Reader;

public class Main {
    public static void main(String[] args) {
        Reader<Library> libraryReader = new JsonLibraryReader();

        Library library = libraryReader.read();

        var javaBooks = library.findBooksByGenre("Java");
        for (var book: javaBooks) {
            System.out.println(book);
        }

        var customers28000 = library.findZipCodeCustomers(28001);
        for (var customer: customers28000) {
            System.out.println(customer);
        }

        library.addBookLend("1X", "23432423");
        library.addBookLend("1X", "");

        for (var bookLend: library.getBookLends()) {
            System.out.println(bookLend);
        }

        library.deleteGenreFromBook("23432423", "Programación");

        javaBooks = library.findBooksByGenre("Java");
        for (var book: javaBooks) {
            System.out.println(book);
        }


        if(library.customerHasLentBook(1, "23432423")) {
            System.out.println("BOb ha tomado prestado Programación en Java");
        }

        if(library.customerHasLentBook(2, "23432423")) {
            System.out.println("George ha tomado prestado Programación en Java");
        }

        if(library.customerHasLentBook(3, "23432423")) {
            System.out.println("Nadie ha tomado prestado Programación en Java");
        }

        System.out.println(library.getBookGenres("23432423"));

        System.out.println(library.findIsbnBookLends("23432423"));
    }
}