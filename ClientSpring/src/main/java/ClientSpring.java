import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientSpring extends Thread{

    private static final String postURL = "http://localhost:8080/server/execute";


    public static void sendPost() throws IOException {
        URL url = new URL(postURL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        OutputStream outputStream = connection.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        outputStreamWriter.write("stam");
        outputStreamWriter.flush();
        outputStreamWriter.close();
        outputStream.close();

        connection.connect();

        int responseCode = connection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        String result;
        BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result2 = bis.read();
        while(result2 != -1) {
            buf.write((byte) result2);
            result2 = bis.read();
        }
        result = buf.toString();
        System.out.println(result);

    }



    public static void main(String [] args) throws IOException{
        for (int i = 0; i < 100; i++) {
            ClientSpring obj = new ClientSpring();
            Thread thread = new Thread(obj);
            thread.start();
        }
    }

    @Override
    public void run(){
        try {
            sendPost();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
