package org.ies.library.model;

import java.util.Date;
import java.util.Objects;

public class BookLend implements Comparable<BookLend> {
    private String isbn;
    private Date date;
    private String nif;

    public BookLend(String isbn, Date date, String nif) {
        this.isbn = isbn;
        this.date = date;
        this.nif = nif;
    }

    public BookLend() {
    }

    @Override
    public int compareTo(BookLend o) {
        int compare = this.date.compareTo(o.getDate());
        if (compare == 0) {
            compare = this.nif.compareTo(o.getNif());
            if (compare == 0) {
                compare = this.isbn.compareTo(o.getIsbn());
            }
        }
        return compare;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookLend bookLend = (BookLend) o;

        if (!Objects.equals(isbn, bookLend.isbn)) return false;
        if (!Objects.equals(date, bookLend.date)) return false;
        return Objects.equals(nif, bookLend.nif);
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookLend{" +
                "isbn='" + isbn + '\'' +
                ", date=" + date +
                ", nif='" + nif + '\'' +
                '}';
    }
}
