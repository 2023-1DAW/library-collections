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

    }
}