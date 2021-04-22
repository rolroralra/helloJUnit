## JUnit5 Maven Setting
```xml
<dependencies>
    <!-- JUnit5 - jupiter-engine -->
    <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.7.0</version>
        <scope>test</scope>
    </dependency>
    
    <!-- JUnit5 - @ParameterizedTest-->
    <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-params</artifactId>
        <version>5.7.0</version>
        <scope>test</scope>
    </dependency>
    
    <!-- AssertJ -->
    <!-- https://mvnrepository.com/artifact/org.assertj/assertj-core -->
    <dependency>
        <groupId>org.assertj</groupId>
        <artifactId>assertj-core</artifactId>
        <version>3.16.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---
## AssertJ Example
> [StringTest.java](./src/test/java/org/example/string/StringTest.java)

---
## @ParameterizedTest
> [SetTest.java](./src/test/java/org/example/set/SetTest.java)