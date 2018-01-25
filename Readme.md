# Bootstrap a CRUD application with Play, Spring & Hibernate JPA

This is a basic CRUD application that integrates Spring (As a Spring container allows to easily manage application-specific beans) and hibernate JPA with Play 2.5 framework.

Some important files to have a look at:

	* app/Module.java 
	  Play by default loads Module class present in the root package when the application starts. 
	  PlayConfigReader and Global are binded as Eager Singletons here. This means, 
	  	1. New PlayConfigReader and Global objects will be created only once. 
		2. Also they are created eagerly when the application starts up, rather than lazily when they are needed
	                      
	* app/configs/PlayConfigReader.java 
	  This class reads the entire application.conf & can be imported to access Play application.conf properties

	* app/configs/Global.java 
	  Sets up the Spring application context

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Install JDK

```
sudo apt-get install default-jdk
```
To set JAVA_HOME environmental variable check https://askubuntu.com/questions/175514/how-to-set-java-home-for-java .

### Install activator

Download the typesafe activator

```
wget https://downloads.typesafe.com/typesafe-activator/1.3.12/typesafe-activator-1.3.12.zip
```

Unzip the downloaded file

```
unzip typesafe-activator-1.3.12.zip 
```

Add Activator to your PATH to have the activator command available in your cli

```
export PATH=/home/ubuntu/activator-dist-1.3.12/bin/activator:$PATH
```

Create a symbolic link to activator

```
sudo ln -s /home/ubuntu/activator-dist-1.3.12/bin/activator /usr/bin/activator
```

### Install mysql server

```
sudo apt-get install mysql-server
```
Make sure you are able to access mysql without sudo from the command line. If not check this link https://askubuntu.com/questions/766334/cant-login-as-mysql-user-root-from-normal-user-account-in-ubuntu-16-04


### Clone the repository

```
git clone https://github.com/chirrag03/play-java-spring-hibernate.git
```

### Set the following parameters in conf/application.conf

```
db {
	default.driver = com.mysql.jdbc.Driver
	default.url = "jdbc:mysql://localhost:3306/v1?characterEncoding=UTF-8"
	default.username = root
	default.password = "xyz"
}
```

### Running the project

```
cd play-java-spring-hibernate
```
```
activator run
```

For the first time, it will take several minutes. When the application is up, you can test the application in browser

```
localhost:9000
```

## Running the tests

To test CRUD APIs you need to create a test_table using the query below:

```
CREATE TABLE `test_table` (
      `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
      `name` varchar(20) DEFAULT NULL,
      `url` varchar(2048) NOT NULL DEFAULT '',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

Test the APIs. Eg:

```
http://localhost:9000/api/v1/testing
```


