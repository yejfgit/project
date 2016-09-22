package dy.javabean;


/**
 *
 *
 
 * Package&FileName: ds.javabean.Student
 */
public class Student {
    //~ Instance fields ********************************************************

	// ���
    private int id;
    // ����
    private String name;
    // �Ա�
    private String gender;
    // ��������
    private String birthday;

    //~ Constructors ***********************************************************

    public Student() {
    }


    public Student(int id, String name, String gender, String birthday) {
        this.id           = id;
        this.name         = name;
        this.gender       = gender;
        this.birthday     = birthday;
    }

    //~ Methods ****************************************************************

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getBirthday() {
        return birthday;
    }


    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    
    
}
