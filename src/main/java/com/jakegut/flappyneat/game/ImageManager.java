package com.jakegut.flappyneat.game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ImageManager {

    private final HashMap<String, Image> imagesMap;

    public ImageManager(){
        imagesMap = new HashMap<>();

        Image topPipe = new ImageIcon(getClass().getResource("/Pipe_Top.png")).getImage();
        Image bottomPipe = new ImageIcon(getClass().getResource("/Pipe_Bottom.png")).getImage();
        Image background = new ImageIcon(getClass().getResource("/Background.png")).getImage();
        Image bird = new ImageIcon(getClass().getResource("/Birds_01.png")).getImage();

        imagesMap.put("TopPipe", topPipe);
        imagesMap.put("BottomPipe", bottomPipe);
        imagesMap.put("Background", background);
        imagesMap.put("Bird", bird);
    }

    public Image getImage(String key){
        return imagesMap.get(key);
    }
}
