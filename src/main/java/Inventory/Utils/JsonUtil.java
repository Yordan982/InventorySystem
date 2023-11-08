package Inventory.Utils;

import Inventory.ItemFactory;
import Inventory.Items.AbstractItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class JsonUtil {

    private Gson gson;
    private String writeItemsFile = "items.json";
    private ObjectMapper objectMapper;
    private ItemFactory itemFactory;


    public JsonUtil() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        objectMapper = new ObjectMapper();
        itemFactory = new ItemFactory();
    }


    public void write(AbstractItem[] abstractItem) throws IOException {

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(writeItemsFile), abstractItem);

    }

    public AbstractItem[] read (){

        AbstractItem[] items = new AbstractItem[]{};

        try (FileReader fileReader = new FileReader(writeItemsFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            items = objectMapper.readValue(bufferedReader, AbstractItem[].class);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    public void addJdItem(AbstractItem item) throws IOException {
        AbstractItem[] currentItems = read();
        AbstractItem[] newItems = new AbstractItem[currentItems.length+1];
        System.arraycopy(currentItems, 0, newItems, 0, currentItems.length);
        newItems[newItems.length-1] = item;
        write(newItems);
    }

    public void removeItem(int id) throws IOException {
        AbstractItem[] currentItems = read();
        AbstractItem[] newItems = Arrays.stream(currentItems).filter(x -> x.getId() != id).toArray(AbstractItem[]::new);
        write(newItems);
    }
}