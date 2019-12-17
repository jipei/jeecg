package test;

import org.jeecg.common.util.DateUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class demo {
    public static void main(String[] args) {
        String s ="aa,bb,cc,dd,ee";
        /*System.out.println(s);
        String[] y ={"a","b","c","d"};
        String[] bs = s.split(",");
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < bs.length; i++) {
            System.out.println(i+"=>"+bs[i]);

            map.put(i,bs[i]);
        }
        String substring = s.substring(2);
        System.out.println(map);*/
        //checkQQ2("10902");
        String format = DateUtils.date_sdf.format(new Date());
        System.out.println(System.currentTimeMillis());
        String s1 = DateUtils.formatDate(System.currentTimeMillis());
        System.out.println("时间："+s1);


    }
    public static void checkQQ2(String qq) {
        String reg = "[1-9][0-9]{4,14}";
        System.out.println(qq.matches(reg)?"合法qq":"非法qq");
        ArrayList<Object> arrayList = new ArrayList<>();
        boolean b = Collections.addAll(arrayList);

    }


}
