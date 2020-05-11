//: net/mindview/util/Directory.java
// Produce a sequence of File objects that match a
// regular expression in either a local directory,
// or by walking a directory tree.
package net.mindview.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;


/**
 * 这个东西用处很大
 * 1. 爬虫抓取网盘文件
 * 2. 分析java项目的结果
 * 3. 统计某个文件夹里面的信息
 */
public final class Directory {
    /**
     * 按正则获取文件目录下的文件列表
     * @param dir
     * @param regex
     * @return
     */
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(
                        new File(name).getName()).matches();
            }
        });
    }

    /**
     * 按正则获取文件目录下的文件列表
     * @param path
     * @param regex
     * @return
     */
    public static File[] local(String path, final String regex) { // Overloaded
        return local(new File(path), regex);
    }

    /**
     * 存储文件和目录
     * files
     * dirs
     */
    // A two-tuple for returning a pair of objects:
    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        // The default iterable element is the file list:
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    /**
     * 递归按正则查找文件目录下的文件列表
     * @param start
     * @param regex
     * @return
     */
    public static TreeInfo walk(String start, String regex) { // Begin recursion
        return recurseDirs(new File(start), regex);
    }

    /**
     *  递归按正则查找文件目录下的文件列表
     * @param start
     * @param regex
     * @return
     */
    public static TreeInfo walk(File start, String regex) { // Overloaded
        return recurseDirs(start, regex);
    }

    /**
     * 递归查找文件目录下的文件列表
     * @param start
     * @return
     */
    public static TreeInfo walk(File start) { // Everything
        return recurseDirs(start, ".*");
    }

    /**
     * 递归查找文件目录下的文件列表
      * @param start
     * @return
     */
    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }


    /**
     * File.isDirectory()
     * 如果文件是目录，则add to TreeInfo.dirs
     * 如果文件不是目录，add to TreeInfo.files
     * 递归执行
     * @param startDir
     * @param regex
     * @return
     */
    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else // Regular file
                if (item.getName().matches(regex))
                    result.files.add(item);
        }
        return result;
    }

    // Simple validation test:
    public static void main(String[] args) {
        if (args.length == 0)
            System.out.println(walk("."));
        else
            for (String arg : args)
                System.out.println(walk(arg));
    }
} ///:~
