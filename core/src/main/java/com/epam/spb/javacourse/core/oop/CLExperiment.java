package com.epam.spb.javacourse.core.oop;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CLExperiment  {

    public static void main(String[] args) throws IOException {
        int a = LogicBlocks.bzz;
        String str = null;
        str.toString();
        File file = new File("/home/ivan/bzz.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw e;
        }


        System.out.println(" a " + a);
    }



    void generateReport() {
        try(FileInputStream fis = new FileInputStream(new File(""))) {
            generateFolder();
            generateNDFL3();
            generateNDFL2();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }


    private void generateNDFL2() {
    }

    private void generateNDFL3() {
        
    }

    void generateFolder() throws IOException  {
        try {
            File file = new File("...");
            if (file.mkdirs()) {

            } else {
                throw new IOException();
            }
        } catch (IOException io) {
            io.printStackTrace();
            throw io;
        }

    }
    


}
