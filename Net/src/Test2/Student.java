package Test2;

public class Student
{
    private int id;
    private String name;
    private boolean sex;
    private String cellPhone;

    public Student()
    {
        super();
    }

    public Student(int id, String name, boolean sex, String cellPhone)
    {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.cellPhone = cellPhone;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isSex()
    {
        return sex;
    }

    public void setSex(boolean sex)
    {
        this.sex = sex;
    }

    public String getCellPhone()
    {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone)
    {
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString()
    {
        // TODO Auto-generated method stub
        return "学号:" + this.id + "\r\n" + "姓名：" + this.name + "\r\n性别:" + this.sex + "\r\n手机号码：" + this.cellPhone + "\r\n";
    }



}
