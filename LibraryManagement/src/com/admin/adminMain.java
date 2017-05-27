package com.admin;

import java.util.Scanner;

import javax.swing.InputMap;

import com.book.Book;
import com.book.bookMysql;
import com.main.Main;
import com.main.Show;

public class adminMain {
      Scanner input=new Scanner(System.in);
		public void go() throws Exception {
			adminUse adminUse=new adminUse();
			Show show=new Show();
			show.showAdmin();
			int xuanze=input.nextInt();
			if(xuanze==1){
				adminUse.add();
			}
			else if(xuanze==2){
				adminUse.DeleteBook();
			}
			else if (xuanze==3){
				adminUse.Check();
			}
			else if(xuanze==0){
				Main main=new Main();
				main.main(null);
			}
		}
}
