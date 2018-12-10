package Game;
import File_format.*;
import java.util.ArrayList;
import GIS.*;
import java.util.Iterator;

public class Game {
	ArrayList<Fruit> fruit =new ArrayList();
	ArrayList<Packman> packman =new ArrayList();
	String path="game_1543684662657.csv";
	
public void buildAgame(String filePath) {
	ArrayList<ArrayList<String>> table  =new ArrayList<ArrayList<String>>();
	ArrayList<Types> types = new ArrayList<Types>();
	table=CsvReader.Csvreader(filePath);
	types=List2types.makeTypes(table);
	for(Types t : types) {
		if(t instanceof Fruit) {
			fruit.add((Fruit) t);
		}
		else if(t instanceof Packman) {
			packman.add((Packman) t);
		}
	}
}







public void makeAkml() {
	
}

}
