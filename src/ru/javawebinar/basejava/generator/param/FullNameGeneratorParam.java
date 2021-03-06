package ru.javawebinar.basejava.generator.param;
/*
 * @author Stepan Shcherbakov /uglic.ru/ 2019
 */

public class FullNameGeneratorParam implements IGeneratorParameter {
    private final boolean isMan;
    private final String fullName;

    public FullNameGeneratorParam(boolean isMan, String fullName) {
        this.isMan = isMan;
        this.fullName = fullName;
    }

    @Override
    public Boolean isMan() {
        return isMan;
    }

    @Override
    public String getFullName() {
        return fullName;
    }
}
