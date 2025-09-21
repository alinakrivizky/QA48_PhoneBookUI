package utils;

import org.testng.annotations.DataProvider;
import phonebook.models.Contact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact()  {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Oliver", "Kan", "1234567890", "kan@gm.com", "Rehovot", "QA"});
        list.add(new Object[]{"Oliver", "Kan", "12345678981", "kan1@gm.com", "Rehovot", "QA"});
        list.add(new Object[]{"Oliver", "Kan", "123456789111", "kan1@gm.com", "Rehovot", "QA"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactWithCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("src/test/resources/ContactList.csv")));
        String line =br.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1])
                    .setPhone(split[2]).setEmail(split[3]).setAddress(split[4])
                    .setDescription(split[5])});
            line = br.readLine();
        }
        return list.iterator();

    }

}
