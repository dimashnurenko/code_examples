import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitry Shnurenko
 */
public class MyClassLoader extends ClassLoader {

    private final Map<String, Class> classesHash;
    public final  String[]           classPath;

    public MyClassLoader(String[] classPath) {
        this.classPath = classPath;
        this.classesHash = new HashMap<>();
    }

    protected synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class result = findClass(name);

        if (resolve) {
            resolveClass(result);
        }
        return result;
    }

    protected Class findClass(String name) throws ClassNotFoundException {
        Class result = classesHash.get(name);

        if (result != null) {
            System.out.println("% Class " + name + " found in cache");
            return result;
        }

        File f = findFile(name.replace('.', '/'), ".class");

        System.out.println("% Class " + name + (f == null ? "" : " found in " + f));

        if (f == null) {
            return findSystemClass(name);
        }

        try {
            byte[] classBytes = loadFileAsBytes(f);
            result = defineClass(name, classBytes, 0, classBytes.length);

        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException("Format of class file incorrect for class " + name + ": " + e);
        }
        classesHash.put(name, result);

        return result;
    }

    protected java.net.URL findResource(String name) {
        File f = findFile(name, "");

        if (f == null) {
            return null;
        }
        try {
            return f.toURL();
        } catch (java.net.MalformedURLException e) {
            return null;
        }
    }

    private File findFile(String name, String extension) {
        for (String aClassPath : classPath) {
            File f = new File((new File(aClassPath)).getPath() +
                                      File.separatorChar +
                                      name.replace('/', File.separatorChar) + extension);
            if (f.exists()) {
                return f;
            }
        }
        return null;
    }

    public static byte[] loadFileAsBytes(File file) throws IOException {
        byte[] result = new byte[(int) file.length()];

        FileInputStream f = new FileInputStream(file);
        try {
            f.read(result, 0, result.length);
        } finally {
            try {
                f.close();
            } catch (Exception e) {
                //to do nothing
            }
        }
        return result;
    }
}
