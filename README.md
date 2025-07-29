# tech-seminar-loginWithNginx



\# \[프론트엔드 기술세미나-]



실행 방법: 



스프링 서비스서버,인증서버 build ./gradlew build 해서 jar 파일 생성



js 프로젝트의 out 폴더의 정적 파일서빙 ( npm run build → npm run export)



WSL에서 out 폴더,jar 파일 2개를 우분투로 복사 (scp 명령어 사용)



우분투에서 nginx 시작(sudo nginx -t , sudo service nginx (re)start )



우분투 서버에서 ip를 찾아서 브라우저에서 ip 주소로 접속

