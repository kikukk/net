package Test2;


public class Chess
{
    private int x;
    private int y;

    public Chess()
    {
        super();
    }

    public Chess(int _x,int _y)
    {
        super();
        this.x = _x;
        this.y = _y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int _x)
    {
        this.x = _x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int _y)
    {
        this.y = _y;
    }
    @Override
    public String toString()
    {
        // TODO Auto-generated method stub
        return "X:" + getX() + "\r\n" + "Y：" + getY();
    }

}
