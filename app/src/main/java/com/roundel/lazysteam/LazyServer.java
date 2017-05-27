package com.roundel.lazysteam;

import android.graphics.drawable.Drawable;

import java.net.InetSocketAddress;
import java.util.Arrays;

/**
 * Created by Krzysiek on 16/05/2017.
 */

public class LazyServer
{
    private String host;
    private String name;
    private int port;
    private byte[] key;
    private boolean local;
    private Drawable icon;

    //TODO: Add a unique identifier

    //External server
    public LazyServer(String host, String name, int port, byte[] key)
    {
        this(host, name, port);
        this.key = key;
        this.local = false;
    }

    /**
     * Local server, used for setup
     *
     * @param host hostname or ip address used to connect
     * @param name name visible to the user
     * @param port port used for connection
     */
    public LazyServer(String host, String name, int port)
    {
        this.port = port;
        this.host = host;
        this.name = name;
        this.local = true;
        this.key = new byte[0];
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        LazyServer that = (LazyServer) o;

        if(port != that.port) return false;
        if(local != that.local) return false;
        if(host != null ? !host.equals(that.host) : that.host != null) return false;
        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(!Arrays.equals(key, that.key)) return false;
        return icon != null ? icon.equals(that.icon) : that.icon == null;

    }

    @Override
    public int hashCode()
    {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + port;
        result = 31 * result + Arrays.hashCode(key);
        result = 31 * result + (local ? 1 : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        return result;
    }

    public int getPort()
    {
        return port;
    }

    public String getHost()
    {
        return host;
    }

    public String getName()
    {
        return name;
    }

    public byte[] getKey()
    {
        return key;
    }

    public void setKey(byte[] key)
    {
        this.key = key;
        this.local = key == new byte[0];
    }

    public boolean isLocal()
    {
        return local;
    }

    public InetSocketAddress getInetSocketAddress()
    {
        return new InetSocketAddress(getHost(), getPort());
    }

    public Drawable getIcon()
    {
        return icon;
    }

    public void setIcon(Drawable icon)
    {
        this.icon = icon;
    }
}
