/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.practise.ocpPractise;

/**
 * @author sanu
 */
public class EnumsInClass {

  public static void main(String[] args) {

    for (AGGREGATION temp : AGGREGATION.values()) {
      if (temp.HOURLY.getDuration().compareTo(String.valueOf(100)) > 0)
        System.out.println(temp.getDuration());
    }

    for (SEASON temp : SEASON.values()) {
      temp.officeHours();
    }

  }

  public enum AGGREGATION {
    HOURLY("724"), DAILY("31"), WEEKLY("4"), MONTHLY("1");

    private final String duration;

    private AGGREGATION(String monthDuration) {
      this.duration = monthDuration;
    }

    public String getDuration() {
      return this.duration;
    }
  }

  public enum SEASON {
    WINTER {
      public void officeHours() {
        System.out.println("10am to 7pm");
      }
    },
    SPRING {
      public void officeHours() {
        System.out.println("9:30am to 6:30pm");
      }
    },
    SUMMER {
      public void officeHours() {
        System.out.println("9am to 6pm");
      }
    },
    RAINY {
      public void officeHours() {
        System.out.println("10am to 7pm");
      }
    };

    public void officeHours() {
      System.out.println("Please select the season mentioned above");
    }
  }

}
