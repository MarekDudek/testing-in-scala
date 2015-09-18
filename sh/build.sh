#!/usr/bin/env bash

TARGET=bin

rm -fr ./${TARGET}/*

scalac -cp ./lib/scalatest_2.11-2.2.4.jar -d ${TARGET}  \
	-feature -deprecation -explaintypes                 \
	src/testing/*.scala                                 \
	src/testing/assertions/*.scala                      \
	src/testing/fixtures/different/*.scala              \
	src/testing/fixtures/same/*.scala                   \
	src/testing/styles/*.scala