package ru.netology.javaqa;

public class PosterManager {
    private String[] movies = new String[0];
    private int limitMovies; //лимит фильмов по умолчанию

    public PosterManager(int limitMovies) {// конструктор с изменяемым лимитом
    this.limitMovies = limitMovies;
    }

    public PosterManager() { //конструктор с лимитом по умолчанию
        this.limitMovies = 5;
    }

    public void add(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultLength;
        if (movies.length < limitMovies) {
            resultLength = movies.length;
        } else {
            resultLength = limitMovies;
        }
        String[] tmp = new String[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 -i];
        }
        return tmp;
    }
}
