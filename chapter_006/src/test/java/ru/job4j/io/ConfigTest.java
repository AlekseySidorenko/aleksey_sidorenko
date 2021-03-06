package ru.job4j.io;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class ConfigTest | Reading configuration file  [#858]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 10.04.2019
 */
public class ConfigTest {

    /**
     * Test load().
     */
    @Test
    public void whenReadEmptyFileThenMapIsEmpty() {
        ClassLoader loader = this.getClass().getClassLoader();
        String path = loader.getResource("config-test/config.empty.app.properties").getPath();
        Config config = new Config(path);
        config.load();
        assertTrue(config.getValues().isEmpty());
    }

    /**
     * Test load() and getValue().
     */
    @Test
    public void whenReadRealFileThenMapGotData() {
        ClassLoader loader = this.getClass().getClassLoader();
        String path = loader.getResource("config-test/config.app.properties").getPath();
        Config config = new Config(path);
        String sampleKeyFromFile = "hibernate.connection.driver_class";
        String sampleValueFromFIle = "org.postgresql.Driver";
        config.load();
        assertEquals(config.getValue(sampleKeyFromFile), sampleValueFromFIle);
    }
}