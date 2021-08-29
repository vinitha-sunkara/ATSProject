@ECHO OFF 
:: This batch file Will Run the ATS Search Engine on Dutch City Data
TITLE ATS Search Engine
ECHO ATS Search Engine

ECHO ============================
ECHO Java Path Configuration
ECHO %JAVA_HOME%
ECHO ============================

ECHO Path Configurations
ECHO %PATH%
ECHO ============================

ECHO Should Contain the Java and Maven Configurations

ECHO ============================
ECHO Current Path :
ECHO %cd%
ECHO ============================
ECHO Files in Current Path :
for %%a in (*) do ECHO %%a
ECHO ============================

ECHO Started ATS Search Engine ..
ECHO Current Path Should Contain The File ATSTest-0.0.1-SNAPSHOT.jar

java -jar ATSTest-0.0.1-SNAPSHOT.jar

ECHO ============================

PAUSE