# BookShelves
Demo Video:
https://www.youtube.com/watch?v=_qZjuBh0530

Welcome Page
	
	https://kgbookshelves.herokuapp.com/ GET

![Screenshot from 2022-10-25 04-13-12](https://user-images.githubusercontent.com/52675676/197645470-7876d575-79ee-4fea-98b6-7e776a5e495f.png)
AllbookPage (GET)
	
	https://kgbookshelves.herokuapp.com/allbooks GET

![Screenshot from 2022-10-25 04-13-37](https://user-images.githubusercontent.com/52675676/197645512-e64831c0-a473-4e2d-bc89-2952a5ffef21.png)

	Inserting Data into DB (POST)
	
	https://kgbookshelves.herokuapp.com/save  POST
	
	Body: 
	{
    		"bookname" : "Intro to C",
    		"isbn_no" : "1234567890",
    		"author" : "ujherik",
    		"link" : "https://m.media-amazon.com/images/I/51rHVOum7hL.jpg",
    		"publisher" : "xyz",
    		"price" : "450"

	}

![Screenshot from 2022-10-25 04-16-00](https://user-images.githubusercontent.com/52675676/197645669-03d6b279-858d-44e3-bb0d-7ab62891c57d.png)
After Inserting Data into DB (GET)

	https://kgbookshelves.herokuapp.com/allbooks GET

![Screenshot from 2022-10-25 04-16-22](https://user-images.githubusercontent.com/52675676/197645730-6d9f5b9d-5788-46c6-a3e9-52346769468a.png)

	Updating Data (PUT)

	https://kgbookshelves.herokuapp.com/updatedata/2  PUT
	
	Body: 
	{
    		"bookname" : "Intro to C",
    		"isbn_no" : "1234567890",
    		"author" : "ujherik",
    		"link" : "https://m.media-amazon.com/images/I/51rHVOum7hL.jpg",
    		"publisher" : "xyz",
    		"price" : "450"

	}

![Screenshot from 2022-10-25 04-17-11](https://user-images.githubusercontent.com/52675676/197645835-2b822a24-55ef-4340-b698-371302a354d7.png)
After Updating Data into DB (GET)

	https://kgbookshelves.herokuapp.com/allbooks GET

![Screenshot from 2022-10-25 04-17-33](https://user-images.githubusercontent.com/52675676/197645870-227139c2-510a-48ac-9cc6-7e551619b529.png)

	Delete Data from DB (DELETE)
	
	https://kgbookshelves.herokuapp.com/delete/2  PUT
	
	Body : None
	

![Screenshot from 2022-10-25 04-18-11](https://user-images.githubusercontent.com/52675676/197645937-603494d5-e4cd-4956-8603-13024dc3794c.png)
After Deleting Data from DB (GET)

	https://kgbookshelves.herokuapp.com/allbooks GET

![Screenshot from 2022-10-25 04-18-23](https://user-images.githubusercontent.com/52675676/197646009-381b6b89-d6c7-403d-8314-36320dc6020b.png)

	Authorization:
Getting Access Token & Refresh Token (POST)	

	https://kgbookshelves.herokuapp.com/api/login POST
![Screenshot from 2022-10-30 18-45-53](https://user-images.githubusercontent.com/52675676/198880690-fe9bf5c7-1bd8-418f-9caf-fd9f8d267676.png)


UnAuthorized (GET)
![Screenshot from 2022-10-30 18-38-15](https://user-images.githubusercontent.com/52675676/198880714-acec60ba-2074-4f4f-86cc-9aa2a9b160d6.png)


	. https://kgbookshelves.herokuapp.com/api/users GET
	Authorized Got The Data from DB(GET)
![Screenshot from 2022-10-30 18-38-04](https://user-images.githubusercontent.com/52675676/198880753-eddb2d89-1f25-4933-a44a-5dbda3a3716b.png)




Dependency Used

<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/log4j/log4j -->
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>

			<dependency>
				<groupId>org.projectlombok</groupId>
				<artifactId>lombok</artifactId>
				<scope>provided</scope>
			</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-config -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-config</artifactId>
			<version>5.7.4</version>
		</dependency>




		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
			<version>2.7.5</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-core</artifactId>
			<version>5.7.4</version>
		</dependency>


		<!-- https://mvnrepository.com/artifact/org.springframework.security.oauth/spring-security-oauth2 -->
		<dependency>
			<groupId>org.springframework.security.oauth</groupId>
			<artifactId>spring-security-oauth2</artifactId>
			<version>2.5.2.RELEASE</version>
		</dependency>



		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.31</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.auth0/java-jwt -->
		<dependency>
			<groupId>com.auth0</groupId>
			<artifactId>java-jwt</artifactId>
			<version>4.2.1</version>
		</dependency>

	</dependencies>



