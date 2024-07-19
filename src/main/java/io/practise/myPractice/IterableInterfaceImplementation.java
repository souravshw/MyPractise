package io.practise.myPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

public class IterableInterfaceImplementation {

	public static void main(String[] args) {
		IterableInterface ob = new IterableInterface();

		for (String html : ob) {
			System.out.println(html);
		}

	}

}

class IterableInterface implements Iterable<String> {
	private LinkedList<String> url = new LinkedList<>();

	private class Iterate implements Iterator<String> {
		int index = url.size();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < url.size();
		}

		@Override
		public String next() {
			StringBuilder sb = new StringBuilder();
			try {
				URL curUrl = new URL(url.get(index));
				BufferedReader br = new BufferedReader(new InputStreamReader(curUrl.openStream()));

				String line = null;
				while (br.readLine() != null) {
					sb.append(line + "\n");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index++;
			return sb.toString();
		}

	}

	IterableInterface() {
		url.add("http://www.xvideos.com/video17054253/my_busty_milf_stepmom_treats_me_well");
		url.add("http://www.xvideos.com/video15433507/busty_stepmom_from_sexdatemilf.com_fucks_her_stepson_in_the_kitchen");
	}
	/*
	 * @Override public Iterator<String> iterator() { return url.iterator(); }
	 */

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new Iterate();
	}

}