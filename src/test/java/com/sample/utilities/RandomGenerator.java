package com.sample.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

        public static String empNameRandom() {
            String generatedString = RandomStringUtils.randomAlphabetic(1);
            return generatedString;

        }

        public static String empSalRandom() {
            String generatedString = RandomStringUtils.randomNumeric(2);
            return generatedString;
        }

        public static String empAgeRandom() {
            String generatedString = RandomStringUtils.randomNumeric(1);
            return generatedString;
        }


}
