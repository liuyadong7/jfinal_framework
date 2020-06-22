package core2.security.loader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 自定义类加载器
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        runClass("core2.security.loader.class", "3");
    }

    /**
     * 运行class
     */
    public static void runClass(String name, String key) {
        try {
            ClassLoader loader = new CryptoClassLoader(Integer.parseInt(key));
            Class<?> c = loader.loadClass(name);
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object) new String[]{});
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}

/**
 * 加密类加载器
 */
class CryptoClassLoader extends ClassLoader {

    private int key;

    public CryptoClassLoader(int key) {
        this.key = key;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            byte[] classBytes = null;
            classBytes = loadClassByte(name);

            //传给JVM
            Class<?> c1 = defineClass(name, classBytes, 0, classBytes.length);
            if (c1 == null) {
                throw new ClassNotFoundException(name);
            }
            return c1;
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    private byte[] loadClassByte(String name) throws IOException {
        String cname = name.replace('.' ,'/') + ".caesar";
        byte[] bytes = Files.readAllBytes(Paths.get(cname));
        for (int i= 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - key);
        }

        return bytes;
    }

}



