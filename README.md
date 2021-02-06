# Irish Dictionary Online
## Build Instructions
(Quick) For development: `localhost`
```
$ gradle clean build
```
For production: `irishdictionary.online`
```
$ gradle prod
or (the default)
$ gradle custombuild -PbuildName=irishdictionary.online
```
### To perform a custom build based on a configuration file in `/src/main/config`:
For development: `dev.englishirishdictionary.com:8080`
```
$ gradle custombuild -PbuildName=dev.englishirishdictionary.com
```
For production: `www.englishirishdictionary.com`
```
$ gradle custombuild -PbuildName=www.englishirishdictionary.com
```
### To add Apache JSP support to the build for non-Gretty deployments:
```
$ gradle build -Papachejsp
```