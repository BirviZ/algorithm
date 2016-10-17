#! /bin/bash

if ! [ -d bin/ ]; then
	mkdir bin/
fi

javac algorithm/sequence/Sequence.java -d bin/
java -classpath bin/ algorithm.sequence.Sequence
