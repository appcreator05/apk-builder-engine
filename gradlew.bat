@if "%DEBUG%" == "" @echo off
setlocal
set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Determine the Java command to use to start the JVM.
if "%JAVA_HOME%" == "" goto gnu-java_home

set JAVACMD=%JAVA_HOME%\bin\java.exe
if exist "%JAVACMD%" goto execute

echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.
goto fail

:gnu-java_home
set JAVACMD=java.exe
%JAVACMD% -version >NUL 2>&1
if errorlevel 1 goto no-java

:execute
@rem Setup the JVM arguments
set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"

@rem Execute Gradle
"%JAVACMD%" %DEFAULT_JVM_OPTS% -jar "%APP_HOME%\gradle\wrapper\gradle-wrapper.jar" %*

:fail
exit /b 1

:no-java
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
goto fail
