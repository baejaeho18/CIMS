package com.example.demo.common;

import static com.example.demo.Constants.constants.EMPTY;
import static com.example.demo.Constants.constants.FILE_DELETE_STRING;
import static com.example.demo.Constants.constants.FILE_DELETE_STRING_FAIL;
import static com.example.demo.Constants.constants.HLS_LIST_SIZE_VALUE_MAX;
import static com.example.demo.Constants.constants.ONLY_NUMBER;
import static com.example.demo.Constants.constants.SPILT_COMMA;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtils {
    public final static String FILETYPE = ".mp4";
    private final static Comparator comparator = new Comparator<File>() {
        @Override
        public int compare(File file1, File file2) {
            // 파일 이름에서 숫자 부분을 추출하여 정수로 변환하여 비교
            int number1 = extractNumber(file1.getName());
            int number2 = extractNumber(file2.getName());
            return number1 - number2;
        }

        private int extractNumber(String fileName) {
            // 파일 이름에서 숫자 부분 추출
            String[] parts = SPILT_COMMA.split(fileName);
            // 숫자로 변환
            String numberStr = parts[0].replaceAll(ONLY_NUMBER.pattern(), EMPTY);
            if (!numberStr.isEmpty()) {
                return Integer.parseInt(numberStr);
            }
            return -1;
        }
    };

    public static File createDirectoryIfNotExists(String piName, String hlsOutputPath) {
        try {
            System.out.println(hlsOutputPath);
            File output = new File(hlsOutputPath + piName);
            System.out.println(output.getAbsolutePath());
            if (!output.exists()) {
                output.mkdirs();
            }

            return output;
        } catch (Exception e) {
            System.err.println("Error creating directory: " + e.getMessage());
            return null;
        }

    }

//    public static boolean writeMsgToFile(byte[] content, File filePath, int index) {
//
//        try (BufferedOutputStream bos = new BufferedOutputStream(
//                new FileOutputStream(filePath.getAbsoluteFile() + MIDDLE + index + FILETYPE, false))) {
//            bos.write(content);
//            return true;
//        } catch (IOException e) {
//            System.err.println("Error writing content to file: " + e.getMessage());
//            return false;
//        }
//    }

    public static File writeBufferToTempFile(byte[] buffer) {
        try {
            File tempFile = File.createTempFile("temp", FILETYPE);
            tempFile.deleteOnExit(); // 프로그램 종료 후 임시 파일 삭제

            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tempFile, false))) {
                bos.write(buffer);
            }

            return tempFile;
        } catch (IOException e) {
            System.err.println("Error writing content to temparary file: " + e.getMessage());
//            log.error("Error writing buffer to temp file: {}", e.getMessage());
            return null;
        }
    }

    public static void cleanupFiles(File directory) {
        File[] files = directory.listFiles();   // 디렉토리에서 파일 목록을 가져옴

        if (files == null || files.length < HLS_LIST_SIZE_VALUE_MAX) {   // 파일 목록이 없거나 10개 미만인 경우 종료
            return;
        }

        Arrays.sort(files, comparator);        // 파일을 사전순으로 정렬

        if (files[1].delete()) {   // .ts 첫 번째 파일 삭제
            System.out.println(files[1].getName() + FILE_DELETE_STRING);
        } else {
            System.out.println(FILE_DELETE_STRING_FAIL);
        }
    }

    public static void deleteDirectory(File directory) {
        try {
//            System.out.println("delete: " + directory.getAbsolutePath());
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete(); // 파일을 삭제합니다.
                }
            }
            directory.delete(); // 빈 디렉토리를 삭제합니다.
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
