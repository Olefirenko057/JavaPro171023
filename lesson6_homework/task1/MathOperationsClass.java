package org.example.lesson6_homework.task1;

public class MathOperationsClass<F extends Number,S extends Number> implements Calculator<F,S>{

    private Number addHelper(Number firstArg, Number secondArg) {
        if(firstArg instanceof Double || secondArg instanceof Double) {
            return firstArg.doubleValue() + secondArg.doubleValue();
        } else if(firstArg instanceof Float || secondArg instanceof Float) {
            return firstArg.floatValue() + secondArg.floatValue();
        } else if(firstArg instanceof Long || secondArg instanceof Long) {
            return firstArg.longValue() + secondArg.longValue();
        } else {
            return firstArg.intValue() + secondArg.intValue();
        }
    }

    private Number subHelper(Number firstArg, Number secondArg) {
        if(firstArg instanceof Double || secondArg instanceof Double) {
            return firstArg.doubleValue() - secondArg.doubleValue();
        } else if(firstArg instanceof Float || secondArg instanceof Float) {
            return firstArg.floatValue() - secondArg.floatValue();
        } else if(firstArg instanceof Long || secondArg instanceof Long) {
            return firstArg.longValue() - secondArg.longValue();
        } else {
            return firstArg.intValue() - secondArg.intValue();
        }
    }

    private Number multiHelper(Number firstArg, Number secondArg) {
        if(firstArg instanceof Double || secondArg instanceof Double) {
            return firstArg.doubleValue() * secondArg.doubleValue();
        } else if(firstArg instanceof Float || secondArg instanceof Float) {
            return firstArg.floatValue() * secondArg.floatValue();
        } else if(firstArg instanceof Long || secondArg instanceof Long) {
            return firstArg.longValue() * secondArg.longValue();
        } else {
            return firstArg.intValue() * secondArg.intValue();
        }
    }

    private Number divHelper(Number firstArg, Number secondArg) {
        if(firstArg instanceof Double || secondArg instanceof Double) {
            return firstArg.doubleValue() / secondArg.doubleValue();
        } else if(firstArg instanceof Float || secondArg instanceof Float) {
            return firstArg.floatValue() / secondArg.floatValue();
        } else if(firstArg instanceof Long || secondArg instanceof Long) {
            return firstArg.longValue() / secondArg.longValue();
        } else {
            return firstArg.intValue() / secondArg.intValue();
        }
    }


    @Override
    public void add(F firstArg, S secondArg) {
        Number result = addHelper(firstArg,secondArg);
        System.out.println(result);
    }

    @Override
    public void sub(F firstArg, S secondArg) {
        Number result = subHelper(firstArg,secondArg);
        System.out.println(result);
    }

    @Override
    public void multi(F firstArg, S secondArg) {
        Number result = multiHelper(firstArg,secondArg);
        System.out.println(result);
    }

    @Override
    public void div(F firstArg, S secondArg) {
        Number result = divHelper(firstArg,secondArg);
        System.out.println(result);
    }
}
