package com.odiunu.aspectj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
public aspect MyAspect {

    pointcut anySetter():
            call(* *.set*(..));
    before(): anySetter(){
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("E:\\out.txt"), StandardOpenOption.APPEND)) {

            bufferedWriter.write("Before: joinpoint: " + thisJoinPoint);
        } catch (IOException e) {
            Exception a = e;
        }
    }

    after(): anySetter(){
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("E:\\out.txt"), StandardOpenOption.APPEND)) {

            bufferedWriter.write("After: joinpoint: " + thisJoinPoint);
        } catch (IOException e) {
            Exception a = e;
        }
    }
}
