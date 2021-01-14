package tests.utils;

import org.apache.commons.io.FileUtils;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestFilterListener implements IAlterSuiteListener {

    private static final String names = System.getProperty("name").toUpperCase();

    private static final String currentDirectory = System.getProperty("user.dir");
    private static final String projectDirectory = "/src/test/java/";

    private static final String[] classNames = names.split(",");
    private static final String[] extensions = {"java"};

    @Override
    public void alter(List<XmlSuite> suites){
        XmlSuite suite = suites.get(0);

        ArrayList<XmlTest> xmlTests = new ArrayList<>();

        XmlTest xmlTest= new XmlTest(suite);
        xmlTest.setName("TEST");

        //for factory parallel
        xmlTest.setParallel(XmlSuite.ParallelMode.INSTANCES);

        xmlTest.setParameters(new HashMap<>());

        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> includeList = new ArrayList<>();
        ArrayList<String> excludeList = new ArrayList<>();

        File directory = new File(currentDirectory + projectDirectory);

        List<File> files = (List<File>) FileUtils.listFiles(directory, extensions, true);

        for (String className : classNames) {
            if (className.startsWith("!") || className.startsWith("~"))
                excludeList.add(".*" + className.substring(1).replaceAll("\\*", ".+") + ".*");
            else
                includeList.add(".*" + className.replaceAll("\\*", ".+") + ".*");
        }

        for (File file : files) {
            if (file.isFile() && !file.getPath().contains("utils")) {
                String fileName = file.getName().replaceAll(".java", "");
                if (doNotExclude(fileName.toUpperCase(), excludeList) && include(fileName.toUpperCase(), includeList)) {
                    System.out.println("[TEST] " + fileName);
                    String filePath = file.getPath();
                    nameList.add(filePath.substring(filePath.indexOf("tests"))
                            .replaceAll("/", ".")
                            .replaceAll(".java", "")
                    );
                }
            }
        }

        System.out.println("[TEST] -------------------------------------------------------");
        System.out.println("[TEST] Total number of tests to run: " + nameList.size() + "\n");
        String yellow = "\u001b[33m";
        String reset = "\u001B[0m";
        if (nameList.size() == 0)
            System.out.println(yellow + "\n[ERROR] Can not find any tests matching provided criteria : " + names + "\n" + reset);

        for (String name : nameList) {
            XmlClass xmlClass = new XmlClass();
            xmlClass.setName(name);
            xmlTest.getClasses().add(xmlClass);
        }

        xmlTests.add(xmlTest);
        suite.setTests(xmlTests);
    }

    private static boolean doNotExclude(String fileName, ArrayList<String> excludeList) {
        for (String exclude : excludeList)
            if (fileName.matches(exclude))
                return false;
        return true;
    }

    private static boolean include(String fileName, ArrayList<String> includeList) {
        for (String include : includeList)
            if (!fileName.matches(include))
                return false;
        return true;
    }
}
