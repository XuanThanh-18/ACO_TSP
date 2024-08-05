package src.main;

import src.main.Input.City;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUntill {
    public static double[][] readCityFromFile(){
        String filepath="src/main/Input/tsp_48_Cities";
        File file = new File(filepath);
        if(!file.exists()){
            System.out.println("File not exit: " + String.valueOf(file.getAbsoluteFile()));
        }
        try{
            Scanner sc = new Scanner(file);
            ArrayList<City> cities = new ArrayList<>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String arrLine[] = line.split(" ");
                int name =Integer.parseInt(arrLine[0]);
                double x = Double.parseDouble(arrLine[1]);
                double y = Double.parseDouble(arrLine[2]);
                cities.add(new City(name,x,y));
            }
            double[][] graph= new double[cities.size()][cities.size()];
            for(int i=0;i<cities.size();i++){
                for(int j=0;j<cities.size();j++){
                    if(i==j){
                        graph[i][j]=0;
                    }else{
                        graph[i][j] = cities.get(i).distanceBetweenTwoCities(cities.get(j));
                    }
                }
            }
            return graph;
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public static void readParamsFromFile(){
        String filepath = "src/main/Input/params";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            while((line = br.readLine())!=null){
                String[] arrParam = line.split(" ");
                switch (arrParam[0].trim()){
                    case "tr":
                        AntColonyOptimization.c=Double.parseDouble(arrParam[1].trim());
                        break;
                    case "alpha":
                        AntColonyOptimization.alpha=Double.parseDouble(arrParam[1].trim());
                        break;
                    case "beta":
                        AntColonyOptimization.beta=Double.parseDouble(arrParam[1].trim());
                        break;
                    case "evaporation":
                        AntColonyOptimization.evaporation=Double.parseDouble(arrParam[1].trim());
                        break;
                    case "Q":
                        AntColonyOptimization.Q=Double.parseDouble(arrParam[1].trim());
                        break;
                    case "antFactor":
                        AntColonyOptimization.antFactor=Double.parseDouble(arrParam[1].trim());
                        break;
                    case "randomFactor":
                        AntColonyOptimization.randomFactor=Double.parseDouble(arrParam[1].trim());
                        break;
                    case "iterations":
                        AntColonyOptimization.maxIterations=Integer.parseInt(arrParam[1].trim());
                        break;
                    case "numberOfAnts":
                        AntColonyOptimization.numberOfCities=Integer.parseInt(arrParam[1].trim());
                        break;
                }
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void clearFile(String filePath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.close();
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static void writeFile(String filePath, String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));

            try {
                bw.write(content);
                bw.newLine();
            } catch (Throwable var6) {
                try {
                    bw.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            bw.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
}
