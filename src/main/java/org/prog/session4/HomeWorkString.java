package org.prog.session4;

// TODO: print only correct emails
// Correct email rules:
// - at least 3 symbols before @
// - only one @ symbol
// - full domain name (must have at least one ".")

public class HomeWorkString {

    public static void main(String[] args) {

        String[] emails = new String[]{
                "abcdefg@gmail.com", // +
                "a@gmail.com",       // -
                "josh@@gmail.com",   // -
                "janegmail.com",     // -
                "pete@gmail.com",    // +
                "zoe@gmailcom",      // -
                "steve@outlook.com", // +
                "abcd@a.a",          // +
                "abcd.a@fakemail"    // -
        };

        for (int i = 0; i < emails.length; i++) {

            String email = emails[i];

            int firstAt = email.indexOf('@');
            int lastAt = email.lastIndexOf('@');

            // rule 2: only one '@'
            if (firstAt == -1 || firstAt != lastAt) {
                continue;
            }

            // rule 1: at least 3 symbols before '@'
            if (firstAt < 3) {
                continue;
            }

            // rule 3: domain must contain '.'
            String domain = email.substring(firstAt + 1);
            if (!domain.contains(".")) {
                continue;
            }

            System.out.println(email);
        }
    }
}


