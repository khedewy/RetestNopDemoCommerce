package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckoutData {
    public String country, city, addressOne, addressTow, zip, phone, fax;

    public void UserData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir") + "/src/test/java/data/checkoutData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray) {
            JSONObject person = (JSONObject) object;

            country = (String) person.get("country");
            city = (String) person.get("city");
            addressOne = (String) person.get("addressOne");
            addressTow = (String) person.get("addressTow");
            zip = (String) person.get("zip");
            phone = (String) person.get("phone");
            fax = (String) person.get("fax");
        }
    }
}
