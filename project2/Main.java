import java.util.ArrayList;
import java.util.List;

// Define a class to represent a network packet
class NetworkPacket {
    private String sourceIP;
    private String destinationIP;
    private String protocol;
    private String payload;

    // Constructor
    public NetworkPacket(String sourceIP, String destinationIP, String protocol, String payload) {
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
        this.protocol = protocol;
        this.payload = payload;
    }

    // Getters
    public String getSourceIP() {
        return sourceIP;
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getPayload() {
        return payload;
    }
}

// Define a class for the Network Intrusion Detection System
class NIDS {
    private List<String> suspiciousPatterns;

    // Constructor
    public NIDS() {
        suspiciousPatterns = new ArrayList<>();
        // Add some example suspicious patterns (you can add more)
        suspiciousPatterns.add("SQL Injection");
        suspiciousPatterns.add("Cross-Site Scripting (XSS)");
        suspiciousPatterns.add("Buffer Overflow");
    }

    // Method to check if a packet contains any suspicious patterns
    public boolean isSuspicious(NetworkPacket packet) {
        String payload = packet.getPayload();
        for (String pattern : suspiciousPatterns) {
            if (payload.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a sample network packet with a suspicious payload.
        NetworkPacket packet = new NetworkPacket("192.168.1.100", "8.8.8.8", "TCP", "SELECT * FROM users; --SQL Injection detected--");

        // Create an instance of the NIDS
        NIDS nids = new NIDS();

        // Check if the packet is suspicious
        if (nids.isSuspicious(packet)) {
            System.out.println("Suspicious activity detected: " + packet.getPayload());
            // Add further actions here, such as logging or alerting
        } else {
            System.out.println("No suspicious activity detected.");
        }
    }
}