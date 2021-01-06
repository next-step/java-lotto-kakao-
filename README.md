# 로또
## 진행 방법
* 로또을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)



## 프로그래밍 요구사항
indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
else를 사용하지 마라.
메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
method가 한 가지 일만 하도록 최대한 작게 만들어라.
배열 대신 ArrayList를 사용한다.
java enum을 적용해 프로그래밍을 구현한다.
규칙 3: 모든 원시값과 문자열을 포장한다.
규칙 5: 줄여쓰지 않는다(축약 금지).
규칙 8: 일급 콜렉션을 쓴다.


## 기능 요구사항

-[ ] Model : Lotto, LottoNumber, LottoNumbers
    -[ ] 로또 번호  
        -[ ] 로또 번호 생성
    -[ ] 로또 세트
        -[ ] 로또 번호 정렬
        -[ ] 당첨 결과 계산 로직 
    -[ ] 로또 매니저
        -[ ] 당첨금 계산
        -[ ] 수익률 계산

-[ ] View
    -[ ] 금액 입력
    -[ ] 당첨 번호 입력
     
    -[ ] 구매한 로또 복권 번호 출력
    -[ ] 당첨 통계 출력
     
-[ ] Controller
    -[ ] View, Model 호출 
    


# joy

-[ ] 금액 입력
-[ ] 당첨 번호 입력
-[ ] 구매한 로또 번호 출력
-[ ] 당첨 통계 출력
 
-[ ] 로또 번호 생성
-[ ] 로또 번호 정렬
 
-[ ] 당첨금 계산
-[ ] 수익률 계산
-[ ] 


## jon
* LottoNumber 클래스 구현
* LottoNumber 클래스 범위 체크 구현
* LottoNumber 클래스 equal 구현
* Ball 클래스 구현
* Ball 클래스 equal 구현
* 일급 콜렉션 Balls 구현
* 난수 생성 로직 구현
* 일치하는 Ball 갯수 구하는 로직 구현
* 수익률 계산 로직 구현
* 입출력 구현




구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
