package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void shouldAllPoster() {//добавление фильмов
        PosterManager manager = new PosterManager();
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель Белград");

        String[] expected = {"Бладшот", "Вперед", "Отель Белград"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterDefaultLimit() { //вывод последних фильмов с лимитом по умолчанию 5
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
    public void shouldPosterNewLimit () {// вывод фильмов конструктором с лимитом 7
        PosterManager manager = new PosterManager(7);

        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель Белград");
        manager.add("Джентльмены");
        manager.add("Человек неведимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек неведимка", "Джентльмены", "Отель Белград", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterBelowNewLimit() {// вывод последних фильмов, общее количество которых меньше лимита
        PosterManager manager = new PosterManager();

        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель Белград");

        String[] expected = {"Отель Белград", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterAboveNewLimit() {// вывод последних фильмов, общее количество которых больше лимита
        PosterManager manager = new PosterManager(3);

        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель Белград");
        manager.add("Джентльмены");
        manager.add("Человек неведимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");
        manager.add("Паразиты");

        String[] expected = {"Паразиты", "Номер один", "Тролли. Мировой тур"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
