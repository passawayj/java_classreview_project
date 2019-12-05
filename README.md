# 목표  
#### 수강한 과목에 대한 평점을 적고 (리뷰 기능), 선택한 과목에 대한 추천 사용자의 기준에 따라 받을 수 있는 프로그램 작성 (추천 기능)  

# UML  
#### <image width = 500 src = "https://user-images.githubusercontent.com/58559928/70268757-7029ee80-17e4-11ea-9282-40e55760773e.png">




# 메인클래스  
``` java
name my = new name();
		for(;;) {
			System.out.println("리뷰하겠습니다 : 0, 추천 받겠습니다 : 1, 그만두겠습니다 : 2");
			int n1 = sc.nextInt();
			if(n1==2) break;
			else if(n1==1) System.out.println("추천");
			else if(n1==0) {
				System.out.print("수강한 과목명을 띄어쓰기 없이 정확하게 입력하시오.");
				String s1 = sc.next();

```


# 리뷰기능  
#### 이 과정을 통해 리뷰기능을 실행할 지 추천기능을 실행할 지 또는 프로그램을 종료할 것인지 정한다.   




``` java
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

```

#### 사용자가 과목을 입력하여 여러가지 기준들에 점수를 매기면 그것에 대한 총합을 구하고 (Em) 리뷰 작성자가 한 명 늘었단 것도 반영함. 


# name클래스 소스코드


'''java
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

'''
이 for문으로 사용자에게 여러가지 리뷰기준들에 대한 평가를 요구한다. 


``` java
public static double[][][] scale(double[][][] array1, int[][] array2, int n2, int n1, int sub){
		for(int i=0; i<7;i++) {
		array1[sub][n2][i] = array1[sub][n2][i] /  array2[sub][n2] ;
			}	
		return array1;
	}

```
#### 위의 함수는 각 기준들의 평균치를 내는 함수이다. 추천기능에서 이 함수의 return값들이 제대로 쓰이게된다.  

#list클래스

#### 이 클래스로 리뷰기능의 값들을 파일로 따로 저장한다. 


# 추천기능  

# hwarang2클래스  
#### 파일 여는 과정에 대한 설명은 생략함

``` java
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


```
위의 코드로 사용자의 기준을 정하고, 추천을 할 준비를 할 수 있다. 

``` java
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

```
#### 사용자가 차례차례 기준에 대한 취향을 switch문을 사용하여 입력할 수 있도록 하였다.

``` java
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

```
#### 위를 통해 사용자의 기준에 맞는 강의를 추천하고 출력할 수 있다. 


# 리뷰기능 테스트 결과

#### <image width = 500 scr = "![리뷰기능 테스트결과](https://user-images.githubusercontent.com/58559928/70269863-918bda00-17e6-11ea-8c95-973eb038a9a5.png">


# 추천기능 테스트 결과

#### <image width = 500 scr = "https://user-images.githubusercontent.com/58559928/70269882-9badd880-17e6-11ea-9345-cd2ada483991.png">
