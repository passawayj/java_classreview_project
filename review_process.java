import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
public class reviewtest {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		double [][][] array1 = {{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}};
	/*array1의 인자 순서 : 과목-교수2명-특징, 특징의 점수는 0으로 초기화*/
		int [][] array2 = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
	/*array2의 인자 순서 : 과목 - 교수2명, 리뷰받을 때마다 특징의 평균을 내기 위해 세는 변수. 0으로 초기화 */
		name my = new name();
		for(;;) {
			System.out.println("리뷰하겠습니다 : 0, 추천 받겠습니다 : 1, 그만두겠습니다 : 2");
			int n1 = sc.nextInt();
			if(n1==2) break;
			else if(n1==1) System.out.println("추천");
			else if(n1==0) {
				System.out.print("수강한 과목명을 띄어쓰기 없이 정확하게 입력하시오.");
				String s1 = sc.next();
				switch (s1){
					case "전자장" : {
/*sub는 과목별 번호*/				int sub = 0;
						System.out.print("교수A : 0, 교수B, 1");
						int n2 = sc.nextInt();
						array1=my.Em(array1, array2, n2, n1, sub); /*Em함수는 리뷰 시 특징 점수의 총 합을 얻는 함수*/
/*한 사람이 더 리뷰했다는 의미로 1+함.*/		array2[sub][n2]++;
/*scale함수는 평균을 내는 함수.*/			array1 = my.scale(array1, array2, n2, n1, sub);
						break;
					}
					case "회로이론1" : {
						int sub = 1;
						System.out.print("교수A : 0, 교수B, 1");
						int n2 = sc.nextInt();
						array1=my.Em(array1, array2, n2, n1, sub);
						array2[sub][n2]++;
						array1 = my.scale(array1, array2, n2, n1, sub);
						break;
					}
					case "논리회로설계" :{
						int sub = 2;
						System.out.print("교수A : 0, 교수B, 1");
						int n2 = sc.nextInt();
						array1=my.Em(array1, array2, n2, n1, sub);
						array2[sub][n2]++;
						array1 = my.scale(array1, array2, n2, n1, sub);
						break;
					}
					case"자바프로그래밍" :{
						int sub = 3 ;
						System.out.print("교수A : 0, 교수B, 1");
						int n2 = sc.nextInt();
						array1=my.Em(array1, array2, n2, n1, sub);
						array2[sub][n2]++;
						array1 = my.scale(array1, array2, n2, n1, sub);
						break;
					}
					case"선형대수" : {
						int sub = 4;
						System.out.print("교수A : 0, 교수B, 1");
						int n2 = sc.nextInt();
						array1=my.Em(array1, array2, n2, n1, sub);
						array2[sub][n2]++;
						array1 = my.scale(array1, array2, n2, n1, sub);
						break;
					}
					case "전자공학실험1" : {
						int sub = 5;
						System.out.print("교수A : 0, 교수B, 1");
						int n2 = sc.nextInt();
						array1=my.Em(array1, array2, n2, n1, sub);
						array2[sub][n2]++;
						array1 = my.scale(array1, array2, n2, n1, sub);
						break;
					}
					default : System.out.println("잘못된 과목명입니다. 다시 입력하여 주세요."); break;
  				 }
			} 

		} 
		list aa = new list();
		aa.bb(array1);
		
				
	}
}

class name {
	//Em함수는 특징들 점수 입력받은 후 총 합을 return시키는 함수
	public static double[][][] Em(double[][][]array1, int[][] array2, int n2, int n1, int sub) {
		Scanner sc= new Scanner(System.in);
		for(int i = 0; i < array1[sub][n2].length ; i++){
			array1[sub][n2][i] = array1[sub][n2][i] * array2[sub][n2];
		} // 각 특징 별 평균을 다시 총합의 값으로 되돌림.
	

			//밑에 for문은 각 특징들 마다 점수매기는 작업임.
		for(int i=0;i<7;i++) {
			switch (i) {
				case 0 : System.out.print("시험횟수 ");break;
				case 1 : System.out.print("과제 량 "); break;
				case 2 : System.out.print("팀플 횟수 ");break;
				case 3 : System.out.print("난이도 "); break;
				case 4 : System.out.print("강의 스타일(이론에 가까울 수록 0 실전에 가까울수록 10) "); break;
				case 5 : System.out.print("출결 체크(자주 할수록 10에 가깝게 "); break;
				case 6 : System.out.print("학점의 후함정도 "); break;
				default : break;
			}

			System.out.print("(을)를 입력하여 주세요 : \n");
			array1[sub][n2][i] += sc.nextDouble();
		}

		return array1;
	}


	//밑에 함수는 특징들 평균내는 함수.	
	public static double[][][] scale(double[][][] array1, int[][] array2, int n2, int n1, int sub){
		for(int i=0; i<7;i++) {
		array1[sub][n2][i] = array1[sub][n2][i] /  array2[sub][n2] ;
			}	
		return array1;
	}
}

class list {
	public static void bb (double [][][]array1) {
	
	JFrame f = new JFrame();
	f.setSize(350,250);
	f.setLayout(null);
	f.setVisible(true);
	
	FileDialog dialog = new FileDialog(f,"저장",FileDialog.SAVE);
	dialog.setVisible(true);
	
	String path = dialog.getDirectory() + dialog.getFile();
	System.out.println(path);
	
	try {
		FileWriter w = new FileWriter("test") ;
		String a = "";
		
		
		for(int i = 0 ; i < 6 ; i++){
			for(int j=0; j<2; j++) {
				for(int k=0; k<7; k++) {
			a = "" +(int)array1[i][j][k];

			w.write(a );
				}
			}
		} 
		w.close();		
		
	}
	catch(Exception e) {
}
	}
}




