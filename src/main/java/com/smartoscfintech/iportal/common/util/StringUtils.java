package com.smartoscfintech.iportal.common.util;

import com.smartoscfintech.iportal.entity.enums.DocumentGroup;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.Normalizer;
import java.util.Random;
import java.util.regex.Pattern;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class StringUtils {
    public static final String PERCENT ="%";

    public static final String ASCII_UPPERCASE  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String ASCII_LOWERCASE  = ASCII_UPPERCASE.toLowerCase();
    public static final String DIGITS  = "0123456789";
    public static final String SPECIAL_CHARACTER = "~!@#$^&()_-";

    public static String appendLike(String patent) {
        return PERCENT + patent + PERCENT;
    }

    public static String normalizeString(String str) {
        String normalize = Normalizer.normalize(str , Normalizer.Form.NFD);

        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String result = pattern.matcher(normalize).replaceAll("");
        result = result.replaceAll("[đ]", "d");
        result = result.replaceAll("[Đ]", "D");
        return result;
    }

    public static String buildPathMinio(DocumentGroup group) {
        return String.join("/", String.valueOf(group).toLowerCase());
    }


    public static String generateRandomString(int length, String asciiUpperCase, String asciiLowerCase, String digits, String specialCharacter) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Random rand = new Random();
        while (i < length) {
            sb.append(asciiUpperCase.charAt(rand.nextInt(asciiUpperCase.length())));
            sb.append(asciiLowerCase.charAt(rand.nextInt(asciiLowerCase.length())));
            sb.append(digits.charAt(rand.nextInt(digits.length())));
            sb.append(specialCharacter.charAt(rand.nextInt(specialCharacter.length())));
            i++;
        }
        return sb.toString();
    }
}
