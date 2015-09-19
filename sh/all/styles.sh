#!/usr/bin/env bash

scala -cp bin:lib/scalatest_2.11-2.2.4.jar org.scalatest.run \
	testing.styles.FunSuiteStyle \
	testing.styles.FlatSpecStyle \
	testing.styles.FunSpecStyle \
	testing.styles.WordSpecStyle \
	testing.styles.FreeSpecStyle \
	testing.styles.SpecStyle \
	testing.styles.PropSpecStyle \
	testing.styles.FeatureSpecStyle
