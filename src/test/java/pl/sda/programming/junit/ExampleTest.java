package pl.sda.programming.junit;

import com.google.common.io.Files;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

class ExampleTest {

    private static Db db = new Db();

    @BeforeEach
    void setUp() {
        System.out.println("before test");
        Object o = new Object();

    }

    @AfterEach
    void tearDown() {
        db.clear();
    }

    @BeforeAll
    static void runOnce() {
        System.out.println("before all...");
    }

    @Test
    void shouldDoSomething() {
        int a = 2;
        int b = 2;
        int result = a + b;
        this.db.put("result-a", String.valueOf(result));
        Assertions.assertThat(result).isEqualTo(4);
        Assertions.assertThat(db.size()).isEqualTo(1);
    }

    @Test
    void shouldDoSomething2() {
        int a = 2;
        int b = 3;
        int result = a + b;
        this.db.put("result-b", String.valueOf(result));
        Assertions.assertThat(result).isEqualTo(5);
        Assertions.assertThat(db.size()).isEqualTo(1);
    }
}
