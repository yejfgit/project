package dy.javabean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Random;


/**
 * �������Studentʵ�����Ĺ�����
 *
 *
 * Package&FileName: ds.javabean.StudentUtil
 */
public class StudentUtil {
    //~ Static fields/initializers *********************************************

    /*
     * ���ա����ַ�����
     */
    private static String[] FIRST_NAME_ARR = {
            "��",
            "Ǯ",
            "��",
            "��",
            "��",
            "��",
            "Ľ��",
            "�Ϲ�",
            "����",
            "��"
        };

    /*
     * ������������
     */
    private static String[] LAST_NAME_ARR  = {
            "��",
            "��",
            "��",
            "��",
            "����",
            "С��",
            "С��",
            "��",
            "����",
            "��",
            "ӯӯ",
            "��"
        };

    /*
     * �Ա�
     */
    private static String[] GENDER_ARR     = {
            "��",
            "Ů"
        };
    private static DateFormat DATE_FORMATER = new SimpleDateFormat(
            "yyyy��MM��dd��");

    //~ Methods ****************************************************************

    public static Student createStudent(int id) {
        String firstName = getRandomCharFromArray(FIRST_NAME_ARR);
        String lastName  = getRandomCharFromArray(LAST_NAME_ARR);
        String name      = firstName + lastName;

        String gender = GENDER_ARR[new Random().nextInt(1000) % 2];

        String birthday = getRandomDate();

        return new Student(id, name, gender, birthday);
    }


    private static String getRandomCharFromArray(String[] arr) {
        Random random = new Random();
        int    index  = random.nextInt(arr.length);

        return arr[index];
    }

    /**
     * �������һ���ȵ�ǰ����С������
     * 
     * @return ��yyyy��MM��dd�գ�
     */
    private static String getRandomDate() {
        Date date     = new Date();
        long dateMill = date.getTime();

        Random random = new Random();
        dateMill = (long) (random.nextDouble() * dateMill);

        return DATE_FORMATER.format(new Date(dateMill));
    }
}
