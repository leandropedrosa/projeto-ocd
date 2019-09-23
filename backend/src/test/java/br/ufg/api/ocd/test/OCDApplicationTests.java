package br.ufg.api.ocd.test;

import br.ufg.api.ocd.ApiOcdApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OCDApplicationTests {

    @Test
    public void contextLoads() {
        ApiOcdApplication app = new ApiOcdApplication();
        assertNotNull(app);
    }

    @Test
    public void contextMongo() {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

    }

}
