package org.ies.library.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ies.library.Main;
import org.ies.library.model.Library;

import java.io.File;

public class JsonLibraryReader implements Reader<Library> {
    @Override
    public Library read() {
        ObjectMapper om = new ObjectMapper();
        try {
            Library library = om
                    .readValue(
                            new File(Main.class.getResource("/data.json").toURI()),
                            Library.class
                    );
            return library;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
