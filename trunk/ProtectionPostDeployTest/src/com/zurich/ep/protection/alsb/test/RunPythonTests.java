package com.zurich.ep.protection.alsb.test;

import java.io.FileInputStream;
import java.io.InputStream;

import org.python.util.PythonInterpreter;

public class RunPythonTests {
    public static void main(String[] args) throws Exception {
        PythonInterpreter py = new PythonInterpreter();
        InputStream is = new FileInputStream("RunTests.py");
        py.execfile(is);
    }
}
