package ru.itis.db205.oodb.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import ru.itis.db205.oodb.model.Bank;

import java.io.File;


public class Lab3XMLService {

    /**
     * метод saveBankData сохраняет объект типа Bank в XML документ
     */
    public static void saveBankData(Bank bank) {

        try {
            JAXBContext context = JAXBContext.newInstance(Bank.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(bank, new File("bank.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод loadBankFromXML преобразует XML документ в объект типа Bank
     */
    public static Bank loadBankFromXML() {

        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Bank) un.unmarshal(new File("bank.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
