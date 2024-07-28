package io.practise.myPractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PeakValue {

  public static void main(String[] args) throws IOException {
    String line = null;
    ArrayList<Double> value = new ArrayList<Double>();
    double peak = 0.0;

    String fileName = args[0];
    if (fileName == null) {
      System.exit(0);
    }

    FileReader reader = new FileReader(fileName);
    BufferedReader read = new BufferedReader(reader);
    System.out.println("Reading File");
    line = read.readLine();
    while (line != null) {
      value.add(Double.parseDouble(line));
      System.out.println("In While " + line + " " + value.size());
      line = read.readLine();
    }

    for (int j = 0; j < value.size() - 1; j++) {
      if (j == 0)
        peak = (double) value.get(j);
      else if ((double) value.get(j) < (double) value.get(j + 1))
        continue;
      else
        peak = (double) value.get(j);
      System.out.println(peak);
    }

  }

}