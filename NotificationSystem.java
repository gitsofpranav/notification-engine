import java.util.*;

interface INotification{
   String getContent();
}

class SimpleNotification implements INotification{
    private String text;

    public SimpleNotification(String msg){
        this.text = msg;
    }

    public String getContent(){
        return text;
    }
}

abstract class INotificationDecorator implements INotification {
    protected INotification notification;

    public INotificationDecorator(INotification n){
        this.notification = n;
    }
}

class TimestampDecorator extends INotificationDecorator {
    public TimestampDecorator(INotification n) {
        super(n);
    }

    public String getContent() {
        return "[2025-04-13 14:22:00] " + notification.getContent();
    }
}

class SignatureDecorator extends INotificationDecorator {
    private String signature;

    public SignatureDecorator(INotification n, String sig) {
        super(n);
        this.signature = sig;
    }

    public String getContent() {
        return notification.getContent() + "\n-- " + signature + "\n\n";
    }
}



interface IObserver {
    void update();
}

interface IObservable {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}


public class NotificationSystem  {
    public static void main(String[] args) {
        
    }
}
