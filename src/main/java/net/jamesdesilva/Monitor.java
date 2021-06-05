package net.jamesdesilva;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.InetAddress;

public class Monitor {

    private final Log log = LogFactory.getLog(Monitor.class);

    private String ipAddress;
    private String urlAddress;
    private int filename;

    public Monitor(String ipAddress, String urlAddress, int filename) {
        this.ipAddress = ipAddress;
        this.urlAddress = urlAddress;
        this.filename = filename;
    }

    public void run() throws Exception {

        log.info(String.format("Monitoring IP Address [%s] and URL [%s]", ipAddress, urlAddress));
        while(true) {
            InetAddress inet = InetAddress.getByName(ipAddress);
            InetAddress url = InetAddress.getByName(urlAddress);
            boolean ipAddressReachable = inet.isReachable(5000);
            boolean urlAddressReachable = inet.isReachable(5000);
            log.info(String.format("Ip %s reached [%s]",ipAddress, ipAddressReachable));
            log.info(String.format("Url %s reached [%s]", urlAddress, urlAddressReachable));
            Thread.sleep(5000);
        }
    }

    public static void main(String[] args) throws Exception {
        Monitor monitor = new Monitor("142.250.138.105", "www.google.com", 5000);
        monitor.run();

    }

}
