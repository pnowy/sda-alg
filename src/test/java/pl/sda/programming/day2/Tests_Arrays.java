package pl.sda.programming.day2;

import org.junit.jupiter.api.Test;
import pl.sda.programming.day2.solutions.Solutions_Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Tests_Arrays {

    @Test
    void shouldCountAvg() {
        Solutions_Arrays arrays = new Solutions_Arrays();
        double avg = arrays.avg(new int[]{1, 5, 6, 19});
        assertThat(avg).isEqualTo(7.75);
    }
}
