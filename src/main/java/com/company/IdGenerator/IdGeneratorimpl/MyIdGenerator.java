package com.company.IdGenerator.IdGeneratorimpl;

import com.company.IdGenerator.IIdGenerator;

/**
 * Инкремент id генератор.
 */
public class MyIdGenerator implements IIdGenerator {
    /**
     * id.
     */
    private static int id;

    @Override
    public final int getId() {
        return id++;
    }
}
