package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        //Q1: add List of movies into genres and add genres into netflix
        System.out.println("Q1: Add List of movies based on the classes created above.");
        Netflix netflix = new Netflix();
        Genre action = new Genre();
        Genre love = new Genre();
        addAction(action);
        addLove(love);
        List<Genre> listOfGenres = new ArrayList<>();
        listOfGenres.add(action);
        listOfGenres.add(love);
        netflix.setGenres(listOfGenres);

        System.out.println();

        //Q2: For all movies released before 2000, add the string "(Classic)" to the title of the movie using
        System.out.println("Q2: For all movies released before 2000, add the string \"(Classic)\" to the title of the movie using\n" +
                "flatMap.");
        netflix.getGenres().stream().flatMap(g ->g.getMovies().stream()).filter(movie -> movie.getReleaseDate().before(new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime())).forEach(movie -> movie.setTitle("(Classic)" + movie.getTitle()));
        netflix.getGenres().stream().flatMap(g ->g.getMovies().stream()).forEach(movie -> System.out.println(movie.getTitle()));

        System.out.println();

        //Q3:Get the latest 3 movies released using .limit() method of stream.
        System.out.println("Q3: Get the latest 3 movies released using .limit() method of stream.");
        netflix.getGenres().stream().flatMap(g ->g.getMovies().stream()).sorted(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if(o1.getReleaseDate().after(o2.getReleaseDate())){
                    return -1;
                }else if (o2.getReleaseDate().after(o1.getReleaseDate())){
                    return 1;
                }else{
                    return 0;
                }
            }
        }).limit(3).forEach(movie -> System.out.println(movie.getTitle() + " release date:" + movie.getReleaseDate()));
        System.out.println();

        //Create a predicate for release date before 2000 and a predicate for release date before 1990
        //and then Chain the predicates for finding movies between 1990 and 2000.
        System.out.println("Q4: Create a predicate for release date before 2000 and a predicate for release date before 1990\n" +
                "and then Chain the predicates for finding movies between 1990 and 2000.");
        boolean before2000 = netflix.getGenres().stream().flatMap(g ->g.getMovies().stream()).anyMatch(movie -> movie.getReleaseDate().before(new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime()));
        boolean after1990 = netflix.getGenres().stream().flatMap(g ->g.getMovies().stream()).anyMatch(movie -> movie.getReleaseDate().after(new GregorianCalendar(1990, Calendar.DECEMBER, 31).getTime()));
        boolean before2000after1990 = netflix.getGenres().stream().flatMap(g ->g.getMovies().stream()).filter(movie -> movie.getReleaseDate().before(new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime())).anyMatch(movie -> movie.getReleaseDate().after(new GregorianCalendar(1990, Calendar.DECEMBER, 31).getTime()));
        System.out.println("If there are movies before 2000: " + before2000);
        System.out.println("If there are movies after 1990: " + after1990);
        System.out.println("If there are movies before 2000 and after 1990: " + before2000after1990);
        System.out.println();

        //Write a method which that will add release year in the title of the movie and return the title and
        //then use this method for all the movies.
        System.out.println("Q5: Write a method which that will add release year in the title of the movie and return the title and\n" +
                "then use this method for all the movies.");
        netflix.getGenres().stream().flatMap(g ->g.getMovies().stream()).forEach(movie -> movie.setTitle(movie.getReleaseDate().toString().split(" ")[5] +" " + movie.getTitle()));
        netflix.getGenres().stream().flatMap(g ->g.getMovies().stream()).forEach(movie -> System.out.println(movie.getTitle()));
        System.out.println();

        //Sorting on one of the feature(Ex: Released year or title) which will use comparator.
        System.out.println("Q6: Sorting using year ascend and print");
        netflix.getGenres().stream().flatMap(g ->g.getMovies().stream()).sorted(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if(o1.getReleaseDate().after(o2.getReleaseDate())){
                    return 1;
                }else if (o2.getReleaseDate().after(o1.getReleaseDate())){
                    return -1;
                }else{
                    return 0;
                }
            }
        }).forEach(movie -> System.out.println(movie.getTitle()));

    }

    private static void addLove(Genre love) {
        Movie  a = new Movie("titanic1",new GregorianCalendar(1982, Calendar.FEBRUARY, 11).getTime(),new String[]{"leonard","leonard"});
        Movie  b = new Movie("titanic2",new GregorianCalendar(1992, Calendar.FEBRUARY, 11).getTime(),new String[]{"leonard","leonard"});
        Movie  c = new Movie("titanic3",new GregorianCalendar(2002, Calendar.FEBRUARY, 11).getTime(),new String[]{"leonard","leonard"});
        List<Movie> movies = new ArrayList<>();
        movies.add(a);
        movies.add(b);
        movies.add(c);
        love.setMovies(movies);
    }

    public static void addAction(Genre action){
        Movie  a = new Movie("spiderman",new GregorianCalendar(2002, Calendar.FEBRUARY, 11).getTime(),new String[]{"tobey maguire","tobey maguire"});
        Movie  b = new Movie("spiderman2",new GregorianCalendar(2004, Calendar.FEBRUARY, 11).getTime(),new String[]{"tobey maguire","tobey maguire"});
        Movie  c = new Movie("spiderman3",new GregorianCalendar(2007, Calendar.FEBRUARY, 11).getTime(),new String[]{"tobey maguire","tobey maguire"});
        List<Movie> movies = new ArrayList<>();
        movies.add(a);
        movies.add(b);
        movies.add(c);
        action.setMovies(movies);
    }

}
