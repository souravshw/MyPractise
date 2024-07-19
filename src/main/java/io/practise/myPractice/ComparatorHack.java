package io.practise.myPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Checker {

	public static Comparator desc = new Comparator(){
		public int compare(Object a0, Object a1) {
			if(((Player)a0).score >((Player)a1).score)
				return -1;
			else
				if(((Player)a0).score < ((Player)a1).score)
					return 1;
				else return NDesc.compare(a0, a1);
					
		}
	};
	
	public static Comparator NDesc = new Comparator(){
		public int compare(Object a0, Object a1) {
			if(((Player)a0).name.compareTo(((Player)a1).name) < 0)
				return 1;
			else
				if(((Player)a0).name.compareTo(((Player)a1).name) > 0)
					return -1;
				else
					return 0;
					
		}
	};
}

class Player
{
	String name;
	int score;
}

public class ComparatorHack {

	public static void main(String[] args) throws NumberFormatException, IOException {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
	  int N=Integer.parseInt(br.readLine().trim());
	  String s;
	  StringTokenizer st;
	  Player Player[]=new Player[N];
	  Checker check=new Checker();
	  for(int i=0;i<N;i++)
	  {
		  s=br.readLine().trim();
		  st=new StringTokenizer(s);
		  Player[i]=new Player();
		  Player[i].name=st.nextToken();
		  Player[i].score=Integer.parseInt(st.nextToken());
	  }
	 
	  Arrays.sort(Player,check.desc);
	  for(int i=0;i<Player.length;i++)
	  {
			System.out.printf("%s %s\n",Player[i].name,Player[i].score);
	  }

		
    }
}