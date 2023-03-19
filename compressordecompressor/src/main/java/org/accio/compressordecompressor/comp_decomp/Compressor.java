package org.accio.compressordecompressor.comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file) throws IOException {//Function to get input files and compress
        String fileDirectory = file.getParent();//return file directory upto parent(till file exist)
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream((fileDirectory+"/compressedfile.gz"));//where to save file
        GZIPOutputStream gzip = new GZIPOutputStream(fos);// which file to compress

        byte[] buffer = new byte[1024];//
        int len;//length to store the file

        while((len=fis.read(buffer))!=-1)
        {
            gzip.write(buffer , 0 , len);
        }
        gzip.close();
        fis.close();
        fos.close();

    }

    public static void main(String[] args) throws IOException{
        File path = new File("C:/Users/ASUS/Desktop/TestFiles/nayan");
        method(path);

    }
}
