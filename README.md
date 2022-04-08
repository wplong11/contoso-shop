# Contoso Shop

## 기술스택

- Data: MySQL(5.7.37)

## 로컬 개발 환경설정

### MySQL 설치 & 실행 및 접속

1. MySQL 이미지 pull

    ```shell
    $ docker pull mysql:5.7.37 --platform linux/x86_64
    ```

2. MySQL 컨테이너 생성 & 실행

    ```shell
    $ docker run --name $CONTAINER_NAME -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD -d -p 3306:3306 mysql:5.7.37
    ```

3. MySQL 접속

    - 계정명: root
    - 비밀번호: `$MYSQL_ROOT_PASSWORD` (`MySQL 컨테이너 생성 & 실행` 단계에서 설정한 값)

    ```shell
    $ mysql -h 127.0.0.1 -p 3306 -u root -p $MYSQL_ROOT_PASSWORD
    ```
