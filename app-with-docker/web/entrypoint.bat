@echo off

rem -------------------------------------------------------------------------
rem
rem 使用说明：
rem
rem 1: 该脚本用于别的项目时只需要修改 MAIN_CLASS 即可运行
rem
rem 2: JAVA_OPTS 可通过 -D 传入 undertow.port 与 undertow.host 这类参数覆盖
rem    配置文件中的相同值此外还有 undertow.resourcePath, undertow.ioThreads
rem    undertow.workerThreads 共五个参数可通过 -D 进行传入
rem
rem 3: JAVA_OPTS 可传入标准的 java 命令行参数,例如 -Xms256m -Xmx1024m 这类常用参数
rem
rem
rem -------------------------------------------------------------------------

setlocal & pushd


rem 启动入口类,该脚本文件用于别的项目时要改这里
set MAIN_CLASS=${main.class}
set APP_NAME=${app.name}

rem Java 命令行参数,根据需要开启下面的配置,改成自己需要的,注意等号前后不能有空格
JVM_OPTS="-Dname=$APP_NAME -Duser.timezone=Asia/Shanghai -Xms512m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDateStamps  -XX:+PrintGCDetails -XX:NewRatio=1 -XX:SurvivorRatio=30 -XX:+UseParallelGC -XX:+UseParallelOldGC"


if "%1"=="start" goto normal
if "%1"=="stop" goto normal
if "%1"=="restart" goto normal

goto error


:error
echo Usage: entrypoint.bat start | stop | restart
goto :eof


:normal
if "%1"=="start" goto start
if "%1"=="stop" goto stop
if "%1"=="restart" goto restart
goto :eof


:start
set APP_BASE_PATH=%~dp0
set CP=%APP_BASE_PATH%config;%APP_BASE_PATH%lib\*
echo starting app
java -Xverify:none %JVM_OPTS% -cp %CP% %MAIN_CLASS%
goto :eof


:stop
set "PATH=%JAVA_HOME%\bin;%PATH%"
echo stopping jfinal undertow
for /f "tokens=1" %%i in ('jps -l ^| find "%MAIN_CLASS%"') do ( taskkill /F /PID %%i )
goto :eof


:restart
call :stop
call :start
goto :eof

endlocal & popd
pause