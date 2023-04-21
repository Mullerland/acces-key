package com.example.accesskeybackend.template.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

@RestController
public class Ipv6SupportController {
    @GetMapping("/check-ip")
    public String checkIp(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        boolean isIpv6Supported = isIpv6SupportedBySite(ipAddress);
        return "IPv6 support: " + (isIpv6Supported ? "yes" : "no");
    }

    private boolean isIpv6SupportedBySite(String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            if (inetAddress instanceof Inet6Address) {
                InetAddress ipv6Address = InetAddress.getByName("ipv6.google.com");
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ipv6Address, 80), 2000);
                socket.close();
                return true;
            }
        } catch (IOException e) {
            System.out.println("Failed to connect to the site using IPv6, so it doesn't support IPv6");
        }
        return false;
    }
}
