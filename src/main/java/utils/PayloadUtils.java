package utils;

public class PayloadUtils {
    public static String createUserBody(){
        return "{\n" +
                "\"name\": \"Ive\",\n" +
                "\"email\": \"ranf15155@gmail.com\",\n" +
                "\"gender\": \"male\",\n" +
                "\"status\": \"Active\"\n" +
                "}";
    }
}
