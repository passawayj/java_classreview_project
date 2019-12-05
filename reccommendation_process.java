import java.io.*;
import java.util.*;
public class Hwarang2{

	public static void main(String [] args){
		Reader reader = null;
		int[][][] array2 = {{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}};
		try{
		reader = new FileReader("C:\\Temp\\test.txt");
		char[] ch_buffer = new char[110];
		
		int r=0;
		int readerCounter = reader.read(ch_buffer,0,ch_buffer.length);
			String s = new String(ch_buffer);
		
	for(int i = 0 ; i < 6 ; i++){
			System.out.println("\n"+i);
			for(int j=0; j<2; j++) {
				System.out.println("");
				for(int k=0; k<7; k++) {
			array2[i][j][k]= Integer.parseInt(s.substring(r,r+1));
				r++;
				System.out.print(array2[i][j][k]);
				}
			}
		}
	}
	
	
		catch(FileNotFoundException fnfe){
		System.out.println("파일을 찾을수 없으");
	}
		
		catch(IOException ioe){
		System.out.println("파일 입출력 오류");
	}
		finally{
		System.out.println("프로그램 종료");
		try{
		reader.close();
		}
			catch(IOException ioe){
			ioe.printStackTrace();
			}
		}
	
	Scanner sc = new Scanner(System.in);
	Scanner input = new Scanner(System.in);

	System.out.printf("이번학기에 들으려는 과목명을 입력해주세요.:");
	int a1 = sc.nextInt();

	System.out.println("지금부터 자신이 중요하게 생각하는 선호도에 대한 대답을 해주시면 됩니다. 차례대로 첫번째 두번째 세번쨰 선호하는 순서대로 작성해 주세요");
	int a2=100;

	
	int [] array3 = new int[3];
	int []array4 = new int[3];
	int q=0;
       for(int i=0;i<3;i++){
		System.out.print("자신이 중요하게 생각하는 항목을 선택해주세요 1번>과제량 ,2번>팀플, 3번>난이도 , 4번> 강의 스타일 , 5번>출결체크 , 6번> 학점의 후함: "); // 1번부터 ~6번까지 중에 
	int important = sc.nextInt();

	

	
	
	switch(important){
		case 1:
		System.out.println("원하시는 과제량을 입력하시오:");
		a2 = input.nextInt(); // 과제량 정도에따른 a2
		break;

		case 2:
		System.out.println("팀플횟수는? :");
		a2 = input.nextInt();
		break;
		
		case 3:
		System.out.println("난이도는? :");
		a2 = input.nextInt();
		break;
	
		case 4:
		System.out.println("원하시는 강의 스타일을 입력하시오 :");
		a2 = input.nextInt();
		break;

		case 5:
		System.out.println("출결 체크의 원하는 정도를 입력하시오 :");
		a2 = input.nextInt();
		break;
		
		case 6:
		System.out.println("학점의 후함 정도를 입력하시오 :");
		a2 = input.nextInt();
		break;
		default :
		System.out.println("Error");
		}
	array3[q]=important;
	array4[q]=a2;
	q++;
	}

	for(int i = 0 ; i < 3 ; i++){
		System.out.print( i + "번째 우선순위와 가장 가까운 교수는 ");
		if(Math.abs(array2[a1][0][array3[i]]-array4[i])<Math.abs(array2[a1][1][array3[i]]-array4[i])) {
			System.out.print("")
			for(int j=0; j<7;j++) {
			System.out.println(array2[a1][0][j]);
			}
		else {
		System.out.println("교수B");
		for(int j=0; j<7;j++) {
			System.out.println(array2[a1][1][j]);
			}	
	}

	

	


	}
}





