package ru.eltex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String> pidName = new HashMap<>();

        File dir1 = new File("/proc");

        String[] stringTemp = dir1.list();
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(stringTemp));

        Iterator<String> stringIterator = stringArrayList.iterator();
        while (stringIterator.hasNext()) {
            String temp = stringIterator.next();

            if (!checkString(temp)) {
                stringIterator.remove();
            }
        }

//        for (String str : stringArrayList) {
//            System.out.println(str);
//        }

        for (String str : stringArrayList) {
            File dirTemp = new File("/proc/" + str + "/stat");

            try {
                FileReader fileReader = new FileReader(dirTemp);

                StringBuilder tempStr = new StringBuilder();
                int c;
                while ((c = fileReader.read()) != -1) {
                    if ((char) c == '(') {
                        while ((char) (c = fileReader.read()) != ')') {
                            tempStr.append((char) c);
                        }
                        pidName.put(str, tempStr.toString());
                        break;
                    }
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Map.Entry<String, String> elem : pidName.entrySet()) {
            System.out.println("PID: " + elem.getKey() + "    NAME: " + elem.getValue());
        }
    }

    public static boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
}
