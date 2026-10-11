
class NotificationService{

    private Notification notification;

    public NotificationService(Notification notification){
        this.notification = notification;
    }

    public void send(){
        notification.sendNotification();
    }
}


interface Notification{
    
     void sendNotification();

} 


class email implements Notification{


    @Override 
    public void sendNotification(){

    }

}


class sms implements Notification{


    @Override 
    public void sendNotification(){

    }

}