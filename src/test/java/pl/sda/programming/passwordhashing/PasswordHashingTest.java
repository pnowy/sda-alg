package pl.sda.programming.passwordhashing;

import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

// Hashing is the process of generating a string, or hash, from a given message using a mathematical function known as a cryptographic hash function.
//
//  While there are several hash functions out there, those tailored to hashing passwords need to have four main properties to be secure:
//      It should be deterministic: the same message processed by the same hash function should always produce the same hash
//      It’s not reversible: it’s impractical to generate a message from its hash
//      It has high entropy: a small change to a message should produce a vastly different hash
//      And it resists collisions: two different messages should not produce the same hash
//
//  Also, though, password hashing functions should be slow.
//  A fast algorithm would aid brute force attacks in which a hacker will attempt to guess a
//  password by hashing and comparing billions (or trillions) of potential passwords per second.
class PasswordHashingTest {

    // NOT RECOMMENDED FOR PRODUCTION USAGE
    // MD5 was discovered to fail the fourth password hashing property in that it became computationally easy to generate collisions.
    // To top it off, MD5 is a fast algorithm and therefore useless against brute-force attacks.
    @Test
    void shouldGenerateMd5Hash() {
        System.out.println(DigestUtils.md5Hex("SDA"));
    }

    @Test
    void verifyGeneratedMd5Hash() {
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";
        String myHash = DigestUtils.md5Hex(password);

        Assertions.assertThat(myHash.toUpperCase().equals(hash)).isTrue();
    }

    // As computers increase in power, and as we find new vulnerabilities, then researchers derive new versions of SHA.
    // Newer versions have a progressively longer length, or sometimes researchers publish a new version of the underlying algorithm.
    //
    //  SHA-512 represents the longest key in the third generation of the algorithm.
    //  While there are now more secure versions of SHA, SHA-512 is the strongest that is implemented in Java.
    @Test
    void shouldGenerateSha512hash() {
        System.out.println(DigestUtils.sha512Hex("SDA"));
    }

    // PBKDF2, BCrypt, and SCrypt

    // see more at https://www.baeldung.com/java-password-hashing
}
