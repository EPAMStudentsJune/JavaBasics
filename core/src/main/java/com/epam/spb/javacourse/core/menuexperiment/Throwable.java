package com.epam.spb.javacourse.core.menuexperiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Throwable extends MI implements INavigation {
    private MyScanner myScanner = new MyScanner();

    Stack<IMenuItem> stack = new Stack<IMenuItem>();

    public static void main(String[] args) {
        Throwable ih = new Throwable();
        ih.run();
    }

    private int readInput() {
        return myScanner.nextInt();
    }


    @Override
    public void run() {
        stack.push( this );
        while (!isEnd()) {
            int input =
                    !getCurrent().printMenu()
                            ? myScanner.nextInt()
                            : 42;
            if( input == INavigation.BACK ) {
                goPrevious();
            } else {
                getCurrent().process(input, this);
            }
        }
    }

    @Override
    public String getPresentationString() {
        return null;
    }

    @Override
    void fillMenuItems(List<IMenuItem> list) {
        list.add(new Error());
        list.add(new Exception());
    }

    @Override
    public boolean isEnd() {
        return stack.isEmpty();
    }

    @Override
    public IMenuItem getCurrent() {
        return stack.peek();
    }

    @Override
    public void goPrevious() {
        stack.pop();
    }

    @Override
    public void goNext(IMenuItem iMenuItem) {
        stack.push(iMenuItem);
    }
}

interface INavigation {
    static final int BACK = -1;
    boolean isEnd();
    IMenuItem getCurrent();
    void goPrevious();
    void goNext(IMenuItem iMenuItem);
}

abstract class MI implements IMenuItem {
    private final List<IMenuItem> mi = new ArrayList<>();

    public MI() {
        fillMenuItems(getMenuItems());
    }

    @Override
    public List<IMenuItem> getMenuItems() {
        return mi;
    }

    @Override
    public String getPresentationString() {
        return "> " + this.getClass().getSimpleName();
    }

    abstract void fillMenuItems(List<IMenuItem> list);
}

class Error extends MI {
    @Override
    void fillMenuItems(List<IMenuItem> list) {}
}

class Exception extends MI {
    @Override
    void fillMenuItems(List<IMenuItem> list) {
        list.add(new NotRuntime());
        list.add(new RuntException());
    }
}

class NotRuntime extends MI {
    @Override
    void fillMenuItems(List<IMenuItem> list) {}
}

class RuntException extends MI {
    @Override
    void fillMenuItems(List<IMenuItem> list) {}
}

interface IMenuItem extends Runnable {

    default void run() {
        System.out.println("Call of run " + getClass().getSimpleName());
    }

    String getPresentationString();

    default List<IMenuItem> getMenuItems() {
        return new ArrayList<>(0);
    }

    default boolean printMenu() {
        List<IMenuItem> menuItems = getMenuItems();
        int i = 0;
        if (!menuItems.isEmpty()) {
            System.out.println("==============================");
            System.out.println("Menu: ");
            System.out.println("-1" + " go back");

            for (IMenuItem mi : menuItems) {
                System.out.println(i++ + " " + mi.getPresentationString());
            }
        }

        return menuItems.isEmpty();
    }

    default void process(int input, INavigation navigation) {
        if( getMenuItems().isEmpty() ) {
            run();
            navigation.goPrevious();
        } else {
            navigation.goNext(getMenuItems().get(input));
        }
    }
}

class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine(){
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}