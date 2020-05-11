package thinkinjava.io;//: io/DirectoryDemo.java
// Sample use of Directory utilities.

import net.mindview.util.Directory;
import net.mindview.util.PPrint;

import java.io.File;

import static net.mindview.util.Print.print;

public class DirectoryDemo {
  public static void main(String[] args) {
    // All directories: 递归查询所有文件和目录
    PPrint.pprint(Directory.walk(".").dirs);
    // All files beginning with 'T' 打印文件名或目录名以T开头的文件
    for(File file : Directory.local(".", "T.*"))
      print(file);
    print("----------------------");
    // All Java files beginning with 'T': 递归打印文件名或目录名以T开头的文件
    for(File file : Directory.walk(".", "T.*\\.java"))
      print(file);
    print("======================");
    // Class files containing "Z" or "z": 递归打印文件名或目录名包含Z or z的文件
    for(File file : Directory.walk(".",".*[Zz].*\\.class"))
      print(file);
  }
} /* Output: (Sample)
[.\xfiles]
.\TestEOF.class
.\TestEOF.java
.\TransferTo.class
.\TransferTo.java
----------------------
.\TestEOF.java
.\TransferTo.java
.\xfiles\ThawAlien.java
======================
.\FreezeAlien.class
.\GZIPcompress.class
.\ZipCompress.class
*///:~
