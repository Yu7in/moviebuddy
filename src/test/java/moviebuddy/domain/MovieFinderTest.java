package moviebuddy.domain;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import moviebuddy.MovieBuddyFactory;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieFinder;

/**
 * @author springrunner.kr@gmail.com
 */
public class MovieFinderTest {
	
	final static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieBuddyFactory.class);
	final static MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);
	
	@Test
	void NotEmpty_directedBy() {
		List<Movie> movies = movieFinder.directedBy("Michael Bay");
		Assertions.assertEquals(3, movies.size());
	}
	
	@Test
	void NotEmpty_ReleasedYearBy() {
		List<Movie> movie = movieFinder.releasedYearBy(2015);
		Assertions.assertEquals(225, movie.size());
	}

	public static void main(String[] args) {
		List<Movie> result = movieFinder.directedBy("Michael Bay");
		assertEquals(3, result.size());

        result = movieFinder.releasedYearBy(2015);
        assertEquals(225, result.size());
	}
	
	static void assertEquals(long expected, long actual) {
		if (expected != actual) {
			throw new RuntimeException(String.format("actual(%d) is different from the expected(%d)", actual, expected));			
		}
	}
	
}
