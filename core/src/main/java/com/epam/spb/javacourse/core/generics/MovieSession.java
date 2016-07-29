package com.epam.spb.javacourse.core.generics;

import java.util.LinkedList;
import java.util.List;

public class MovieSession<T extends AgeCategory> {
    private final T ageCategory;
    private final String name;
    private String duration, description;

    MovieSession(String name, T ageCategory) {
        this.name = name;
        this.ageCategory = ageCategory;
    }

    public String getMovieAnnotation() {
        return "Name: " + name + "; " +
                "Age category: " + ageCategory.getPossibleScenesAsString();
    }


    public T getCategory() {
        return ageCategory;
    }

    public static class MSKids extends MovieSession<KidsCategory> {
        MSKids(String name) {
            super(name, new KidsCategory());
        }
    }

    public static class MSSeniors extends MovieSession<SeniorCategory> {
        MSSeniors(String name) {
            super(name, new SeniorCategory());
        }
    }

    public static void process(List<? extends MovieSession> mSs) {
        for (MovieSession ms : mSs) {
            System.out.println("Movie session " + ms.getMovieAnnotation());
        }
    }

    public static void main(String[] args) {
        List<MovieSession> mSs = new LinkedList<>();


        MSKids лунтик = new MSKids("Лунтик");
        mSs.add(лунтик);

        MovieSession<SeniorCategory> большой_лебовски = new MovieSession<>
                ("Большой_Лебовски", new SeniorCategory());
        большой_лебовски
                .getCategory()
                .sexDrugsRockAndRoll();
        mSs.add(большой_лебовски);
        process(mSs);

        System.out.println("> " + asByte(new Float(7)));
        System.out.println("> " + asByte(new Integer(125)));
    }

    public static <EEE extends Number> byte asByte(EEE num) {
        long n = num.longValue();
        if (n >= -128 && n <= 127) return (byte) n;
        else return 0;
    }


}

abstract class AgeCategory {
    abstract List<String> getPossibleScenes();
    public void балет_и_керамика() {}

    public String getPossibleScenesAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> possibleScenes = getPossibleScenes();
        for (String str : possibleScenes) {
            stringBuilder.append(str).append(" ");
        }

        return stringBuilder.toString();
    }
}

class KidsCategory extends AgeCategory {
    @Override
    List<String> getPossibleScenes() {
        List<String> list = new LinkedList<>();
        list.add("смех");
        list.add("танцы");
        list.add("песни");
        return list;
    }


    public final void fantasy() {

    }
}

class JuniorCategory extends KidsCategory {
    @Override
    List<String> getPossibleScenes() {
        List<String> al = super.getPossibleScenes();
        al.add("спорт");
        al.add("приключения");
        return al;
    }

}

class SeniorCategory extends JuniorCategory {
    List<String> getPossibleScenes() {
        List<String> al = super.getPossibleScenes();
        al.add("грязные танцы");
        al.add("насилие");
        return al;
    }

    public void sexDrugsRockAndRoll() {

    }
}





























