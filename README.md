# Irish Dictionary Online

## Build Instructions
```
$ gradle clean build
```
### To perform a custom build based on a configuration file in `/src/main/config`
For `dev.englishirishdictionary.com`
```
$ gradle buildName -PbuildName=devenglishirish
```
For `www.englishirishdictionary.com`
```
$ gradle buildName -PbuildName=prodenglishirish
```
### To add Apache JSP support for non Gretty builds
```
$ gradle build -Papachejsp
```
