//: net/mindview/util/ProcessFiles.java
package net.mindview.util;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {

    /**
     * 处理文件的策略，接口抽象;
     * 可以是任意的实现
     */
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        // Allow user to leave off extension:
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(
                                new File(arg).getCanonicalFile());
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 调用strategy来处理
     * @param root 文件
     * @throws IOException
     */
    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(
                root.getAbsolutePath(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }

    // Demonstration of how to use it:
    public static void main(String[] args) {
//        new ProcessFiles(new ProcessFiles.Strategy() {
//            public void process(File file) {
//                System.out.println(file);
//            }
//        }, "java").start(args);
        new ProcessFiles(System.out::println,"java").start(args);
    }
} /* (Execute to see output) *///:~
