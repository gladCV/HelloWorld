package org.liujin;


/**
 * @author shkstart
 * @date 2022-07-22 17:33
 */
public class NetWorkTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface NetWork {
    int i = 1;
    void browse();

}

class Server implements NetWork {
    @Override
    public void browse() {
        System.out.println("真实服务器访问网络");
    }
}

class ProxyServer implements NetWork {
    private NetWork work;
    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void check() {
        System.out.println("代理服务器网络检查");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}
