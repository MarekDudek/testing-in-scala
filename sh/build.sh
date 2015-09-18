#!/usr/bin/env bash

scalac -cp ./lib/scalatest_2.11-2.2.4.jar -d bin  \
	-feature -deprecation -explaintypes           \
	src/testing/*.scala                           \
	src/testing/assertions/*.scala                \
	src/testing/fixtures/different/*.scala        \
	src/testing/fixtures/same/*.scala             \
	src/testing/styles/*.scala