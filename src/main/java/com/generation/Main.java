package com.generation;

import com.generation.model.Album;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            URL url =new URL("https://jsonplaceholder.typicode.com/albums");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader =new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder builder =new StringBuilder();

            String readline = reader.readLine();

            while (readline!=null){
                builder.append(readline);
                readline=reader.readLine();
            }

            Gson gson = new Gson();

            List<Album> albums = gson.fromJson(builder.toString(), new TypeToken<List<Album>>() {
            });
            List<Album> albumsInRange = new ArrayList<>();

            System.out.print("Qaysi albomlani boshlangich nuqtasini kiriting: ");
            int startRange = new Scanner(System.in).nextInt();
            System.out.print("Qaysi albomlani tugallash nuqtasini kiriting: ");
            int endRange = new Scanner(System.in).nextInt();
            for (Album album : albums) {
                if(album.getId() < endRange && album.getId() > startRange){
                    System.out.println("Album id --- " + album.getId());
                    System.out.println("User id --- " + album.getUserId());
                    System.out.println("Title --- " + album.getTitle());
                    System.out.println();
                    albumsInRange.add(album);
                }
            }

            DocumentService documentService = new DocumentService();
            documentService.creatDocument(albumsInRange);


        }catch (IOException e){

        }
    }
}