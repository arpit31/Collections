package com.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class DateHolder {
	Date date;
	int flag;

	DateHolder(Date date) {
		this.date = date;
	}

	DateHolder(Date date, int flag) {
		this.date = date;
		this.flag = flag;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "DateHolder [date=" + date + ", flag=" + flag + "]";
	}

}

public class ContinousLogIn{
	static StringBuffer continousLoggedin = new StringBuffer();

	static Date convertStringToDate(String curDate) throws ParseException {
		final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		final Date date = format.parse(curDate);
		return date;
	}

	
	static void checkForConsecutiveDays(Map<String, DateHolder> map, String key, Date date) {
		DateHolder value = map.get(key);
		int flag = value.getFlag();
		Calendar cal = Calendar.getInstance();
		cal.setTime(value.getDate());
		cal.add(Calendar.DATE, flag);
		Date archived = cal.getTime();
		if (archived.equals(date)) { // compare if current date is next to archive , if yes then increae flag by 1
			value.setFlag(flag + 1);
			if (value.getFlag() == 4)
				continousLoggedin.append(key);
		} else if (!archived.equals(date)) {
			value.setFlag(0);
		}

	}

	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader("ContinousLogInData.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		br = new BufferedReader(fr);

		String sCurrentLine;

		StringTokenizer stk;
		String value = " ";
		String key = " ";

		Map<String, DateHolder> map = new HashMap<String, DateHolder>();

		int indicator = 1;
		Date date = null;
		try {
			while ((sCurrentLine = br.readLine()) != null) {
				stk = new StringTokenizer(sCurrentLine);

				while (stk.hasMoreElements()) {
					if (indicator == 1) { // condition to hold value as in text
											// file first entry is of date and
											// then id and here we are making
											// Date as value
						value = (String) stk.nextElement();

						date = convertStringToDate(value);

						indicator = 2;

					}
					if (indicator == 2) { // condition to get id as key
						key = (String) stk.nextElement();
						if (!map.containsKey(key)) {
							map.put(key, new DateHolder(date, 1));
						} else if (map.containsKey(key)) {
							checkForConsecutiveDays(map, key, date);
						}
						indicator = 1;
					}

				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		System.out.println("continousLoggedin " + continousLoggedin);
	}
}
