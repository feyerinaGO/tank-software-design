package ru.mipt.bit.platformer.levels;
import com.badlogic.gdx.math.GridPoint2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

import static ru.mipt.bit.platformer.game_data.Constant.*;

public class FromFileLevel implements CreateLevel {
    private final ArrayList<ArrayList<String>> level;

    public FromFileLevel(String path) {
        level = new ArrayList<>();
        try {
            String filePath = new File("").getAbsolutePath();
            filePath += path;
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                ArrayList<String> letters = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    letters.add(line.substring(i,i+1));
                }
                level.add(letters);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashSet<GridPoint2> getObstaclesCoordinates() {
        HashSet<GridPoint2> obstacles = new HashSet<>();
        for (int i = 0; i < level.size(); i++) {
            for (int j = 0; j < level.get(i).size(); j++) {
                if (level.get(i).get(j).equals(TREE)) {
                    obstacles.add(new GridPoint2(j, WIN_HGT_TILES-i-1));
                }
            }
        }
        return obstacles;
    }

    @Override
    public HashSet<GridPoint2> getPlayersCoordinates() {
        HashSet<GridPoint2> players = new HashSet<>();
        for (int i = 0; i < level.size(); i++) {
            for (int j = 0; j < level.get(i).size(); j++) {
                if (level.get(i).get(j).equals(PLAYER)) {
                    players.add(new GridPoint2(j, WIN_HGT_TILES-i-1));
                }
            }
        }
        return players;
    }

    @Override
    public HashSet<GridPoint2> getEnemiesCoordinates() {
        HashSet<GridPoint2> enemies = new HashSet<>();
        for (int i = 0; i < level.size(); i++) {
            for (int j = 0; j < level.get(i).size(); j++) {
                if (level.get(i).get(j).equals(ENEMY)) {
                    enemies.add(new GridPoint2(j, WIN_HGT_TILES-i-1));
                }
            }
        }
        return enemies;
    }
}
