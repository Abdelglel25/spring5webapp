package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is going to tell spring to look for instances of
 * this type and when it finds them, it's going to go ahead and run them
 */
@Component  // It tells spring to go ahead and detect this as a spring managed component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ehab = new Author("Ehab", "Khaled");
        Book goodHeart = new Book("Good Heart", "25111998");
        ehab.getBooks().add(goodHeart);
        goodHeart.getAuthors().add(ehab);

        authorRepository.save(ehab);
        bookRepository.save(goodHeart);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "324242243");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
