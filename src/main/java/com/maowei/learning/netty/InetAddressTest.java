package com.maowei.learning.netty;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest{
    private static final HostInfo hostInfo = new HostInfo();

    public static final class HostInfo {
        private final String HOST_NAME;
        private final String HOST_ADDRESS;

        /**
         * 防止从外界创建此对象。
         */
        private HostInfo() {
            System.out.println("开始获取IP地址信息");
            String hostName = "";
            String hostAddress = "";

            try {
                InetAddress localhost = InetAddress.getLocalHost();

                hostName = localhost.getHostName();
                hostAddress = localhost.getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

            HOST_NAME = hostName;
            HOST_ADDRESS = hostAddress;
        }

        public final String getName() {
            return HOST_NAME;
        }

        public final String getAddress() {
            return HOST_ADDRESS;
        }
    }

    public static final HostInfo getHostInfo(){
        return hostInfo;
    }
}



