package thinkinjava.io;//: io/DirList.java
// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
  public static void main(String[] args) {
    //获取File
    File path = new File(".");
    //list为File目录
    String[] list;
    if(args.length == 0) {
      list = path.list();
    }else {
      list = path.list(new DirFilter(args[0]));
    }
    Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    for(String dirItem : list)
      System.out.println(dirItem);
  }
}

/**
 * 对文件名过滤
 */
class DirFilter implements FilenameFilter {

  private Pattern pattern;

  public DirFilter(String regex) {
    pattern = Pattern.compile(regex);
  }

  public boolean accept(File dir, String name) {
    return pattern.matcher(name).matches();
  }

} /* Output:
DirectoryDemo.java
DirList.java
DirList2.java
DirList3.java
*///:~
