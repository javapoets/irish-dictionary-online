# Irish Dictionary Online
## Build Instructions
(Quick) For development: `localhost:8080`
```
$ gradle clean build
```
For production: `[irishdictionary.online](http://irishdictionary.online)`
```
$ gradle prod
or (the default)
$ gradle custombuild -PbuildName=irishdictionary.online
```
### To perform a "custom build" based on a configuration file in: `/src/main/config`
For development: `dev.englishirishdictionary.com:8080`
```
$ gradle custombuild -PbuildName=dev.englishirishdictionary.com
```
For production: `[englishirishdictionary.com](http://englishirishdictionary.com)`
```
$ gradle custombuild -PbuildName=englishirishdictionary.com
```
### To add Apache JSP support to the build output for non-Gretty deployments:
```
$ gradle build -Papachejsp
```
### To run the application:
Run using Gretty
```
$ gradle appRun
```
Run using the embedded Jetty server: `Windows`
```
$ bin/start-jetty-server.cmd
```
Run using the embedded Jetty server: `Linux`
```
$ . bin/start-jetty-server.sh
```