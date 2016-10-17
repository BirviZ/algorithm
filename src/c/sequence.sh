#! /bin/bash

if ! [ -d bin/ ]; then
	mkdir bin/
fi

gcc sequence/sequence.c -o bin/sequence
bin/sequence
