#!/usr/bin/env bash

	
## Whole package with subpackages
#scala -cp lib/scalatest_2.11-2.2.4.jar org.scalatest.tools.Runner -R bin \
#	-o \
#	-w testing

## Whole package without subpackages
#scala -cp lib/scalatest_2.11-2.2.4.jar org.scalatest.tools.Runner -R bin \
#	-o \
#	-m testing

## Single file
#scala -cp lib/scalatest_2.11-2.2.4.jar org.scalatest.tools.Runner -R bin \
#	-o \
#	-s testing.ExampleSpec

## Single test file
#scala -cp lib/scalatest_2.11-2.2.4.jar org.scalatest.tools.Runner -R bin \
#	-o \
#	-s testing.ExampleSpec \
#	-t "A Stack should pop values in last-in-first-out order"
	
## All in graphical mode
#scala -cp lib/scalatest_2.11-2.2.4.jar org.scalatest.tools.Runner -R bin \
#	-w testing
	