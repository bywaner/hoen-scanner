#!/bin/bash
./mvnw compile exec:java -Dexec.args="server config.yml"
