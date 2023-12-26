#! /bin/sh

export JAVA_HOME=$JAVA_HOME:/usr/lib/jvm/java-1.6.0-openjdk-i386/bin/java
export PATH=/usr/lib/jvm/jdk-19.0.2/bin:$PATH

#java -cp target/semesterii.jar ru.itis.dis205.semestrii.testclient.TestClient
java -cp "lib/*":target/semesterii.jar ru.itis.dis205.semestrii.repeater.MainRepeater
