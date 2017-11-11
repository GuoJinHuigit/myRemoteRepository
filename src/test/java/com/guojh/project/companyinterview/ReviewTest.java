package com.guojh.project.companyinterview;

import com.guojh.project.entity.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created by Administrator on 2017/11/8.
 */
public class ReviewTest {

    @Test
    public void testAlpha() {

        boolean flag = true;
        int i = 0;
        do {
            System.out.print(i++);
            flag = i < 10;
            continue;
        } while (flag);
    }

}

class TestJava {
    private static String str2 = null;

    public static void changeStr(String str) {
        str = "welcome";
    }

    public static void main(String[] args) {

        String str = "1234";
        str2 = "5678";
        changeStr(str);
        changeStr(str2);
        System.out.println(str);
        System.out.println(str2);
    }
}

class TestFoo {

    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }
    }

    public void test() {
        User user = new User();
        String userSalt = user.getUserSalt();
        String substring = userSalt.substring(1, 3);
        String userPassword = user.getUserPassword();

    }


}
