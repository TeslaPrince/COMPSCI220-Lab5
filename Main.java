import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
class Main {
  private static final int NUMBER_OF_RELEASES = 43;
  private static final String PATH = "Discography.csv";
  private static final String[] ALBUM_NAMES = new String[NUMBER_OF_RELEASES];
  private static final int[] NUMBER_OF_TRACKS = new int[NUMBER_OF_RELEASES];
  private static final int[] RELEASE_YEAR = new int[NUMBER_OF_RELEASES];
  public static void main(String[] args){
    System.out.println("The Database of Electric Light Orchestra Discography");
    Scanner sc = new Scanner(System.in);
    int choice = 1;
    int year = 1971;
    try{
      readDiscography();
    }
    catch(Exception e){
    }
    System.out.println("Select One:\n1. Print Full Discography\n2. Print From a Year\n3. Print From Before a Year\n4. Print From After a Year\n5. Print Highest Track Count");
      choice = sc.nextInt();
      switch(choice){
        case 1:
        printDiscography();
        break;
        case 2:
        System.out.print("Enter a year: ");
        year = sc.nextInt();
        printFromYear(year);
        break;
        case 3:
        System.out.print("Enter a year: ");
        year = sc.nextInt();
        printFromBeforeYear(year);
        break;
        case 4:
        System.out.print("Enter a year: ");
        year = sc.nextInt();
        printFromAfterYear(year);
        break;
        case 5:
        printHighestTrack();
        break;
        default:
        printDiscography();
        break;
      }
  }
  private static void readDiscography() throws Exception{
    System.out.println("Facing the music...\n" + "Marking the Time...\n" + "Balancing the Power...");
    BufferedReader reader = new BufferedReader(new FileReader(PATH));
    reader.readLine();
    for(int i = 0; i < NUMBER_OF_RELEASES; i++){
      String line = reader.readLine();
      if(line == null){
        reader.close();
        return;
      }
      else{
        String[] columns = line.split(",");
        ALBUM_NAMES[i] = columns[0];
        NUMBER_OF_TRACKS[i] = Integer.parseInt(columns[1]);
        RELEASE_YEAR[i] = Integer.parseInt(columns[2]);
      }
    }
    reader.close();
  }
  private static void printDiscography(){
    System.out.println("Print Full Discography\n-----------------------");
    for(int i = 0; i < NUMBER_OF_RELEASES; i++){
      System.out.printf("\t%s (%d) with %d tracks\n", ALBUM_NAMES[i], RELEASE_YEAR[i], NUMBER_OF_TRACKS[i]);
    }
  }
  private static void printFromYear(int year){
    System.out.printf("Albums from the year %d\n-------------------------\n", year);
    for(int i = 0; i < NUMBER_OF_RELEASES; i++){
      if (RELEASE_YEAR[i] == year){
        System.out.printf("\t%s (%d) with %d tracks\n", ALBUM_NAMES[i], RELEASE_YEAR[i], NUMBER_OF_TRACKS[i]);
      }
    }
  }
  private static void printHighestTrack(){
    System.out.println("Which album has the most tracks?\n--------------------------------");
    int highIndex = 0;
    for(int i = 0; i < NUMBER_OF_RELEASES; i++){
      if(NUMBER_OF_TRACKS[i] > NUMBER_OF_TRACKS[highIndex]){
        highIndex = i;
      }
    }
    System.out.printf("\t%s (%d) with %d tracks\n", ALBUM_NAMES[highIndex], RELEASE_YEAR[highIndex], NUMBER_OF_TRACKS[highIndex]);
  }
  private static void printFromBeforeYear(int year){
    System.out.printf("Albums from before the year %d\n--------------------------------\n", year);
    for(int i = 0; i < NUMBER_OF_RELEASES; i++){
      if (RELEASE_YEAR[i] < year){
        System.out.printf("\t%s (%d) with %d tracks\n", ALBUM_NAMES[i], RELEASE_YEAR[i], NUMBER_OF_TRACKS[i]);
      }
    }
  }
  private static void printFromAfterYear(int year){
    System.out.printf("Albums from after the year %d\n-------------------------------\n", year);
    for(int i = 0; i < NUMBER_OF_RELEASES; i++){
      if (RELEASE_YEAR[i] < year){
        System.out.printf("\t%s (%d) with %d tracks\n", ALBUM_NAMES[i], RELEASE_YEAR[i], NUMBER_OF_TRACKS[i]);
      }
    }
  }
}