package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RegisterData {
    public String firstName, lastName, day, month, year, email, company, password;

    public void UserData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/registerData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject person = (JSONObject) object;

            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            day = (String) person.get("day");
            month = (String) person.get("month");
            year = (String) person.get("year");
            email = (String) person.get("email");
            company = (String) person.get("company");
            password = (String) person.get("password");


        }
    }
}