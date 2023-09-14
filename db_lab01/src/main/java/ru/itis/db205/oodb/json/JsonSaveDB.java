package ru.itis.db205.oodb.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import ru.itis.db205.oodb.model.Transaction;
import java.util.List;

public class JsonSaveDB {

    public static void saveData(List<Transaction> transactions) throws IOException {

        if (transactions != null && transactions.size() > 0) {

            ObjectMapper mapper = new ObjectMapper();

            String tr = mapper.writeValueAsString(transactions);


            try (OutputStream os = new FileOutputStream(new File("transactions.json"))) {
                os.write(tr.getBytes("UTF-8"));
                os.flush();
            }

        }
    }
}
