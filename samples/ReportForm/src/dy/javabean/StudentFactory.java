package dy.javabean;

import java.util.ArrayList;
import java.util.Collection;


/**
 * 生成JavaBean的工厂类。
 * 在iReport的DataSource的配置中会用到。
 *
 * 
 *
 * Package&FileName: ds.javabean.StudentFactory
 */
public class StudentFactory {
    //~ Static fields/initializers *********************************************

    // 生成实体对象的个数
    private static final int RECORD_COUNT =50 ;

    //~ Methods ****************************************************************

    /**
     * 这个方法在iReport的DataResource配置时也会用到
     * 必须是静态方法 static
     *
     * @return
     */
    public static Collection<Student> createBeanCollection() {
        Collection<Student> beanCollection = new ArrayList<Student>();

        for (int i = 0; i < RECORD_COUNT; i++) {
            beanCollection.add(StudentUtil.createStudent(i + 1));
        }

        return beanCollection;
    }
    public static void main(String[] args) {
    	
    	StudentFactory.createBeanCollection();
	}
}
