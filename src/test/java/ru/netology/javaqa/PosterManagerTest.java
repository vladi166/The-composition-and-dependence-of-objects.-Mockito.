package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    PosterManager manager = new PosterManager(7);

    @BeforeEach
    public void setManager() {
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель Белград");
    }

    @Test
    public void shouldAllPoster() {

        String[] expected = {"Бладшот", "Вперед", "Отель Белград"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterEqualIsTheLimit() {
        PosterManager manager = new PosterManager();

        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель Белград");
        manager.add("Джентльмены");
        manager.add("Человек неведимка");

        String[] expected = {"Человек неведимка", "Джентльмены", "Отель Белград", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterBelowLimit() {

        String[] expected = {"Отель Белград", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterAboveLimit() {

        manager.add("Джентльмены");
        manager.add("Человек неведимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек неведимка", "Джентльмены", "Отель Белград", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
