@echo off
echo Compilando y ejecutando Tech-Park UQ...
echo.

cd /d "%~dp0"

echo [1/2] Compilando proyecto...
call mvnw.cmd clean compile

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERROR: La compilacion fallo. Revise los errores arriba.
    pause
    exit /b 1
)

echo.
echo [2/2] Ejecutando aplicacion...
call mvnw.cmd javafx:run

pause
