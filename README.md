# Irish Dictionary Online
## Build Instructions
(Quick) For development: `localhost`
```
$ gradle clean build
```
### To perform a custom build based on a configuration file in `/src/main/config`:
For production: `irishdictionary.online`
```
$ gradle prod
or (the default)
$ gradle buildName -PbuildName=prodenglishirish
```
### To perform a custom build based on a configuration file in `/src/main/config`:
For development: `dev.englishirishdictionary.com`
```
$ gradle buildName -PbuildName=devenglishirish
```
For production: `www.englishirishdictionary.com`
```
$ gradle buildName -PbuildName=prodenglishirish
```
### To add Apache JSP support to the build for non Gretty deployments:
```
$ gradle build -Papachejsp
```