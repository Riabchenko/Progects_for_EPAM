package com.intellect25.view;

import com.intellect25.controller.Path;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Writer is writing data to file
 *
 * @author Riabchenko Aliona
 */
public class Writer implements Path {

    /**
     * It writes result to file
     *
     * @param result list of result
     * @throws IOException error
     */
    public void writeFile(List<String> result) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PATH_TO_OUTPUT), "UTF-8")); //"cp1251"
        for (String string : result ){
            out.append(string);
            out.append("\n");
        }
        out.close();
    }

    /**
     * Display result
     *
     * @param result list of result
     */
    public void display(List<String> result) {
        for (String string:result)
            System.out.print(string);
    }

}
