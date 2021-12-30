package com.smartoscfintech.iportal.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConverterUtils {
    public static byte[] readBytesFromInputStream(InputStream inputStream, int length) {
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] data = new byte[length];
            int read;
            while ((read = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, read);
            }
            return buffer.toByteArray();
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
