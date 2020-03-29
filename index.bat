echo off
echo NUL>_.class&&del /s /f /q *.class
cls
javac com/krzem/screen_blocker/Main.java&&java com/krzem/screen_blocker/Main
start /min cmd /c "echo NUL>_.class&&del /s /f /q *.class"