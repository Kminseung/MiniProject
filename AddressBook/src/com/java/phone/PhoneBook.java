package com.java.phone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
	static final String rootPath = System.getProperty("user.dir");	
	static final String source = rootPath + "\\addressBook.txt";
	
	Scanner s = new Scanner(System.in);
	
	List<Phone> phone = new ArrayList<Phone>();
	
	private String name = null;		// 등록 시 입력받는 이름 저장 변수
	private String hp = null;		// 등록 시 입력받는 휴대전화 저장 변수
	private String tel = null;		// 등록 시 입력받는 집전화 저장 변수
	
	private int n = 0;
	
	private String sname = null;
	
	// 1번 리스트 기능
	// 파일 복사 및 리스트에 값 저장, 전체 조회 기능
	public void readPhone() {
		phone.clear();
		FileReader fr = null;
		BufferedReader br = null;
		
		String line = null;
		String[] splitLine = null;
		try {
			fr = new FileReader(source);
			br = new BufferedReader(fr);
			
			while((line=br.readLine()) != null) {		// txt 파일에 저장된 컨텐츠를 라인단위로 받음
				splitLine = line.split(",");			// 라인단위로 나눈 것을 ,를 기준으로 나누어 배열에 저장 
				phone.add(new Phone(splitLine[0], splitLine[1], splitLine[2]));
			}
			
		}
		catch(FileNotFoundException e) {
			System.err.println("파일 탐색 실패!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fr.close();
				br.close();
			}
			catch(Exception e) {
				
			}
		}
		
		System.out.println("\n<1. 리스트>");
		for(int i=0; i<phone.size(); i++) {
			System.out.printf("%d. %s %s %s%n", i+1, phone.get(i).getName(), 
					phone.get(i).getHp(), phone.get(i).getTel());
		}
		System.out.println();
	}
	
	// 2번 등록 기능
	// 등록 시 바로 파일에 덮어쓰기
	public void registerPhone() {
		System.out.println("\n<2. 등록>");
		
		System.out.print("> 이름 : ");
		name =  s.nextLine();
		System.out.print("> 휴대전화 : ");
		hp =  s.nextLine();
		System.out.print("> 집전화 : ");
		tel =  s.nextLine();
		System.out.println();
		
		phone.add(new Phone(name, hp, tel));
		
		String input = name + "," + hp +"," + tel +"\n";
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(source, true);
			writer.write(input);
			
			writer.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			}
			catch(Exception e) {
				
			}
		}
	}
	
	// 3번 삭제 기능
	// 입력 받은 숫자로 리스트에서 remove
	// 갱신된 리스트를 파일에 새로 저장
	public void removePhone() {
		System.out.println("\n<3. 삭제>");
		
		System.out.print("> 번호 : ");
		n =  s.nextInt();
		
		phone.remove(n-1);
		System.out.println("\n[삭제되었습니다.]\n");
		
		FileWriter writer = null;
		try {
			writer = new FileWriter(source);
			for(int i=0; i<phone.size(); i++) {
				String line = phone.get(i).getName()+","+phone.get(i).getHp()+","+phone.get(i).getTel()+"\n";
				writer.write(line);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			}
			catch(Exception e) {
				
			}
		}
	}
	
	// 4번 검색 기능
	public void searchPhone() {
		System.out.println("\n<4. 검색>");
		
		System.out.print("> 이름 : ");
		sname =  s.nextLine();
		
		boolean tof = false;
		
		for(int i=0; i<phone.size(); i++) {
			if(phone.get(i).getName().contains(sname)) {
				System.out.printf("%d. %s %s %s%n", i+1, phone.get(i).getName(), 
						phone.get(i).getHp(), phone.get(i).getTel());
				tof = true;
			}
		}
		System.out.println();
		
		if(tof == false)
			System.out.println("검색 결과가 없습니다.\n");
	}
}
