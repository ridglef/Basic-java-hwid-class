package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Hwid {
    private final Boolean username;
    private final Boolean osname;
    private final Boolean osarch;
    private final Boolean osversion;
    private final Boolean inetadress;
    private final Boolean userhome;



    public Hwid(Boolean username, Boolean osname, Boolean osarch, Boolean osversion, Boolean inetadress, Boolean userhome) {
        this.username = username;
        this.osname = osname;
        this.osarch = osarch;
        this.osversion = osversion;
        this.inetadress = inetadress;
        this.userhome = userhome;
    }

    private String inet(){
        try {
           return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public String hwid(){
        String part = "";
        if (username){part = part + System.getProperty("user.name");}
        if (osname){part = part + System.getProperty("os.name");}
        if (osarch){part = part + System.getProperty("os.arch");}
        if (osversion){part = part + System.getProperty("os.version");}
        if (inetadress){part = part + inet();}
        if (userhome){part = part + System.getProperty("user.home");}
        return part;
    }
}
