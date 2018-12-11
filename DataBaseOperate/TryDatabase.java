public class TryDatabase{
    public static void main(String[] args){
        Authors w = new Authors();
        //显示全部数据
        w.disp("select * from authors");
        //显示序列号为3的数据
        //w.disp(3);
    }
}