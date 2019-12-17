package com.company.Person;

/**
 * Перечисление описывающие пол человека.
 */
public enum Gender {
    /**
     * Мужчина.
     */
    MALE,
    /**
     * Женщина.
     */
    FEMALE;

    /**
     * Сравнивает является введенная строка
     * полом человека,иначе генерирует ошибку.
     *
     * @param gender строка.
     * @return Объект перечисления.
     */
    public static Gender enumCompare(final String gender) {

        for (Gender env : values()) {
            if (gender.equalsIgnoreCase(gender) ){
                return env;
            }
        }
        throw new IllegalArgumentException("Введите пол");
    }
}
