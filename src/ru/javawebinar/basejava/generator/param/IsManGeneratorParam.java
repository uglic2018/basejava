package ru.javawebinar.basejava.generator.param;

public class IsManGeneratorParam implements IGeneratorParameter {
    private final boolean isMan;

    public IsManGeneratorParam(boolean isMan) {
        this.isMan = isMan;
    }

    @Override
    public Boolean isMan() {
        return isMan;
    }
}
