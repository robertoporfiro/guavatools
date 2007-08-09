set CURRENT_DIR=.
set BEA_HOME=C:\bea
pushd .
call %BEA_HOME%\weblogic92\samples\domains\servicebus\bin\setDomainEnv

cd %CURRENT_DIR%
popd

call ant -buildfile "conf/build.xml" -DcustFile=../customizationFiles/MoveToSidEndpoint.xml

pause