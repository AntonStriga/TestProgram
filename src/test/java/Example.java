import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Scanner;

public class Example {

    @Test
    public void firstTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(("https://www.google.com/"));
        HttpResponse httpResponse = httpClient.execute(httpGet);

        Scanner sc = new Scanner((httpResponse.getEntity().getContent()));

        System.out.println(httpResponse.getStatusLine());
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
        Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
    }
}
