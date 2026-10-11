import java.util.HashMap;

class Student{
    String name;
    String rollNumber;
    HashMap<String,Integer> marks = new HashMap<>();

    public Student(String name,String rollNumber,String subjects[],int[] marks){
        this.name=name;
        this.rollNumber=rollNumber;
        
        for(int i=0;i<marks.length;i++){
            this.marks.put(subjects[i],marks[i]);
        }
    }    
}

class DataBase{
    
    String url;
    String key;

    public DataBase(String url,String key){
        this.url=url;
        this.key=key;
    }

    public static Student getData(String rollNumber){return null;}

    public static void saveData(Student student){}

}


class Validation{

    DataBase db;

    public static boolean validate(Student student){
        HashMap<String,Integer> marks = student.marks;
        for(String x:student.marks.keySet()){
            int mark = marks.get(x);
            if(mark<0 || mark>100)return false;
        }

        return true;
    }

}


class Result{

    public static double totalCredit(Student student){
        double credit=0;
        HashMap<String,Integer> marks = student.marks;

        for(String x:student.marks.keySet()){
            credit+=marks.get(x);
        }
        credit = (credit/300)*100;
        return credit;
    }

}

class Report{

    public static void genrateResult(Student student){
        if(!Validation.validate(student))return;

        double credit = Result.totalCredit(student);
        
        DataBase.saveData(student);

        System.out.println("report");

    }
}