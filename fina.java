/you need to have an active internet connection

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
public class fina 
{
    public static void cokidisplay(String websiteUrl) throws IOException
        {
            
        URL url = new URL(websiteUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // send the request and get the response
        int responseCode = connection.getResponseCode();

        // retrieve the cookies from the response
        Map<String, List<String>> headers = connection.getHeaderFields();
        List<String> cookieList = headers.get("Set-Cookie");

        if (cookieList != null) 
        {
            // print out the cookie values
            System.out.println("Cookies received:");
            for (String cookie : cookieList) {
                System.out.println(cookie);
            }
        } else {
            System.out.println("No cookies received.");
        }
        // close the connection
        connection.disconnect();
    
            
        }
    public static void main(String[] args) throws IOException 
    {
           
        
        // replace this with the URL of the website you want to get cookies from
        String[] hotlist=new String[]{"https://www.google.com","https://www.youtube.com","https://www.facebook.com",
        "https://www.netflix.com","https://www.flipkart.com"};
        Scanner sc=new Scanner(System.in);
        
        System.out.println("hotlist with cookie:");
        for(int i=0;i<5;i++)
        {
            System.out.println((i+1)+".)"+hotlist[i]);
            cokidisplay(hotlist[i]);
        }
        System.out.println("Enter the website name(to checked agains hotlist): ");
        String xyz=sc.nextLine();
        cokidisplay(xyz);
        URL url = new URL(xyz);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        List<String> Hotlist = Arrays.asList("https://www.google.com","https://www.youtube.com","https://www.facebook.com",
        "https://www.netflix.com","https://www.flipkart.com");
        if (Hotlist.contains(url.toString())) 
        {
            JOptionPane.showMessageDialog(null, "ALERT: Website is on hotlist!");
        }
        else
        JOptionPane.showMessageDialog(null, "Website not on hotlist!");
    }
}