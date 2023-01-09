package genshinCoords;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final File folder = new File("./src/genshinCoords/files");
        FileToRead fileRead = new FileToRead();
        fileRead.listFilesForFolder(folder);
    }
}

class Coords{
    List<String> list;
    String x, y, z, name;
    Coords(){
        this.list=new ArrayList<>();
    }
    void append(String coord){
        list.add(coord);
    }
    void setList(){
        x= list.get(0);
        y=list.get(1);
        z=list.get(2);
        name=list.get(3);
    }
    public void toDoFile() throws IOException {
        FileWriter fileWriter = new FileWriter("./src/out/"+name+".json", true);
        fileWriter.write("{\"description\":\""+name+"\",\"name\":\""+name+"\",\"" +
                "position\":["+x+","+y+","+z+"]}");
        fileWriter.close();
    }
}

class FileToRead {
    public void listFilesForFolder(final File folder) throws IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                Coords coords = new Coords();
                FileReader fileRead = new FileReader(fileEntry);
                BufferedReader bufferedReader = new BufferedReader(fileRead);
                bufferedReader.readLine();
                String line = bufferedReader.readLine();
                while (line!=null){
                    StringBuffer stringBuffer = new StringBuffer(line);
                    stringBuffer.delete(0, 2);
                    coords.append(String.valueOf(stringBuffer));
                    line = bufferedReader.readLine();
                }
                StringBuffer stringBuffer = new StringBuffer(fileEntry.getName());
                stringBuffer.delete(stringBuffer.length()-4, stringBuffer.length());
                coords.append(String.valueOf(stringBuffer));
                coords.setList();
                coords.toDoFile();
                bufferedReader.close();
                fileRead.close();
            }
        }
    }


}
