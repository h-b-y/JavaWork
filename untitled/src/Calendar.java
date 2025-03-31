import java.util.Scanner;
public class Calendar {
    public static void main(String[] args) {
        /**
         知识点：方法版本的日历
         需求：输入年月，打印当月的日历
         线索：1900、1、1是星期一
         */
        //1、输入年月
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年：");
        int year = scan.nextInt();
        System.out.println("请输入月：");
        int mouth = scan.nextInt();

        //计算总天数
        int allDay=getAllDay(year,mouth);
        System.out.println(allDay);
        //4、计算星期
        int week=getWeek(allDay);
        System.out.println(week);
        //计算当月天数
        int day=getDay(year,mouth);
        System.out.println(day);
        //5、打印日历
        printCalendar(year,mouth,day,week);

    }
    //打印日历
    public static void printCalendar(int year,int month,int day,int week){
        //打印日历头部信息
        System.out.println(year+"年"+month+"月"+day+"日");
        System.out.println("一\t二\t三\t四\t五\t六\t日\t");
        int count =0;   //一周七天换行
        //打印空格
        for(int i=0;i<week;i++){
            System.out.print("\t");
            count++;
        }
        //打印日期
        for(int i=1;i<=day;i++){
            System.out.print(i+"\t");
            count++;
            if (count%7==0)
                System.out.println();
        }

    }
    //获取当月的天数
    public static int getDay(int year,int month) {
        int day = 0;
        switch (month) {
            case 1:case 3: case 5: case 7: case 8: case 10: case 12:
                 day = 31;
                 break;
            case 4: case 6: case 9: case 11:
                day = 30;
                break;
            case 2:
                if (isLeapYear(year)) {
                  day = 29;
                } else {
                    day = 28;
                }
            break;
        }
        return day;
    }
    //计算输入年到结束年的总天数
    public static int getAlldayOfYear(int startyear,int endyear){
        int allDayOfYear=0;
        for (int i = startyear; i < endyear; i++) {
            if(isLeapYear(i)){
                allDayOfYear+=366;
            }else {
                allDayOfYear+=365;
            }
        }
        return allDayOfYear;
    }
    //计算输入月到结束月的总天数
    public static int getAllDayOfMonth(int year,int startMonth,int endMonth){
        int allDayOfMonth=0;
        for(int i=startMonth;i<endMonth;i++){
            allDayOfMonth+=getDay(year,i);
        }
        return allDayOfMonth;
    }
    //计算总天数
    public static int getAllDay(int year,int month){
        int allDay=0;
        allDay=getAlldayOfYear(1900,year)+getAllDayOfMonth(year,1,month)+1;
        return allDay;
    }
    //计算当月第一天是星期几（总天数%7）
    public static int getWeek(int allDay){

        int week=allDay%7;
        if (week==0){
            week=7;
        }
        return week;
    }
    //判断是否闰年
    public static boolean isLeapYear(int year) {
        if(year%4 == 0 && year % 100!=0 || year%400==0 ){
            return true;
        }
        return false;
    }
}


