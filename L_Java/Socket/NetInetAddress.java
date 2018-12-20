import org.junit.Test;

import java.net.*;
import java.util.*;

/**
 * @author pp 2018-12-20
 *
 * 学习InetAddress类
 *
 * @see java.net.InetAddress
 * @see     java.net.InetAddress#getByAddress(byte[])
 * @see     java.net.InetAddress#getByAddress(java.lang.String, byte[])
 * @see     java.net.InetAddress#getAllByName(java.lang.String)
 * @see     java.net.InetAddress#getByName(java.lang.String)
 * @see     java.net.InetAddress#getLocalHost()
 *
 */
public class NetInetAddress {

    /**
     * 通过域名获取IP地址
     * @throws UnknownHostException
     */
    public void byAddressGetIPorAddress() throws UnknownHostException {
        // 通过名称
        InetAddress address = InetAddress.getByName("www.baidu.com");

        System.out.println(address.getHostName());  // www.baidu.com
        System.out.println(address.getHostAddress());   // 14.215.177.39
        System.out.println(Arrays.toString(address.getAddress()));  //[14, -41, -79, 39]
        System.out.println(address.getCanonicalHostName());
    }

    /**
     * 通过Ip地址获取域名
     * @throws UnknownHostException
     */
    public void byIpGetIPorAddress() throws UnknownHostException {
        // 通过地址
        InetAddress address = InetAddress.getByName("14.215.177.39");

        System.out.println(address.getHostName());  // www.baidu.com
        System.out.println(address.getHostAddress());   // 14.215.177.39
        System.out.println(Arrays.toString(address.getAddress()));  //[14, -41, -79, 39]
        System.out.println(address.getCanonicalHostName()); // 主机名
    }

    /**
     * 通过域名获取映射全部的Ip地址
     */
    public void getAllByName() throws UnknownHostException {
        InetAddress[] address = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress address1: address) {
            System.out.println(address1);
        }
    }

    /**
     * 获取本机IP地址
     * @throws UnknownHostException
     */
    @Test
    public void getLocalHost() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
    }

    /**
     * 这个方法不能保证这个主机一定存在，或者主机名正确地映射到IP地址
     * @throws UnknownHostException
     */
    public void getByAddress() throws UnknownHostException {
        byte[] address = {107, 23, (byte)216, (byte)196}; // 必须把超过127的显示转化为字节
        InetAddress lessWrong = InetAddress.getByAddress(address);
        InetAddress lessWrongWithname = InetAddress.getByAddress("www.baidu.com", address);
    }






}
