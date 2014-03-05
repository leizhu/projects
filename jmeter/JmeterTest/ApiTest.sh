export JVM_ARGS="-Xms1024m -Xmx1024m"
$JMETER_HOME/bin/jmeter -l "ApiTest.log" -t ApiTest.jmx
