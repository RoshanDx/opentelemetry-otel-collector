PHONY: build clean

build-user:
	mvn clean install -f ./user && docker build -t garuda-user:latest ./user
build-notification:
	mvn clean install -f ./notification && docker build -t garuda-notification:latest ./notification
build-all: build-user build-notification