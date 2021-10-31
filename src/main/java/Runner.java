import engine.NetworkUtils;

import java.io.IOException;

public class Runner {


    public static void main(String[] args) {

        NetworkUtils networkUtils = new NetworkUtils();

        try {
            networkUtils.startLocalRESTAPI();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
