#!/bin/bash
#Change datafile name
mv ./data/datafile.mv.db ./data/datafile.mv.db$(ls ./data|wc -l)
#Exec the jar
java -jar ./target/demo-0.0.1-SNAPSHOT.jar
