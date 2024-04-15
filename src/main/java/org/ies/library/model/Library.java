package org.ies.library.model;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private String name;
    private Map<String, Book> booksByIsbn;

    private List<Customer> customers;

    private TreeSet<BookLend> bookLends;

    public Library(String name, Map<String, Book> booksByIsbn, List<Customer> customers, TreeSet<BookLend> bookLends) {
        this.name = name;
        this.booksByIsbn = booksByIsbn;
        this.customers = customers;
        this.bookLends = bookLends;
    }

    public Library() {
    }

    public List<Book> findBooksByGenre(String genreToFind) {
//        List<Book> genreBooks = new ArrayList<>();
//        for (Book book : booksByIsbn.values()) {
////            ESTA SOLUCIÓN NO ES ÓPTIMA Y ES MÁS DIFÍCIL DE HACER
////            for(String bookGenre: book.getGenres()) {
////                if(bookGenre.equals(genre)) {
////                    genreBooks.add(book);
////                }
////            }
//            if (book.getGenres().contains(genreToFind)) {
//                genreBooks.add(book);
//            }
//        }

        return booksByIsbn
                .values()
                .stream()
                .filter(book -> book.getGenres().contains(genreToFind))
                .collect(Collectors.toList());
    }

    public List<Customer> findZipCodeCustomers(int zipCode) {
//        List<Customer> result = new ArrayList<>();
//        for (Customer customer : customers) {
//            if (customer.getZipCode() == zipCode) {
//                result.add(customer);
//            }
//        }
        return customers
                .stream()
                .filter(customer -> customer.getZipCode() == zipCode)
                .collect(Collectors.toList());
    }

    public void addBookLend(String nif, String isbn) {
        if (existsCustomer(nif) && booksByIsbn.containsKey(isbn)) {
            bookLends.add(new BookLend(isbn, new Date(), nif));
        } else {
            System.out.println("No existe el usuario o el libro");
        }
    }

    public boolean existsCustomer(String nif) {
//        for (Customer customer : customers) {
//            if (customer.getNif().equals(nif)) {
//                return true;
//            }
//        }
//        return false;
        return customers
                .stream()
                .anyMatch(customer -> customer.getNif().equals(nif));
    }

    public void deleteGenreFromBook(String isbn, String genre) {
        if (booksByIsbn.containsKey(isbn)) {
            Book book = booksByIsbn.get(isbn);
            book.getGenres().remove(genre);
        } else {
            System.out.println("No existe el libro");
        }
    }

    public boolean customerHasLentBook(int customerNumber, String isbn) {
        Customer customer = findCustomer(customerNumber);
        if (customer != null) {
            for (var bookLend : bookLends) {
                if (bookLend.getNif().equals(customer.getNif()) && bookLend.getIsbn().equals(isbn)) {
                    return true;
                }
            }
        }

        return false;
    }

    public Customer findCustomer(int customerNumber) {
        for (var customer : customers) {
            if (customer.getCustomerNumber() == customerNumber) {
                return customer;
            }
        }
        return null;
    }

    public Set<String> getBookGenres(String isbn) {
        if (booksByIsbn.containsKey(isbn)) {
            return booksByIsbn.get(isbn).getGenres();
        } else {
            return null;
        }
    }

    public List<BookLend> findIsbnBookLends(String isbn) {
//        if (booksByIsbn.containsKey(isbn)) {
//            List<BookLend> isbnBookLends = new ArrayList<>();
//            for (BookLend bookLend : bookLends) {
//                if (bookLend.getIsbn().equals(isbn)) {
//                    isbnBookLends.add(bookLend);
//                }
//            }
//            return isbnBookLends;
//        } else {
//            return null;
//        }

        if (booksByIsbn.containsKey(isbn)) {
            return bookLends
                    .stream()
                    .filter(bookLend -> bookLend.getIsbn().equals(isbn))
                    .collect(Collectors.toList());
        } else {
            return null;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Book> getBooksByIsbn() {
        return booksByIsbn;
    }

    public void setBooksByIsbn(Map<String, Book> booksByIsbn) {
        this.booksByIsbn = booksByIsbn;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public TreeSet<BookLend> getBookLends() {
        return bookLends;
    }

    public void setBookLends(TreeSet<BookLend> bookLends) {
        this.bookLends = bookLends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (!Objects.equals(name, library.name)) return false;
        if (!Objects.equals(booksByIsbn, library.booksByIsbn)) return false;
        if (!Objects.equals(customers, library.customers)) return false;
        return Objects.equals(bookLends, library.bookLends);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (booksByIsbn != null ? booksByIsbn.hashCode() : 0);
        result = 31 * result + (customers != null ? customers.hashCode() : 0);
        result = 31 * result + (bookLends != null ? bookLends.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", booksByIsbn=" + booksByIsbn +
                ", customers=" + customers +
                ", bookLends=" + bookLends +
                '}';
    }
}
