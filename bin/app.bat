@echo off
set DIR="%~dp0"
set JAVA_EXEC="%DIR:"=%\javaw"



pushd %DIR% & %JAVA_EXEC% %CDS_JVM_OPTS%  -p "%~dp0/../app" -m com.example.demo1/com.example.demo1.MainKt  %* & popd
