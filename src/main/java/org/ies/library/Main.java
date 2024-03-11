package org.ies.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ies.library.model.Library;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        ObjectMapper om = new ObjectMapper();
        try {
            Library library = om
                    .readValue(
                            new File(Main.class.getResource("/data.json").toURI()),
                            Library.class
                    );
            var books = library.findBooksByGenre("Otro");
            for (var book: books) {
                System.out.println(book);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}