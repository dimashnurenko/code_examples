import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class TestLoaders {

    @org.junit.Test
    public void myClassLoaderShouldBeTest() throws Exception {
        //to change class in runtime we need recompile class and load it via our class loader...
        MyClassLoader classLoader = new MyClassLoader(new String[]{"."});

        Class helloClass = Class.forName("Hello", true, classLoader);

        Object helloObject = helloClass.newInstance();

        assertEquals("class Hello", helloClass.toString());
        System.out.println(helloObject.getClass().getClassLoader());
    }
}
