package alibaba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        // 读取文件
        String fileName = "D:\\CODE\\idea\\ExamTest\\src\\alibaba\\login.txt";
        File file = new File(fileName);
        BufferedReader reader = null;
        Map<String, Integer> lineTimes = new HashMap<>();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 选出包含Login的行，并去重，并记录行数
                if (tempString.contains("Login")) {
                    if (lineTimes.containsKey(tempString)) {
                        lineTimes.put(tempString, lineTimes.get(tempString) + 1);
                    } else {
                        lineTimes.put(tempString, 1);
                    }
                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {

                }
            }
        }

        // 对Map进行排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(lineTimes.entrySet());
        list.sort((o1, o2) -> {
            //按照value值，从大到小排序
            return o2.getValue() - o1.getValue();
        });

        //结果输出  出现次数： 日志内容
        for (Map.Entry s : list) {
            System.out.println(s.getValue() + ": " + s.getKey());
        }
    }
}
