/**
 * 责任链模式
 */
package ChainOfResponsibility;

enum RequestType {
    TYPE1,
    TYPE2;
}

class Request {
    private RequestType requestType;
    private String name;

    public Request(RequestType requestType, String name) {
        this.requestType = requestType;
        this.name = name;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

abstract class Handler {
    protected Handler successor;

    Handler(Handler handler) {
        this.successor = handler;
    }

    public abstract void handleRequest(Request request);
}

class Handler1 extends Handler {

    Handler1(Handler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.TYPE1) {
            System.out.println(request.getName() + " handle by Handler1");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class Handler2 extends Handler {

    Handler2(Handler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.TYPE2) {
            System.out.println(request.getName() + " handle by Handler2");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Request request1 = new Request(RequestType.TYPE1, "request1");
        Request request2 = new Request(RequestType.TYPE2, "request2");

        Handler1 handler1 = new Handler1(null);
        Handler2 handler2 = new Handler2(handler1);

        handler2.handleRequest(request1);
        handler2.handleRequest(request2);
    }
}
