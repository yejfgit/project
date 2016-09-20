package test.policy;
import java.util.List;
import java.util.ArrayList;

/**//*
 * 百度笔试题 Java求解
 * 
 * @Author: Red_angelX
 */
public class BaiduAns {
    
    /**//*
     * 蚂蚁位置
     */
    public int position;
    
    /**//*
     * 方向 true为向上,false为向下
     */
    private boolean direction=true;
    
    /**//*
     * 是否已经到达
     */
    public boolean IsArrive()
    {
    if(position < 0 || position > 27)
        return true;
    else
        return false;
    }
    
    /**//*
     * 改变方向
     */
    public void ChangeDirection()
    {
        if(IsArrive() == false)
        {
           this.direction = !this.direction;
        }
    }
    
    /**//*
     * 设置方向
     */
    public void SetDirection(boolean value)
    {
        this.direction = value; 
    }
    
    public void Move()
    {
        if(IsArrive() == false)
        {
        //往上走
        if(direction == true)
        {
            this.position ++;
        }
        else
        {
            this.position --;
        }
        }
    }    
    
    /**//*
     * 名字
     */
    public String AntName;
    
    /**//*
     * 构造函数
     */
    public BaiduAns(int pos,boolean dir,String name)
    {
      this.position = pos;
      this.direction = dir;
      this.AntName = name;
    }    
    
    
    public static void Print(Object msg)
    {
        System.out.println(msg);
    }

    /**//*
     * global 
     */
    static BaiduAns ant3 = new BaiduAns(3,true,"蚂蚁3");
    static BaiduAns ant7 = new BaiduAns(7,true,"蚂蚁7");
    static BaiduAns ant11= new BaiduAns(11,true,"蚂蚁11");
    static BaiduAns ant17 = new BaiduAns(17,true,"蚂蚁17");
    static BaiduAns ant23 = new BaiduAns(23,true,"蚂蚁23");
    
    public static void Reset()
    {
        ant3.position = 3;
        ant7.position = 7;
        ant11.position = 11;
        ant17.position = 17;
        ant23.position =23;
    }
    /** *//**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> times = new ArrayList<Integer>();
        //循环
        for(int i1=0;i1<2;i1++)
        {
            for(int i2=0;i2<2;i2++)
            {
                for(int i3=0;i3<2;i3++)
                {
                    for(int i4=0;i4<2;i4++)
                    {
                        for(int i5=0;i5<2;i5++)
                        {
                            int time = 0;
                            Reset();
                            //设置方向
                            ant3.direction = i1 == 0? true:false;
                            ant7.direction = i2 == 0? true:false;
                            ant11.direction = i3 == 0? true:false;
                            ant17.direction = i4 == 0? true:false;
                            ant23.direction = i5 == 0? true:false;
                            
                            while(!(ant3.IsArrive()&&ant7.IsArrive()&&ant11.IsArrive()&&ant17.IsArrive()&&ant23.IsArrive()))
                            {    
                                //先判断是否相遇
                                if(ant3.position == ant7.position )
                                {
                                    ant3.ChangeDirection();
                                    ant7.ChangeDirection();
                                }       
                                if(ant7.position == ant11.position)
                                {
                                    ant7.ChangeDirection();
                                    ant11.ChangeDirection();                                   
                                }
                                if(ant11.position == ant17.position)
                                {
                                    ant11.ChangeDirection();
                                    ant17.ChangeDirection();
                                }
                                if(ant17.position == ant23.position)
                                {
                                    ant17.ChangeDirection();
                                    ant23.ChangeDirection();
                                }
                                
                                ant3.Move();
                                ant7.Move();
                                ant11.Move();
                                ant17.Move();
                                ant23.Move();
                                time++;
                            }
                            times.add(time);
                            Print(time);
                        }
                    }
                }
            }        
        }// End For
        int min,max;
        min = max = times.get(0);
        for(int i=0;i<times.size();i++)
        {       
            if(min > times.get(i))
            {
                min = times.get(i);
            }
            if(max < times.get(i))
            {
                max = times.get(i);                
            }
        }
        Print("Max Time is: "+max);
        Print("Min Time is: "+min);
    }

}



