# This is an example testing in Android application
A collection of different frameworks and techniques for testing.

1. <a href="http://junit.org/junit4/">JUnit</a> is the most popular and widely-used unit testing framework for Java. The latest version of this framework, JUnit 4, allows you to write tests in a cleaner and more flexible way than its predecessor versions.
2. <a href="http://site.mockito.org/">Mockito</a> is a mocking framework that tastes really good. It lets you write beautiful tests with a clean & simple API. Mockito doesn’t give you hangover because the tests are very readable and they produce clean verification errors. Read more about <a href="https://github.com/mockito/mockito/wiki/Features-And-Motivations">features & motivations.</a> 
3. <a href="https://github.com/vanniktech/gradle-android-junit-jacoco-plugin">Jacoco</a> is a gradle plugin that generates Jacoco reports from a Gradle Project. Android Application, Android Library and Java Plugins are supported by this plugin. When this plugin is applied it goes over every subproject and creates the corresponding Jacoco tasks.
4. <a href="https://google.github.io/android-testing-support-library/docs/espresso/index.html">Espresso</a> is targeted at developers, who believe that automated testing is an integral part of the development lifecycle. While it can be used for black-box testing, Espresso’s full power is unlocked by those who are familiar with the codebase under test.
5. <a href="https://github.com/square/spoon">Spoon</a> is a gradle plugin allows you to distribute instrumentation tests to all your Androids.
6. <a href="https://github.com/stanfy/spoon-gradle-plugin">Spoon Gradle Plugin</a> is a gradle plugin for Spoon. Allows you to run spoon with almost no effort under new Android build system.

===========================================
In top-level build.gradle file of project, you need to put class path as below:
```groovy
repositories {
        jcenter()
        mavenCentral()
        ...
    }
dependencies {
        ...
        classpath 'com.stanfy.spoon:spoon-gradle-plugin:1.2.2'
        classpath 'com.vanniktech:gradle-android-junit-jacoco-plugin:0.5.0'
        ...
    }
```
===========================================
In your app's top-level build.gradle file, you need to specify these libraries as dependencies:
```groovy
    ...
    // Allows you to run spoon with almost no effort under new Android build system.
    apply plugin: 'spoon'
    // Gradle plugin that generates Jacoco reports from a Gradle Project
    apply plugin: 'com.vanniktech.android.junit.jacoco'
    ...
```

```groovy
dependencies {
    ...
    // Espresso testing
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    // Spoon testing
    androidTestCompile 'com.squareup.spoon:spoon-client:1.7.0'
    testCompile 'junit:junit:4.12'
    ...
}
```

This section is optional
```groovy
spoon {
    // for debug output
    debug = true

    // To run a single test class
    className = 'com.bonnguyen.tax.test.van.VanInstrumentedTest'

    // To run a single method in TestCase
    methodName = 'testCalculatorTax'

    // To execute the tests device by device */
    sequential = true

    // To grant permissions to Android M >= devices */
    grantAllPermissions = true
}
```
And
```groovy
junitJacoco {
    jacocoVersion = '0.7.2.201409121644' // type String
    ignoreProjects = [] // type String array
    excludes // type String List
}
```

# Run Local Unit Tests
1. Using IDE, plz read <a href="https://developer.android.com/training/testing/unit-testing/local-unit-tests.html">more details</a>
2. Or open terminal on Mac OSX and run command:
```groovy
  ./gradlew test
```
With jacoco plugin, you can also to display test summary:
```groovy
  ./gradlew testDebugUnitTest
```
And result after run plugin
<table>
  <tr>
    <td width="100%"><img src="https://i.imgur.com/Q5vnRLB.png"/></td>
  </tr>
  <tr>
    <td width="100%"><img src="https://i.imgur.com/8iNAEma.png"/></td>
  </tr>
  <tr>
    <td width="100%"><img src="https://i.imgur.com/MbQIskM.png"/></td>
  </tr>
</table>

# Run Instrumented Unit Tests
1. Using IDE, plz read <a href="https://developer.android.com/training/testing/unit-testing/instrumented-unit-tests.html#run">more details</a>
2.  Or open terminal on Mac OSX and run command:
```groovy
  ./gradlew spoon
```
Then display result
<table>
  <tr>
    <td width="100%"><img src="https://i.imgur.com/zDdeYpw.png"/></td>
  </tr>
  <tr>
    <td width="100%"><img src="https://i.imgur.com/TvsI0xY.png"/></td>
  </tr>
  <tr>
    <td width="100%"><img src="https://i.imgur.com/ZVBF3dM.png"/></td>
  </tr>
</table>

Bugs, Suggestions, Ideas
========================
Any ideas/bugs/etc, as well as pull requests, are welcome in the [issues section](https://github.com/bonnguyen/AndroidUnittestExample/issues).

DEVELOP BY
===================================
[Bon Nguyen](https://github.com/bonnguyen) - nguyennhatbon07t1@gmail.com
