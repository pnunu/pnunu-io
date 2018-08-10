package pnunu.io;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: pnunu
 * @Date: Created in 16:07 2018/8/10
 * @Description: InputStream 转化为 string
 */
public class InputStream2String {

    private final static String FILE_PATH = "/log.log";

    /** 读取文件流 */
    public static InputStream getInputStream() {
        InputStream inputStream = new InputStream2String().getClass().getResourceAsStream(FILE_PATH);
        return inputStream;
    }

    /** JDK原生 */
    public static String readInputStream01() throws Exception {
        InputStream inputStream = getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String result = new String(bytes);
        System.out.println("InputStream2String.readInputStream01");
        return result;
    }

    /** JDK原生 */
    public static String readInputStream02() throws Exception {
        InputStream inputStream = getInputStream();
        String result = new BufferedReader(new InputStreamReader(inputStream)).lines()
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println("InputStream2String.readInputStream02");
        return result;
    }

    /** JDK原生 */
    @Deprecated
    public static String readInputStream03() throws Exception {
        InputStream inputStream = getInputStream();
        String result = new BufferedReader(new InputStreamReader(inputStream)).lines()
                .parallel().collect(Collectors.joining(System.lineSeparator()));
        System.out.println("InputStream2String.readInputStream03");
        return result;
    }

    /** JDK原生 */
    @Deprecated
    public static String readInputStream04() throws Exception {
        InputStream inputStream = getInputStream();
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        System.out.println("InputStream2String.readInputStream04");
        return result;
    }

    /** JDK原生 */
    public static String readInputStream05() throws Exception {
        InputStream inputStream = getInputStream();
        String result = new Scanner(inputStream).useDelimiter("\\Z").next();
        System.out.println("InputStream2String.readInputStream05");
        return result;
    }

    /** JDK原生 */
    public static String readInputStream06() throws Exception {
        InputStream inputStream = getInputStream();
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String result = sb.toString();
        System.out.println("InputStream2String.readInputStream06");
        return result;
    }

    /** JDK原生 */
    public static String readInputStream07() throws Exception {
        InputStream inputStream = getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, length);
        }
        String result = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
        System.out.println("InputStream2String.readInputStream07");
        return result;
    }

    /** JDK原生 */
    public static String readInputStream08() throws Exception {
        InputStream inputStream = getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int size = bufferedInputStream.read();
        while(size != -1) {
            buf.write((byte) size);
            size = bufferedInputStream.read();
        }
        String result = buf.toString();
        System.out.println("InputStream2String.readInputStream08");
        return result;
    }

    /**  Apache Common */
    public static String readInputStream09() throws Exception {
        InputStream inputStream = getInputStream();
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8.name());
        String result = writer.toString();
        System.out.println("InputStream2String.readInputStream09");
        return result;
    }

    /**  Apache Common */
    public static String readInputStream10() throws Exception {
        InputStream inputStream = getInputStream();
        String result = IOUtils.toString(inputStream, "utf-8");
        System.out.println("InputStream2String.readInputStream10");
        return result;
    }

    /**  Google Guava */
    public static String readInputStream11() throws Exception {
        InputStream inputStream = getInputStream();
        String result = CharStreams.toString(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        System.out.println("InputStream2String.readInputStream11");
        return result;
    }

    /**  Google Guava */
    public static String readInputStream12() throws Exception {
        InputStream inputStream = getInputStream();
        String result = new String(ByteStreams.toByteArray(inputStream));
        System.out.println("InputStream2String.readInputStream12");
        return result;
    }

}

