
	import java.awt.CheckboxMenuItem;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
public class  memo extends Frame implements ActionListener ,KeyListener{
		Panel p=new Panel();
		String filename;
		String filename2;
		String text;
		int start;
		int end;
		FileDialog fd=new FileDialog(this,"열기",FileDialog.LOAD);
		FileDialog fd2=new FileDialog(this,"저장",FileDialog.SAVE);
		MenuBar mb;
		TextArea ta;
		Menu m1;
		Menu m2;
		Menu m3;
		Menu m4;
		Menu m5;
		MenuItem mi1;
		MenuItem mi2;
		MenuItem mi3;
		MenuItem mi4;
		MenuItem mi5;
		MenuItem mi6;
		MenuItem mi7;
		MenuItem mii1;
		MenuItem mii2;
		MenuItem mii3;
		MenuItem mii4;
		MenuItem mii5;
		MenuItem mii6;
		MenuItem mii7;
		MenuItem mii8;
		MenuItem mii9;
		MenuItem mii10;
		MenuItem mii11;
		CheckboxMenuItem miii1;
		MenuItem miii2;
		MenuItem miiii1;
		MenuItem miiiii1;
		MenuItem miiiii2;
		memo(){
		mb=new MenuBar();
		ta=new TextArea("",54,68,TextArea.SCROLLBARS_VERTICAL_ONLY);
		m1=new Menu("파일(F)");
		m2=new Menu("편집(E)");
		m3=new Menu("서식(O)");
		m4=new Menu("보기(V)");
		m5=new Menu("도움말(H)");
		mi1=new MenuItem("새로만들기(N)");
		mi2=new MenuItem("열기(O)...");
		mi3=new MenuItem("저장(S)");
		mi4=new MenuItem("다른이름으로 저장(A)...");
		mi5=new MenuItem("페이지 설정");
		mi6=new MenuItem("인쇄(U)...");
		mi7=new MenuItem("끝내기(P)...");
		mii1=new MenuItem("실행취소(U)");
		mii2=new MenuItem("잘라내기(T)");
		mii3=new MenuItem("복사(C)");
		mii4=new MenuItem("붙여넣기(P)");
		mii5=new MenuItem("삭제(L)");
		mii6=new MenuItem("찾기(F)...");
		mii7=new MenuItem("다음 찾기(N)");
		mii8=new MenuItem("바꾸기(R)...");
		mii9=new MenuItem("이동(G)...");
		mii10=new MenuItem("모두선택(A)");
		mii11=new MenuItem("시간/날짜(D)");
		miii1=new CheckboxMenuItem("자동줄바꿈",true);
		miii2=new MenuItem("글꼴(F)...");
		miiii1=new MenuItem("상태표시줄(S)");
		miiiii1=new MenuItem("도움말 항목(H)");
		miiiii2=new MenuItem("메모장 정보(A)");
		

		setMenuBar(mb);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi4);
		m1.addSeparator();
		m1.add(mi5);
		m1.add(mi6);
		m1.addSeparator();
		m1.add(mi7);
		m2.add(mii1);
		m2.addSeparator();
		m2.add(mii2);
		m2.add(mii3);
		m2.add(mii4);
		m2.add(mii5);
		m2.addSeparator();
		m2.add(mii6);
		m2.add(mii7);
		m2.add(mii8);
		m2.add(mii9);
		m2.addSeparator();
		m2.add(mii10);
		m2.add(mii11);
		m3.add(miii1);
		m3.add(miii2);
		m4.add(miiii1);
		m5.add(miiiii1);
		m5.addSeparator();
		m5.add(miiiii2);
		p.add(ta);
		this.add(p);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi7.addActionListener(this);
		mii2.addActionListener(this);
		mii3.addActionListener(this);
		mii4.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {

			   public void windowClosing(WindowEvent e) {

			    System.exit(0);
			   }
			  }); 

		setSize(500,600);
		setVisible(true);
		}

		public void actionPerformed(ActionEvent e){
			if(e.getSource()==mi2){
				fd.setVisible(true);
				filename=fd.getDirectory()+fd.getFile();
				filename2=fd.getFile();
				this.loadFile(filename, filename2);
			}
			else if(e.getSource()==mi3){
				fd2.setTitle("저장파일선택");
				fd2.setVisible(true);
				String filename=fd.getDirectory()+fd.getFile();
				String filename2=fd.getFile();
				this.saveFile(filename, filename2);
			}
			if(e.getSource()==mi7){
				System.exit(0);

			}
			else if(e.getSource()==mii3){
				text=ta.getSelectedText();
				start=ta.getSelectionStart();
				end=ta.getSelectionEnd();
			}
			else if(e.getSource()==mii4){
				start=ta.getSelectionStart();
				ta.insert(text, start); 
			}
		}
		public void loadFile(String fn,String fn2){
			File file=new File(fn);
			FileReader fr=null;
			BufferedReader br=null;
			try{
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			String str=null;
			ta.setText("");
			while((str=br.readLine()) !=null){
			ta.append(str+"\n");
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		}
		public void saveFile(String fn,String fn2){
			File file=new File(fn);
			try{
			FileOutputStream fos=new FileOutputStream(file);
			PrintStream ps=new PrintStream(fos);
			ps.print(ta.getText());
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
		public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode()==ke.VK_CONTROL){
				text=ta.getSelectedText();
				start=ta.getSelectionStart();
				end=ta.getSelectionEnd();
				if(ke.getKeyCode()==ke.VK_C){
					text=ta.getSelectedText();
				}
				}
				if(ke.getKeyCode()==ke.VK_ESCAPE){
					super.setLocation(10,10);
				}
		}
		public void keyReleased(KeyEvent e){
		}
		public void keyTyped(KeyEvent e){
		}
		
		public static void main(String[] args){
			memo mm=new memo();
			
		}
		
	}

