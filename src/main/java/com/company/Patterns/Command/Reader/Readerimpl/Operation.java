package com.company.Patterns.Command.Reader.Readerimpl;

/**
 * Предоставляет операции
 * для ввода вывода объектов
 * Person .
 */
public enum Operation {
    /**
     *Добавить.
     */
    ADD,
    /**
     *Удалить.
     */
    DELETE,
    /**
     *Редактировать.
     */
    EDIT,
    /**
     *Вывод на консоль.
     */
    CPRINT,
    /**
     *Вывод в таблицу
     * JFrame.
     */
    JPRINT,
    /**
     * Сортировка объектов.
     */
    SORT;
}
