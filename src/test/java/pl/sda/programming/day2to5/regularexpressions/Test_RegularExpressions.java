package pl.sda.programming.day2to5.regularexpressions;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Test_RegularExpressions {

    private static final Logger log = LoggerFactory.getLogger(Test_RegularExpressions.class);

    private Task_RegularExpressions regex = new Solutions_RegularExpressions();

    @Test
    void simpleMatchingFromString() {
        boolean numberMatching = "123".matches("\\d{3}");
        log.info("number matching={}", numberMatching);

        log.info("or matching: {}", "ala".matches("[abc]la"));
    }

    @Test
    void simpleMatchingByPattern() {
        Pattern pattern = Pattern.compile("ala");
        log.info("pattern matches={}", pattern.matcher("ala").matches());
    }

    @Test
    void testSymbolQuestionMark() {
        Pattern pattern = Pattern.compile("kr?at");
        assertTrue(pattern.matcher("krat").matches());
        assertTrue(pattern.matcher("kat").matches());
        assertFalse(pattern.matcher("krrat").matches());
        assertFalse(pattern.matcher("kot").matches());
    }

    @Test
    void testSymbolAsterix() {
        Pattern pattern = Pattern.compile("uwa*ga");
        assertTrue(pattern.matcher("uwga").matches());
        assertTrue(pattern.matcher("uwaga").matches());
        assertTrue(pattern.matcher("uwaaaaaaga").matches());
        assertFalse(pattern.matcher("uwagaaaa").matches());
    }

    @Test
    void testSymbolPlus() {
        Pattern pattern = Pattern.compile("trampo+lina");
        assertTrue(pattern.matcher("trampolina").matches());
        assertTrue(pattern.matcher("trampoooolina").matches());
        assertFalse(pattern.matcher("tramplina").matches());
    }

    @Test
    void testSymbolDot() {
        Pattern pattern = Pattern.compile("ko.ek");
        assertTrue(pattern.matcher("kotek").matches());
        assertTrue(pattern.matcher("korek").matches());
        assertFalse(pattern.matcher("koek").matches());
        assertFalse(pattern.matcher("ktek").matches());
    }

    @Test
    void testSymbolDotWithOthers() {
        Pattern pattern = Pattern.compile("k+a.*ta");
        assertTrue(pattern.matcher("katapulta").matches());
        assertTrue(pattern.matcher("karta").matches());
        assertTrue(pattern.matcher("kasia ma kota").matches());
        assertTrue(pattern.matcher("kkkka#$*&JHDFSta").matches());
        assertFalse(pattern.matcher("ata").matches());
        assertFalse(pattern.matcher("kta").matches());
    }

    @Test
    void testSimpleClasses() {
        Pattern pattern = Pattern.compile("[rtmp]aca");
        assertTrue(pattern.matcher("raca").matches());
        assertTrue(pattern.matcher("taca").matches());
        assertTrue(pattern.matcher("maca").matches());
        assertTrue(pattern.matcher("paca").matches());
        assertFalse(pattern.matcher("praca").matches());
        assertFalse(pattern.matcher("pacanow").matches());
    }

    @Test
    void testClassWithRangeNumber() {
        Pattern pattern = Pattern.compile("[0-7]xyz");
        assertTrue(pattern.matcher("0xyz").matches());
        assertTrue(pattern.matcher("1xyz").matches());
        assertTrue(pattern.matcher("7xyz").matches());
        assertFalse(pattern.matcher("8xyz").matches());
        assertFalse(pattern.matcher("07xyz").matches());
    }

    @Test
    void testClassWithMultipleRanges() {
        Pattern pattern = Pattern.compile("[a-cA-C0-3]bum");
        assertTrue(pattern.matcher("abum").matches());
        assertTrue(pattern.matcher("Bbum").matches());
        assertTrue(pattern.matcher("0bum").matches());
        assertFalse(pattern.matcher("dbum").matches());
        assertFalse(pattern.matcher("aA0bum").matches());
    }

    @Test
    void testClassNegation() {
        Pattern pattern = Pattern.compile("[^xyz]awa");
        assertTrue(pattern.matcher("kawa").matches());
        assertTrue(pattern.matcher("pawa").matches());
        assertTrue(pattern.matcher("Wawa").matches());
        assertFalse(pattern.matcher("zawa").matches());
        assertFalse(pattern.matcher("yawa").matches());
    }

    @Test
    void matcherFind() {
        Pattern pattern = Pattern.compile("(kot)");
        Matcher matcher = pattern.matcher("Ala ma kota, kot ma ale");
        while (matcher.find()) {
            log.info("group={}, start={}, end={}", matcher.group(), matcher.start(), matcher.end());
        }
    }

    @Test
    void moreGroups() {
        Pattern datePattern = Pattern.compile("^\\d{4}(-\\d{2}){2}$");
        Matcher matcher = datePattern.matcher("1994-12-21");
        log.info("is valid={}", matcher.matches());
    }

    @Test
    void testBasicGroups() {
        Pattern pattern = Pattern.compile("[^-]*--(\\w+)--.*");
        Matcher matcher = pattern.matcher("Ala ma kota. Kota ma na imie --Zygmunt--. Kot jest czarny.");
        matcher.matches();
        assertEquals("Zygmunt", matcher.group(1));
    }

    @Test
    void shouldValidatePesel() {
        String pesel = "88021356845";
        boolean isValid = regex.isPeselValid(pesel);
        log.info("pesel={} is valid={}", pesel, isValid);
    }

    @Test
    void shouldValidateNip() {
        assertThat(regex.isNipValid("8631613456")).isTrue();
        assertThat(regex.isNipValid("863-161-34-56")).isTrue();
        assertThat(regex.isNipValid("863d613456")).isFalse();
    }

    @Test
    void shouldValidatePhone() {
        assertThat(regex.isPhoneValid("78-12-556-467")).isTrue();
        assertThat(regex.isPhoneValid("78-12-556-467-98-88")).isFalse();
    }

    @Test
    void shouldValidatePostalCode() {
        assertThat(regex.isPostalCodeValid("01-234")).isTrue();
        assertThat(regex.isPostalCodeValid("01-2X4")).isFalse();
    }
}
