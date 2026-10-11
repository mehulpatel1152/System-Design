class User{
    String name;
    String email;
    String password;

    public User(String name,String email,String password){
        this.name=name;
        this.password=password;
        this.email=email;
    }
}




class validation{

    DataBase db = new DataBase();

    public validation(){}

    boolean chk(User user){

        if(db.getData(user.email)==user.password){

            // logic
            return true;
        }

        return false;
    }

}


class DataBase{

    public DataBase(){}

    void saveData(User user){}

    String getData(String email){return "";}
}