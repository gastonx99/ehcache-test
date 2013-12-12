import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;

import net.sf.ehcache.CacheManager;

import org.junit.Test;

public class EhcacheTest {

    private static final String NAME1 = "/ehcache1.xml";
    private static final String NAME2 = "/ehcache2.xml";

    private InputStream get(String name) {
        return getClass().getResourceAsStream(name);
    }

    @Test
    public void createSameName() {
        CacheManager manager1 = CacheManager.create(get(NAME1));
        CacheManager manager2 = CacheManager.create(get(NAME1));

        assertTrue(manager1 == manager2);
        assertEquals(manager1.getName(), manager2.getName());
    }

    @Test
    public void createDifferentName() {
        CacheManager manager1 = CacheManager.create(get(NAME1));
        CacheManager manager2 = CacheManager.create(get(NAME2));

        assertTrue(manager1 == manager2);
        assertEquals(manager1.getName(), manager2.getName());
    }

    @Test
    public void newInstanceSameName() {
        CacheManager manager1 = CacheManager.newInstance(get(NAME1));
        CacheManager manager2 = CacheManager.newInstance(get(NAME1));

        assertTrue(manager1 == manager2);
        assertEquals(manager1.getName(), manager2.getName());
    }

    @Test
    public void newInstanceDifferentName() {
        CacheManager manager1 = CacheManager.newInstance(get(NAME1));
        CacheManager manager2 = CacheManager.newInstance(get(NAME2));

        assertTrue(manager1 != manager2);
        assertNotEquals(manager1.getName(), manager2.getName());
    }

    @Test
    public void newInstanceAndThenGet() {
        CacheManager manager1 = CacheManager.newInstance(get(NAME1));
        CacheManager manager2 = CacheManager.getCacheManager("ehcache1-name");

        assertTrue(manager1 == manager2);
        assertEquals(manager1.getName(), manager2.getName());
    }

}
