#!/bin/sh
mvn archetype:generate \
 -DarchetypeGroupId=net.liftweb \
 -DarchetypeArtifactId=lift-archetype-basic_2.9.1 \
 -DarchetypeVersion=2.4-M5 \
 -DarchetypeRepository=http://scala-tools.org/repo-releases \
 -DremoteRepositories=http://scala-tools.org/repo-releases \
 -DgroupId=vaughan\
 -DartifactId=mag_art_toc \
 -Dversion=1.0
