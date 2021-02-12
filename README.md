Irish Dictionary Online
=======================
## Build Instructions
(Quick) For development: localhost:8080
```bash
$ gradle clean build
```
For production: [irishdictionary.online](http://irishdictionary.online)
```bash
$ gradle prod
or (the default)
$ gradle custombuild -PbuildName=irishdictionary.online
```
### To perform a "custom build" based on a configuration file in: `/src/main/config`
For development: dev.englishirishdictionary.com:8080
```bash
$ gradle custombuild -PbuildName=dev.englishirishdictionary.com
```
For production: [englishirishdictionary.com](http://englishirishdictionary.com)
```bash
$ gradle custombuild -PbuildName=englishirishdictionary.com
```
### To add Apache JSP support to the build output (for non-Gretty deployments):
```bash
$ gradle build -Papachejsp
```
### To run the application:
Run using Gretty
```bash
$ gradle appRun
```
Run using the embedded Jetty server: `Windows`
```bash
$ bin/start-jetty-server.cmd
```
Run using the embedded Jetty server: `Linux`
```bash
$ . bin/start-jetty-server.sh
```
[LICENSE](blob/master/LICENSE)