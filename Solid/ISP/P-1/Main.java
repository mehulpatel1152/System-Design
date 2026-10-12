
import java.util.*;

// ========== CAPABILITY INTERFACES ==========

interface NotificationProvider {
    String send(String message);
}

interface Schedule {
    void set(String message, long timestamp);
}

interface Cancel {
    void kill(String notificationId);
}

interface TrackDelivery {
    void track(String notificationId);
}

interface DeliveryReport {
    void report(String notificationId);
}

// ========== PROVIDERS ==========

class Email implements NotificationProvider, Schedule, Cancel, DeliveryReport {

    @Override
    public String send(String message) {
        String id = "EMAIL-101";
        System.out.println("Email sent: " + message);
        return id;
    }

    @Override
    public void set(String message, long timestamp) {
        System.out.println(
            "Email scheduled: " + message + " at " + timestamp
        );
    }

    @Override
    public void kill(String notificationId) {
        System.out.println("Email cancelled: " + notificationId);
    }

    @Override
    public void report(String notificationId) {
        System.out.println("Email delivery report: " + notificationId);
    }
}

class SMS implements NotificationProvider, TrackDelivery {

    @Override
    public String send(String message) {
        String id = "SMS-201";
        System.out.println("SMS sent: " + message);
        return id;
    }

    @Override
    public void track(String notificationId) {
        System.out.println("Tracking SMS delivery: " + notificationId);
    }
}

class WhatsApp implements NotificationProvider, DeliveryReport {

    @Override
    public String send(String message) {
        String id = "WHATSAPP-301";
        System.out.println("WhatsApp message sent: " + message);
        return id;
    }

    @Override
    public void report(String notificationId) {
        System.out.println(
            "WhatsApp delivery report: " + notificationId
        );
    }
}

class Push implements NotificationProvider, Cancel {

    @Override
    public String send(String message) {
        String id = "PUSH-401";
        System.out.println("Push notification sent: " + message);
        return id;
    }

    @Override
    public void kill(String notificationId) {
        System.out.println("Push notification cancelled: " + notificationId);
    }
}

// ========== SENDING SERVICE ==========

class NotificationService {

    private final Map<String, NotificationProvider> providers;

    public NotificationService(
            Map<String, NotificationProvider> providers) {
        this.providers = Map.copyOf(providers);
    }

    public String send(String type, String message) {
        NotificationProvider provider = providers.get(type);

        if (provider == null) {
            throw new IllegalArgumentException(
                "Unknown notification provider: " + type
            );
        }

        return provider.send(message);
    }
}

// ========== SCHEDULING SERVICE ==========

class NotificationSchedulingService {

    private final Map<String, Schedule> schedulers;

    public NotificationSchedulingService(
            Map<String, Schedule> schedulers) {
        this.schedulers = Map.copyOf(schedulers);
    }

    public void schedule(
            String type, String message, long timestamp) {
        Schedule scheduler = schedulers.get(type);

        if (scheduler == null) {
            throw new UnsupportedOperationException(
                "Scheduling is not supported by " + type
            );
        }

        scheduler.set(message, timestamp);
    }
}

// ========== CANCELLATION SERVICE ==========

class NotificationCancellationService {

    private final Map<String, Cancel> cancellers;

    public NotificationCancellationService(
            Map<String, Cancel> cancellers) {
        this.cancellers = Map.copyOf(cancellers);
    }

    public void cancel(String type, String notificationId) {
        Cancel canceller = cancellers.get(type);

        if (canceller == null) {
            throw new UnsupportedOperationException(
                "Cancellation is not supported by " + type
            );
        }

        canceller.kill(notificationId);
    }
}

// ========== DELIVERY TRACKING SERVICE ==========

class NotificationTrackingService {

    private final Map<String, TrackDelivery> trackers;

    public NotificationTrackingService(
            Map<String, TrackDelivery> trackers) {
        this.trackers = Map.copyOf(trackers);
    }

    public void track(String type, String notificationId) {
        TrackDelivery tracker = trackers.get(type);

        if (tracker == null) {
            throw new UnsupportedOperationException(
                "Delivery tracking is not supported by " + type
            );
        }

        tracker.track(notificationId);
    }
}

// ========== DELIVERY REPORT SERVICE ==========

class NotificationReportService {

    private final Map<String, DeliveryReport> reporters;

    public NotificationReportService(
            Map<String, DeliveryReport> reporters) {
        this.reporters = Map.copyOf(reporters);
    }

    public void report(String type, String notificationId) {
        DeliveryReport reporter = reporters.get(type);

        if (reporter == null) {
            throw new UnsupportedOperationException(
                "Delivery reports are not supported by " + type
            );
        }

        reporter.report(notificationId);
    }
}

// ========== APPLICATION ENTRY POINT ==========

public class Main {

    public static void main(String[] args) {

        // Create provider objects
        Email email = new Email();
        SMS sms = new SMS();
        WhatsApp whatsapp = new WhatsApp();
        Push push = new Push();

        // Register providers by supported capabilities
        NotificationService sender = new NotificationService(
            Map.of(
                "email", email,
                "sms", sms,
                "whatsapp", whatsapp,
                "push", push
            )
        );

        NotificationSchedulingService scheduler =
            new NotificationSchedulingService(
                Map.of("email", email)
            );

        NotificationCancellationService canceller =
            new NotificationCancellationService(
                Map.of(
                    "email", email,
                    "push", push
                )
            );

        NotificationTrackingService tracker =
            new NotificationTrackingService(
                Map.of("sms", sms)
            );

        NotificationReportService reporter =
            new NotificationReportService(
                Map.of(
                    "email", email,
                    "whatsapp", whatsapp
                )
            );

        // Send notifications
        String emailId = sender.send("email", "Welcome!");
        String smsId = sender.send("sms", "Your OTP is 123456");
        String whatsappId = sender.send("whatsapp", "Hello!");
        String pushId = sender.send("push", "New update available");

        System.out.println("\n--- Scheduling ---");
        scheduler.schedule(
            "email", "Meeting reminder", 1800000000000L
        );

        System.out.println("\n--- Cancellation ---");
        canceller.cancel("push", pushId);

        System.out.println("\n--- Delivery Tracking ---");
        tracker.track("sms", smsId);

        System.out.println("\n--- Delivery Reports ---");
        reporter.report("email", emailId);
        reporter.report("whatsapp", whatsappId);
    }
}
